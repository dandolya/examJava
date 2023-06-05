import java.util.ArrayList;

public class Const implements Element{
    char el;
    Const(char el) {
        this.el = el;
    }

    public boolean getResult(ArrayList<String> arr, String s) {
        if (el == '0') {
            return false;
        } else {
            return true;
        }
    }
}
