import java.lang.*;

public class Quote {

    public Quote() {
        
    }

    public String DeQuote(String input) {
        
        int lastIndex = input.length();

        String QuotedInput = insertString(insertString(input, "(", 0), ")", lastIndex);

        return QuotedInput;

    }

    private String insertString(String original, String insert, int index){

        String newString = new String();

        for (int i = 0; i < original.length(); i++) {
            newString += original.charAt(i);

            if(i == index) {
                newString += insert;    
            }
        }
        return newString;
    }

}
