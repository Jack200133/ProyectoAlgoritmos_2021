import java.util.*;


public class Evaluar<V,F> {
    private Operaciones op;
    private Quote quote;

    public Evaluar(){
        op = new Operaciones();
        quote = new Quote();

    }

    

    private HashMap<V, F> almacen = new HashMap<V, F>();

    public String Evaluo(String input,Scanner scan) {
        //input = input.replaceAll("\\s","");

        //(define vaca (cond a b))
        //String[] temp = input.split("()");
        String res = "";

       // ( quote 12 )
        //( + ( + ( - 3 1 ) ( * 2 1 ) ) (  + 3 1 ) )
        for (int i = 0; i < input.length(); i++) {
            if(scan.hasNext()){
                String tem = scan.next();

                if (tem.equals(")")) {
                    res = queso(res);
                    return res;
                }else if (!tem.equals("(")) {
                    res += tem;
                    res += " ";
                }else{
                    res += Evaluo(input,scan);

                }
            }

        }
        return res;
    }

    public String queso(String input){

        String res = "";


        if (input.contains("define")) {
            System.out.print("Funcion");

        }
        else if (input.contains("quote")) {
            return quote.DeQuote(input);
            

        }
        else if (input.contains("setq")) {
            System.out.print("SetQ");

        }
        else if (input.contains("cond")) {
            System.out.print("Condicionañles");

        }
        else if (input.contains("atom") || input.contains("listp") || input.contains("equal") || input.contains(">") || input.contains("<")) {
            System.out.print("Predicados");

        }
        else {
            String[] temp = input.split(" ");
            System.out.println(Arrays.toString(temp));
            if(temp.length>3){
                res = op.Operar(temp[2],temp[4],temp[0]);
            }else if(temp.length==3){
                res = op.Operar(temp[1],temp[2],temp[0]);
            }else{
                String[] temp1 = temp[1].split("");
                res = op.Operar(temp1[0],temp1[1],temp[0]);
            }



        }
        return res;

    }

}
