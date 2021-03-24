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

        StringBuilder res = new StringBuilder();

        // ( cond ( ( = n 1 ) 1 ) ( t 0 ) )
        // ( defun fatorial ( n ) ( cond ( ( = n 1 ) 1 ) ( t ( * n ( fatorial ( - n 1 ) ) ) ) ) )
       // ( defun fibonacci ( n ) ( cond ( ( = n 0 ) 0 ( ( = n 1 ) 1 ) ( t ( + ( fibonacci ( - n 1 ) ) ( fibonacci ( - n 2 ) ) ) ) ) )

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
                    //System.out.println(input);// borrar
                    res.append(Evaluo(input, scan));
                    res.append(" ");

                }
               // System.out.println(res); // borrar
            }


        }
        return res.toString();
    }

    public String queso(String input,String completo){

        String res;
        String[] temp = input.split(" ");


        if (input.contains("defun") ) {
            
            if(!almacen.containsKey(temp[1])){
                almacen.put((V)temp[1], (F) fun.Defun(completo));
                System.out.println(almacen);
                return "Se agrego la funcion " + temp[1];
            }
            else{

                Funciones fe = (Funciones) almacen.get(temp[1]);

                String e = fe.loquehace(temp[2]);
                res = Evaluo(e);
                return res;
            }


        }

        else if (input.contains("condf")){
            String[] tamp = completo.split(" ");
            int ontast = 0;
            String pruebas = "";
            String positivo = "";
            String evluar = "";
            int cintpar = 0;

            for (int i = 11; i < tamp.length; i++) {

                if (tamp[i].equals("t")){
                    ontast = i;
                }
            }
            for (int i = ontast+1; i < tamp.length ; i++) {
                pruebas += tamp[i];
                pruebas += " ";
            }
            for ( int i = 7; i < ontast - 2 ; i++){

                if(cintpar > 0){
                    positivo += tamp[i];
                    positivo += " ";
                }
                if(tamp[i].equals(")")){
                    cintpar += 1;
                }
            }
            cintpar = 0;
            for (int i = 7; i < ontast-2; i++) {
                if(cintpar > 1){
                    evluar += tamp[i];
                    evluar += " ";
                }
                if(tamp[i].equals("(")){
                    cintpar += 1;
                }
                if(tamp[i].equals(")")){
                    cintpar -= 3;
                }
            }
            System.out.println("LO QUE SE EVALAUA: " + evluar);
            System.out.println("Positivi : " + positivo);
            System.out.println("Negativo : " + pruebas);
            System.out.println("LOEVALUADO: " + Evaluo(evluar));
            if(Evaluo(evluar).equals("T")){
                return positivo;
            }else {
                return pruebas;
            }
        }
        else if (input.contains("cond")) {

            Condicionales condicion = cond.Condi(input,completo);

            if (condicion.Estado().equals("T")){
                return Evaluo(temp[2]);
            }else {
                return Evaluo(condicion.Condicionar());
            }

        }
        else if (input.contains("defvar")) {

            if(!almacen.containsKey(temp[1])){

                almacen.put((V)temp[1], (F) van.Defvar(completo));
                return "Se agrego la variable " + temp[1];

            }
            else{

                res = (String) almacen.get(temp[1]);
                return res;
            }


        }
        else if (input.contains("quote")||input.contains("'")) {
            return quote.DeQuote(input);
            
            
        }
        else if (input.contains("setq")) {
            
            if(!almacen.containsKey(temp[1])){
                
                almacen.put((V)temp[1], (F) setq.defq(completo));
                return "Se agrego el setq " + temp[1];

            }else{

                res = (String) almacen.get(temp[1]);
                return res;
            }
            

        }
        else if (input.contains("atom")) {
            if(!almacen.containsKey(temp[1])) {
                System.out.println(input + " es T");
                return "T";
            } else {
                System.out.println(input + " es NIL");
                return "NIL";
            }

        }
        else if (input.contains("listp")){
            if(!almacen.containsKey(temp[1])) {
                System.out.println(input + " es NIL");
                return "NIL";

            } else {
                System.out.println(input + " es T");
                return "T";
            }
        }
        else if (input.contains("equal") || input.contains("=")) {
            if(pred.equals(input)) {
                System.out.println(input + "es T");
                return "T";
            } else {
                System.out.println(input + "es NIL");
                return "NIL";
            }
        }
        else if (input.contains(">")) {
            if(pred.biggerThan(input)) {
                System.out.println(input + "es T");
                return "T";
            } else {
                System.out.println(input + "es NIL");
                return "NIL";
            }
        }
        else if (input.contains("<")) {
            if(pred.smallerThan(input)) {
                System.out.println(input + "es T");
                return "T";
            } else {
                System.out.println(input + "es NIL");
                return "NIL";
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
            }else if (almacen.get(temp[0]).getClass() == setq.getClass()){
                SetQ st = (SetQ) almacen.get(temp[0]);
                res = st.getvalor();
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
