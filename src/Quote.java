import java.lang.*;


public class Quote {

    public Quote() {
        
    }

    public String DeQuote(String input) {

        input = input.substring(input.lastIndexOf("("),input.indexOf(")") + 1);
        /*
        int lastIndex = input.length();

        String QuotedInput = insertString(insertString(input, "(", 0), ")", lastIndex);*/

        //return QuotedInput;

        return input;

    }

    /*private String insertString(String original, String insert, int index){

        String newString = new String();

        for (int i = 0; i < original.length(); i++) {
            newString += original.charAt(i);

            if(i == index) {
                newString += insert;    
            }
        }
        return newString;
    }*/

}
