import java.util.ArrayList;

public class Not implements Operation{
    Element el;
    Not(Element el) {
        this.el = el;
    }

    public boolean getResult(ArrayList<String> arr, String s) {
        return !el.getResult(arr, s);
    }
}
