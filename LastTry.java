import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class LastTry {


    // :NOTE: * копипаста
    // :NOTE: * почему не встроенная сортировка?
    public static void merge(String[] arr1, String[] arr2, String[] arr3){
        int i = 0;
        int j = 0;
        int k = 0;
        while ((i < arr1.length) && (j < arr2.length)) {
            if (arr1[i].compareTo(arr2[j]) < 0) {
                arr3[k] = arr1[i];
                i++;
            } else {
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
    }

    public static void mergeNoCase(String[] arr1, String[] arr2, String[] arr3){
        int i = 0;
        int j = 0;
        int k = 0;
        while ((i < arr1.length) && (j < arr2.length)) {
            String a = arr1[i].toLowerCase();
            String b = arr2[j].toLowerCase();
            if (a.compareTo(b) < 0) {
                arr3[k] = arr1[i];
                i++;
            } else {
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
    }

    public static void mergeNoBlanks(String[] arr1, String[] arr2, String[] arr3){
        int i = 0;
        int j = 0;
        int k = 0;
        while ((i < arr1.length) && (j < arr2.length)) {
            StringBuilder a = new StringBuilder();
            for (int v = 0; v < arr1[i].length(); v++)
            {
                if (!Character.isWhitespace(arr1[i].charAt(v))) {
                    a.append(arr1[i].charAt(v));
                }
            }
            StringBuilder b = new StringBuilder();
            for (int v = 0; v < arr2[j].length(); v++)
            {
                if (!Character.isWhitespace(arr2[j].charAt(v))) {
                    b.append(arr2[j].charAt(v));
                }
            }
            if (a.compareTo(b) < 0) {
                arr3[k] = arr1[i];
                i++;
            } else {
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
    }

    public static void mergeAlphanumeric(String[] arr1, String[] arr2, String[] arr3){
        int i = 0;
        int j = 0;
        int k = 0;
        while ((i < arr1.length) && (j < arr2.length)) {
            StringBuilder a = new StringBuilder();
            for (int v = 0; v < arr1[i].length(); v++)
            {
                if (Character.isDigit(arr1[i].charAt(v)) || Character.isLetter(arr1[i].charAt(v))) {
                    a.append(arr1[i].charAt(v));
                }
            }
            StringBuilder b = new StringBuilder();
            for (int v = 0; v < arr2[j].length(); v++)
            {
                if (Character.isDigit(arr2[j].charAt(v)) || Character.isLetter(arr2[j].charAt(v))) {
                    b.append(arr2[j].charAt(v));
                }
            }
            if (a.compareTo(b) < 0) {
                arr3[k] = arr1[i];
                i++;
            } else {
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
    }

    public static void mergeNumbers(String[] arr1, String[] arr2, String[] arr3){
        int i = 0;
        int j = 0;
        int k = 0;
        while ((i < arr1.length) && (j < arr2.length)) {
            StringBuilder a = new StringBuilder();
            for (int v = 0; v < arr1[i].length(); v++)
            {
                if (Character.isDigit(arr1[i].charAt(v))) {
                    a.append(arr1[i].charAt(v));
                }
            }
            StringBuilder b = new StringBuilder();
            for (int v = 0; v < arr2[j].length(); v++)
            {
                if (Character.isDigit(arr2[j].charAt(v))) {
                    b.append(arr2[j].charAt(v));
                }
            }
            if (a.compareTo(b) < 0) {
                arr3[k] = arr1[i];
                i++;
            } else {
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
    }

    // :NOTE: # опции не комбинируются


    public static String[] mergeSort(String[] arr, int a) {
        if (arr.length == 1) {
            return arr;
        }
        String[] arr1 = new String[arr.length / 2];
        String[] arr2 = new String[arr.length - arr.length / 2];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[arr.length / 2 + i];
        }
        arr1 = mergeSort(arr1, a);
        arr2 = mergeSort(arr2, a);
        switch (a) {
            case 0:
                merge(arr1, arr2, arr);
                break;
            case 1:
                mergeNoBlanks(arr1, arr2, arr);
                break;
            case 2:
                mergeAlphanumeric(arr1, arr2, arr);
                break;
            case 3:
                mergeNoCase(arr1, arr2, arr);
                break;
            case 5:
                mergeNumbers(arr1, arr2, arr);
                break;
        }
        return arr;
    }

    public static String[] sort(Scanner s, String fl, int a) {
        String[] arr = new String[1024];
        arr[0] = fl;
        int count = 1;
        while (s.hasNextLine()) {
            if (count == arr.length) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
            arr[count] = s.nextLine();
            count++;
        }
        arr = Arrays.copyOf(arr, count);
        arr = mergeSort(arr, a);
        return arr;
    }

    public static String[] reverseSort(Scanner s, String fl) {
        String[] arr = sort(s, fl, 0);
        String[] newArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            newArr[i] = arr[arr.length - 1 - i];
        }
        return newArr;
    }

    // :NOTE: * утечка ресурсов
    public static void main(String[] args) {
        //-b, --ignore-leading-blanks
        //ignore leading blanks

        //-d, --dictionary-order
        //consider only blanks and alphanumeric characters

        //-f, --ignore-case
        //fold lower case to upper case characters

        //-i, --ignore-nonprinting
        //consider only printable characters
        //(только непробельные символы)
        //тоже самое, что -b?

        //-n, --numeric-sort
        //compare according to string numerical value

        //-r, --reverse
        //reverse the result of comparisons

        //опция, если есть, должна быть в args[0], или в первой строке ввода в консоль по типу:
        //"-r"
        //"..."

        int type;
        String option = "";
        String fl = "";

        boolean flag = false;
        Scanner s;

        // если args[0] существует - ввод ожидается от туда (должно содержаться полное имя файла), иначе с консоли
        if (args.length == 1)
        {
            Path p = Paths.get(args[0]);
            try {
                s = new Scanner(p);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            option = args[0];
        } else if (args.length == 2){
            Path p = Paths.get(args[1]);
            try {
                s = new Scanner(p);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fl = args[0];
        } else {
            flag = true;
            s = new Scanner(System.in);
            fl = s.nextLine();
            if (fl.length() == 2) {
                option = fl.substring(0, 2);
            }
        }

        if (option.equals("-b ") || option.equals("-b")) {
            type = 1;
        } else if (option.equals("-d ") || option.equals("-d")) {
            type = 2;
        } else if (option.equals("-f ") || option.equals("-f")) {
            type = 3;
        } else if (option.equals("-i ") || option.equals("-i")) {
            type = 4;
        } else if (option.equals("-n ") || option.equals("-n")) {
            type = 5;
        } else if (option.equals("-r ") || option.equals("-r")) {
            type = 6;
        } else {
            type = 0;
        }

        if (type != 0 && flag) {
            fl = s.nextLine();
        }
        
        String[] result = new String[0];
        switch (type) {
            case 0:
                result = sort(s, fl, 0);
                break;
            case 1, 4:
                result = sort(s, fl, 1);
                break;
            case 2:
                result = sort(s, fl, 2);
                break;
            case 3:
                result = sort(s, fl, 3);
                break;
            case 5:
                result = sort(s, fl, 5);
                break;
            case 6:
                result = reverseSort(s, fl);
                break;
        }
        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
    }
}
