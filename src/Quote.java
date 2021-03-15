import java.lang.*;
import java.util.Arrays;


public class Quote {

    public Quote() {
        
    }

    public String DeQuote(String input) {
        String[] temp = input.split(" ");
        return temp[1];

    }

}
