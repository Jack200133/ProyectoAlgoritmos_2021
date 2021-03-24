import java.util.Arrays;

public class SetQ {
    
    private String q;

    public SetQ() {
    }

    public SetQ(String in) {
        q = in;
    }

    public SetQ defq(String input) {
        String[] temp = input.split(" ");
        String res = "";
        if (temp[3].equals("(")){
            for(int i = 3; i < temp.length-1;i++){
                res+= temp[i];
            }
            return new SetQ(res);
        }
        return new SetQ(temp[3]);
        
    }

    public String getvalor(){
        return q;
    }

    @Override
    public String toString() {
        return (q);
    }

}
