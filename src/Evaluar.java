import java.util.HashMap;


public class Evaluar<V,F> {
    private Operaciones op;
    public Evaluar(){
        op = new Operaciones();
    }

    private HashMap<V, F> almacen = new HashMap<V, F>();

    public String Evaluo(String input) {
        //input = input.replaceAll("\\s","");

        //(define vaca (cond a b))
        String[] temp = input.split("()");
        String res = "";

        if (input.contains("define")) {
            System.out.print("Funcion");

        } else if (input.contains("quote")) {
            System.out.print("Quote ");

        } else if (input.contains("setq")) {
            System.out.print("SetQ");

        } else if (input.contains("cond")) {
            System.out.print("Condicionañles");

        }else if (input.contains("atom") || input.contains("listp") || input.contains("equal") || input.contains(">") || input.contains("<")) {
            System.out.print("Predicados");

        } else {
            if(temp[0].equals("+")||temp[0].equals("*") ||temp[0].equals("-")||temp[0].equals("/")){
                for (int i = 1; i <= temp.length - 2; i++) {
                    temp[i-1] = temp[i];
                }
                String opera = "";
                for (int i = 0; i <= temp.length-3; i++) {
                    opera+=temp[i];
                }
                res = op.Operar(opera);
                //System.out.println(op.Operar(opera));
            }else{
                for (int i = 1; i <= temp.length - 2; i++) {
                    temp[i-1] = temp[i];
                }
                String opera = "";
                for (int i = 0; i <= temp.length-3; i++) {
                    opera+=temp[i];
                }
                res = op.Operar(opera);
                //System.out.println(op.Operar(opera));
            }


        }
        return res;
    }

}
