public class Predicados {

    public Predicados() {

    }

    public String atom(String input) {
        
    }

    public String listp(String input) {

    }

    public boolean equals(String input) {
        String temp[] = input.split(" ");
        int length = temp.length;
        String first = temp[1];
        boolean state = true;
        for(int i = 1; i < length; i++) {
            if(temp[i].equals(first)) {
                state = true;
            } else {
                state = false;
                return state;
            }
        }
        return state;
    }

    public boolean biggerThan(String input) {
        String temp[] = input.split(" ");
        int length = temp.length;
        int comparison1 = Integer.parseInt(temp[1]);
        boolean state = true;
        for(int i = 2; i < length; i++) {
            int comparison2 = Integer.parseInt(temp[i]);
            if(comparison1 > comparison2) {
                state = true;
                comparison1 = comparison2;
            } else {
                state = false;
                return state;
            }
        }
        return state;
    
    }

    public boolean smallerThan(String input) {
        String temp[] = input.split(" ");
        int length = temp.length;
        int comparison1 = Integer.parseInt(temp[1]);
        boolean state = true;
        for(int i = 2; i < length; i++) {
            int comparison2 = Integer.parseInt(temp[i]);
            if(comparison1 < comparison2) {
                state = true;
                comparison1 = comparison2;
            } else {
                state = false;
                return state;
            }
        }
        return state;
    }

}
