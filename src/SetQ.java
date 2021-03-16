public class SetQ {
    
    private Quote q;

    public SetQ() {
        q = new Quote();
    }

    public String setQ(String input) {
        input = q.DeQuote(input);
        String temp[] = input.split(" ");
        System.out.println(Arrays.toString(temp));
        return temp[2];
        
    }

    private String toString() {
        String[] temp = hacer.split("");
        StringBuilder ve = new StringBuilder();
        for (String s : temp) {
            ve.append(s);
            ve.append(" ");
        }
        ve.deleteCharAt(temp.length+2);
        return (" ("+ve +")");
    }

}
