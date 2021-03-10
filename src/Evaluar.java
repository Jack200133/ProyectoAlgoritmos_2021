import java.util.HashMap;

public class Evaluar<V,F> {
    private Operaciones op;
    public Evaluar(){
        op = new Operaciones();
    }

    private HashMap<V, F> almacen = new HashMap<V, F>();

    public String Evaluo(String input){
        input = input.replaceAll("\\s","");
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

            for (int i = 1; i <= temp.length - 2; i++) {
                    temp[i-1] = temp[i];
            }
           String opera = "";
            for (int i = 0; i <= temp.length-3; i++) {
                opera+=temp[i];
            }
            System.out.println(op.Operar(opera));


            for (int i = 0; i <= temp.length - 1; i++) {

                if (temp[i].equals(")")) {
                    res += temp[i];
                    break;

                } else {
                    res += temp[i];
                }
            }
            // (+ 3 (* 2 5) )
            String[] tamp = res.split("()");
            String ras = "";
            for (int i = tamp.length - 1; i >= 0; i--) {
                if (tamp[i].equals("(")) {
                    ras += tamp[i];
                    break;
                    //Evaluo(res);
                } else {
                    ras += tamp[i];
                }
            }
            //System.out.print(res);
          /**  String rus = ras.replaceAll("\\(", "");
            String ros = rus.replaceAll("\\)", "");

            String[] timp = ros.split(" ");
            if (timp[2]== "+"&&timp[2]== "-"){

             }
            //String opros = op.Operar(timp[0],timp[1],timp[2]);
            for (int i = 0; i <= timp.length - 1; i++) {
                System.out.print("\n" + timp[i]);
            }
            //System.out.print("\n"+opros);
            //System.out.print("\n"+answer);
            // (define vaca (------))
            //input =  (+ (-(* 1 1) 3) (-5 3))
           // (* (- 3 2) (+ 1 (/ 1 1))))
            // res = (+ (-(* 1 1
            // ras = )* 1 1(
            return res;
            */
        }
        return null;
    }

}
