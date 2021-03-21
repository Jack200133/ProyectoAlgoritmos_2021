import java.util.*;


public class Evaluar<V,F> {
    private final Operaciones op;
    private final Quote quote;
    private final Funciones fun;
    private final Variables van;
    private final SetQ setq;
    private final Predicados pred;

    public Evaluar(){
        op = new Operaciones();
        quote = new Quote();
        fun = new Funciones();
        setq = new SetQ();
        van = new Variables();
        pred = new Predicados();
    }

    

    private HashMap<V, F> almacen = new HashMap<V, F>();

    public String Evaluo(String input,Scanner scan) {



        StringBuilder res = new StringBuilder();

        //( defun doble ( x ) ( * x 2 ) )
        //( defun doble ( x ) ( * ( - x 1 )  x ) )
        //( defun doble ( 2 ) )
        // ( quote 12 )
        // ( defun fatorial ( n ) ( cond ( ( = n 1 ) 1 ) ( t ( * n ( fatorial ( - n 1 ) ) ) ) ) )

        for (int i = 0; i < input.length(); i++) {
            if(scan.hasNext()){
                String tem = scan.next();

                if (tem.equals(")")) {
                    res = new StringBuilder(queso(res.toString(),input));
                    return res.toString();
                }else if (!tem.equals("(")) {
                    res.append(tem);
                    res.append(" ");
                }else{
                    res.append(Evaluo(input, scan));
                    res.append(" ");

                }
            }

        }
        return res.toString();
    }

    public String Evaluo(String input) {
        Scanner scan = new Scanner(input);

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if(scan.hasNext()){
                String tem = scan.next();

                if (tem.equals(")")) {
                    res = new StringBuilder(queso(res.toString(),input));
                    return res.toString();
                }else if (!tem.equals("(")) {
                    res.append(tem);
                    res.append(" ");
                }else{
                    res.append(Evaluo(input, scan));
                    res.append(" ");

                }
            }

        }
        return res.toString();
    }

    public String queso(String input,String completo){

        String res = "";
        String[] temp = input.split(" ");


        if (input.contains("defun") ) {
            
            if(!almacen.containsKey(temp[1])){

                almacen.put((V)temp[1], (F) fun.Defun(completo));
                System.out.println(almacen);
            }
            else{

                Funciones fe = (Funciones) almacen.get(temp[1]);

                String e = fe.loquehace(temp[2]);
                res = Evaluo(e);
                return res;
            }


        }
        else if (input.contains("defvar")) {

            if(!almacen.containsKey(temp[1])){

                almacen.put((V)temp[1], (F) van.Defvar(completo));
                System.out.println(almacen);
            }
            else{

                res = (String) almacen.get(temp[1]);
                return res;
            }


        }
        else if (input.contains("quote")) {
            return quote.DeQuote(input);
            
            
        }
        else if (input.contains("setq")) {
            
            if(!almacen.containsKey(temp[1])){
                
                almacen.put((V)temp[1], (F) setq.setQ(input));
                System.out.println(almacen);
            }
            

        }
        else if (input.contains("cond")) {
            System.out.print("Condicionañles");

        }
        else if (input.contains("atom")) {
            System.out.print(pred.atom(input));

        } else if (input.contains("listp")){
            System.out.print("Listp");
        } else if (input.contains("equal")) {
            if(pred.equals(input)) {
                System.out.println(input + "es T");
            } else {
                System.out.println(input + "es NIL");
            }
        } else if (input.contains(">")) {
            if(pred.biggerThan(input)) {
                System.out.println(input + "es T");
            } else {
                System.out.println(input + "es NIL");
            }
        } else if (input.contains("<")) {
            if(pred.smallerThan(input)) {
                System.out.println(input + "es T");
            } else {
                System.out.println(input + "es NIL");
            }
        }
        else if(almacen.containsKey(temp[0])){
            //if de .Class para fun y var
            if (almacen.get(temp[0]).getClass() == fun.getClass()){
                Funciones fe = (Funciones) almacen.get(temp[0]);

                String e = fe.loquehace(temp[1]);
                res = Evaluo(e);
                return res;
            } else if (almacen.get(temp[0]).getClass() == van.getClass()){
                Variables va = (Variables) almacen.get(temp[0]);
                res = va.getvalor();
                return res;
            }

        }
        else {

                if(temp.length > 2)
                {
                    res = op.Operar(input);
                    return res;
                }

        }
        return input;

    }

}
