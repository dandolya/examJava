import java.util.ArrayList;

public class And implements Operation{
    Element el1;
    Element el2;
    And(Element el1, Element el2) {
        this.el1 = el1;
        this.el2 = el2;
    }

    public boolean getResult(ArrayList<String> arr, String s) {
        return el1.getResult(arr, s) && el2.getResult(arr, s);
    }
}
