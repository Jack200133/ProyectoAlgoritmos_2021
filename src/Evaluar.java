import java.util.HashMap;

public class Evaluar<V,F> {
    public Evaluar(){

    }

    HashMap<V, F> almacen = new HashMap<V, F>();

    public String Evaluo(String input){
        input = input.replaceAll("\\s","");
        String[] temp = input.split("()");
        for(int i = temp.length; i > 0;i--){
            if(temp[i].equals("(")){

            }
        }
        // (+ (-5 3) 6)
        return null;
    }

}
