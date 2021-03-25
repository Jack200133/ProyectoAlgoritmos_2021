import java.util.*;


public class Evaluar<V,F> {
    private final Operaciones op;
    private final Quote quote;
    private final Funciones fun;
    private final Variables van;
    private final SetQ setq;
    private final Predicados pred;
    private final Condicionales cond;

    public Evaluar(){
        op = new Operaciones();
        quote = new Quote();
        fun = new Funciones();
        setq = new SetQ();
        van = new Variables();
        pred = new Predicados();
        cond = new Condicionales();
    }

    

    private HashMap<V, F> almacen = new HashMap<V, F>();

    public String Evaluo(String input,Scanner scan) {

        String res = "";

        // ( cond ( ( = n 1 ) 1 ) ( t 0 ) )
        // ( defun fatorial ( n ) ( cond ( ( = n 1 ) 1 ) ( t ( * n ( fatorial ( - n 1 ) ) ) ) ) )
       // ( defun fibonacci ( n ) ( cond ( ( = n 0 ) 0 ( ( = n 1 ) 1 ) ( t ( + ( fibonacci ( - n 1 ) ) ( fibonacci ( - n 2 ) ) ) ) ) )

        for (int i = 0; i < input.length(); i++) {
            if(scan.hasNext()){
                String tem = scan.next();
                if (tem.equals(")")) {
                    res = queso(res,input);
                    return res;
                }else if (!tem.equals("(")) {
                    res += tem;
                    res+=" ";
                }else{
                    System.out.println("1. Primer eval"+input); // hay que borrar
                    if(!res.contains("T")){
                        res+= Evaluo(input, scan);
                        res+= " ";
                    }else{
                        return ("T");
                    }
                }

            }

        }
        return res;
    }

    public String Evaluo(String input) {
        Scanner scan = new Scanner(input);

        String res = "";


        for (int i = 0; i < input.length(); i++) {
            System.out.println("EL RES: " +res);//borrar
            if(scan.hasNext()){
                String tem = scan.next();

                if (tem.equals(")")) {

                    res = queso(res,input);
                    return res;
                }else if (!tem.equals("(")) {
                    res += tem;
                    res+=" ";

                }else{
                    System.out.println("1. Primer eval"+input); // hay que borrar
                    if(!res.contains("T")){
                        res+= Evaluo(input, scan);
                        res+= " ";
                    }else{
                        return ("T");
                    }
                }

                // System.out.println(res); // borrar
            }


        }
        return res.toString();
    }

    public String queso(String input,String completo) {

        String res;
        String[] temp = input.split(" ");
       // System.out.println("QUESO " + Arrays.toString(temp)); // best print

        if (input.contains("defun")) {
            if (!almacen.containsKey(temp[1])) {
                almacen.put((V) temp[1], (F) fun.Defun(completo));
                System.out.println(almacen);
                return "Se agrego la funcion " + temp[1];
            } else {

                Funciones fe = (Funciones) almacen.get(temp[1]);

                String e = fe.loquehace(temp[2]);
                res = Evaluo(e);
                return res;
            }


        }
        else if (temp[0].equals("cond")&&temp[1].equals("T")){
            //AQUI VA LA BANDERA
            String ros = "";
            for (int i = 2; i < temp.length; i++) {
                ros += temp[i];
                ros += " ";
            }
            return queso(ros,"");

        }
        else if (input.contains("cond")) {
            Condicionales condicion = cond.Condi(input, completo);

            if (condicion.Estado().equals("T")) {
                return Evaluo(temp[2]);
            } else {
                return Evaluo(condicion.Condicionar());
            }

        }
        else if (input.contains("defvar")) {
            if (!almacen.containsKey(temp[1])) {

                almacen.put((V) temp[1], (F) van.Defvar(completo));
                return "Se agrego la variable " + temp[1];

            } else {

                res = (String) almacen.get(temp[1]);
                return res;
            }


        }
        else if (input.contains("quote") || input.contains("'")) {
            return quote.DeQuote(input);


        }
        else if (input.contains("setq")) {
            if (!almacen.containsKey(temp[1])) {

                almacen.put((V) temp[1], (F) setq.defq(completo));
                return "Se agrego el setq " + temp[1];

            } else {

                res = (String) almacen.get(temp[1]);
                return res;
            }


        }
        else if (input.contains("atom")) {
            if (!almacen.containsKey(temp[1])) {
                return "T";
            } else {
                return "NIL";
            }

        }
        else if (input.contains("listp")) {
            if (!almacen.containsKey(temp[1])) {
                return "NIL";

            } else {
                return "T";
            }
        }
        else if (temp[0].equals("=")&&input.contains("T")){
            return temp[temp.length-1];
        }
        else if (input.contains("equal") || input.contains("=")) {
            if (pred.equals(input)) {
                return "T";
            } else {
                return "NIL";
            }
        }
        else if (input.contains(">")) {
            if (pred.biggerThan(input)) {
                return "T";
            } else {
                return "NIL";
            }
        }
        else if (input.contains("<")) {
            if (pred.smallerThan(input)) {
                return "T";
            } else {
                return "NIL";
            }
        }
        else if (almacen.containsKey(temp[0])) {
            //if de .Class para fun y var
            if (almacen.get(temp[0]).getClass() == fun.getClass()) {
                Funciones fe = (Funciones) almacen.get(temp[0]);
                String e;
                if ( temp.length > 2){
                    e = fe.loquehace(temp[temp.length - 1]);
                }else{
                    e = fe.loquehace(temp[1]);
                }
                res = Evaluo(e);


                return res;
            } else if (almacen.get(temp[0]).getClass() == van.getClass()) {
                Variables va = (Variables) almacen.get(temp[0]);
                res = va.getvalor();
                return res;
            } else if (almacen.get(temp[0]).getClass() == setq.getClass()) {
                SetQ st = (SetQ) almacen.get(temp[0]);
                res = st.getvalor();
                return res;
            }

        }

        else if (input.contains("T")){
            int t = 0;
            if(temp.length > 2) {
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].equals("T")) {
                        t = i;
                    }
                }
                String til = "";
                for (int i = 0; i < t; i++) {
                    til += temp[i];
                    til += " ";
                }
                for (int i = t+1; i < temp.length; i++) {
                    til += temp[i];
                    til += " ";
                }
                return queso(til,"");
            }
            return temp[1]+ " "+ temp[0];
        }
        else {
                if(temp.length > 2)
                {
                    res = op.Operar(input);
                    return res;
                } else if(temp[0].equals("T")||temp[0].equals("t")){
                    return temp[1];
                } else if (temp[0].equals("*")||temp[0].equals("+")||temp[0].equals("-")||temp[0].equals("/")){
                    return temp[1];
                }
        }
        return input;

    }

}
