import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean isLetter(char ch) {
        for (int i = 97; i < 123; i++) {
            if (ch == (char) i) {
                return true;
            }
        }
        return false;
    }

    public static String tobin(int n, double d) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        while (sb.length() < d) {
            sb.append('0');
        }
        sb.reverse();
        return sb.toString();
    }

    public static int getNum(ArrayList<String> arr, char ch) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(String.valueOf(ch))) {
                return i;
            }
        }
        return -1;
    }

    static int varCount = 0;
    static ArrayList<String> chars = new ArrayList<String>();

    public static Element parser(String myS) {
        Element s = null;
        Element el2 = null;
        int operation = -1;
        boolean not = false;
        for (int i = 0; i < myS.length(); i++) {
            if (myS.charAt(i) == '0' || myS.charAt(i) == '1') {
                if (s == null) {
                    s = new Const(myS.charAt(i));
                } else {
                    el2 = new Const(myS.charAt(i));
                }
            }
            if (isLetter(myS.charAt(i))) {
                if (getNum(chars, myS.charAt(i)) == -1) {
                    chars.add(String.valueOf(myS.charAt(i)));
                    varCount++;
                }
                if (s == null) {
                    s = new Variable(myS.charAt(i));
                } else {
                    el2 = new Variable(myS.charAt(i));
                }
            }
            if (myS.charAt(i) == '&') {
                operation = 1;
            }else if (myS.charAt(i) == '|') {
                operation = 2;
            }else if (myS.charAt(i) == '~') {
                not = true;
            }
            if (myS.charAt(i) == '(') {
                int j = i;
                while (myS.charAt(j) != ')') {
                    j++;
                }
                if (s == null) {
                    s = parser(myS.substring(i + 1, j));
                } else {
                    el2 = parser(myS.substring(i + 1, j));
                }
                i = j - 1;
            }
            if (s != null && el2 != null && not) {
                el2 = new Not(el2);
                not = false;
            } else if (s != null && not) {
                s = new Not(s);
                not = false;
            }
            if (s != null && el2 != null) {
                if (operation == 1) {
                    s = new And(s, el2);
                    el2 = null;
                } else if (operation == 2) {
                    s = new Or(s, el2);
                    el2 = null;
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String myS;
        Scanner in = new Scanner(System.in);
        myS = in.nextLine();

        Element s = parser(myS);

        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[(int) Math.pow(2, varCount)];
        for (int i = 0; i < Math.pow(2, varCount); i++) {
            String str = tobin(i, varCount);
            arr[i] = s.getResult(chars, str);
            if (arr[i] == true) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                for (int j = 0; j < chars.size(); j++) {
                    if (str.charAt(j) == '1') {
                        sb.append(chars.get(j));
                    } else {
                        sb.append("~" + chars.get(j));
                    }
                    if (j != chars.size() - 1) {
                        sb.append('&');
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
