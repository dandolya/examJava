import java.util.ArrayList;

public class Variable implements Element{
    char el;
    Variable(char el) {
        this.el = el;
    }

    public static int getNum(ArrayList<String> arr, char ch) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(String.valueOf(ch))) {
                return i;
            }
        }
        return -1;
    }

    public boolean getResult(ArrayList<String> arr, String s) {
        int a = getNum(arr, el);
        if (s.charAt(a) == '0') {
            return false;
        } else {
            return true;
        }
    }

    public char getChar(){
        return el;
    }
}
