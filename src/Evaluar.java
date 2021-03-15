import java.util.*;


public class Evaluar<V,F> {
    private final Operaciones op;
    private final Quote quote;
    private final Funciones fun;

    public Evaluar(){
        op = new Operaciones();
        quote = new Quote();
        fun = new Funciones();

    }

    

    private HashMap<V, F> almacen = new HashMap<V, F>();

    public String Evaluo(String input,Scanner scan) {



        StringBuilder res = new StringBuilder();

        //( define doble ( * x 2 ) )
        // ( quote 12 )
        //(defun area-circle(rad)
        //   "Calculates area of a circle with given radius"
        //   (terpri)
        //   (format t "Radius: ~5f" rad)
        //   (format t "~%Area: ~10f" (* 3.141592 rad rad))
        //)
        //(define fact (lambda (n) (if (= n 0) 1 (* n (fact(- n 1)) ))
        //))
        //( + ( + ( - 3 1 ) ( * 2 1 ) ) (  + 3 1 ) )
        for (int i = 0; i < input.length(); i++) {
            if(scan.hasNext()){
                String tem = scan.next();

                if (tem.equals(")")) {
                    res = new StringBuilder(queso(res.toString()));
                    return res.toString();
                }else if (!tem.equals("(")) {
                    res.append(tem);
                    res.append(" ");
                }else{
                    res.append(Evaluo(input, scan));

                }
            }

        }
        return res.toString();
    }

    public String queso(String input){

        String res = "";
        String[] temp = input.split(" ");

        if (input.contains("defun")) {

            if(!almacen.containsKey(temp[1])){

                almacen.put(temp[1], (F) fun.Defun(input));
                System.out.println(almacen);
            }
            System.out.print("Funcion");

        }
        else if (input.contains("defvar")) {
            System.out.print("Variable");

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
