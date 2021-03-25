/**
 * @author Juan Angel Carrera
 * @author Diego Franco
 * @author Andres de la Roca
 * @version 24/03/2021
 * @since 23/02/2021
 *
 *  Clase que evalua lo que ingresa el usuario
 */
import java.util.*;

/**
 *
 * @param <V> Valor generico para la llave del hashmap
 * @param <F> Valor generico para el value del hasmap
 */
public class Evaluar<V,F> {
    private final Operaciones op;
    private final Quote quote;
    private final Funciones fun;
    private final Variables van;
    private final SetQ setq;
    private final Predicados pred;
    private final Condicionales cond;

    /**
     * Inicializacion de la clase evaluar
     */
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

    /**
     *
     * @param input lo que ingresa el usuario y sera evaluar
     * @param scan el scaner que ira de string por string envaluando si son o no ()
     * @return el resultado ya evaluado
     */
    public String Evaluo(String input,Scanner scan) {

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if(scan.hasNext()){
                String tem = scan.next();
                if (tem.equals(")")) {
                    res = new StringBuilder(queso(res.toString(), input));
                    return res.toString();
                }else if (!tem.equals("(")) {
                    res.append(tem);
                    res.append(" ");
                }else{
                    if(!res.toString().contains("T")){
                        res.append(Evaluo(input, scan));
                        res.append(" ");
                    }else{
                        return ("T");
                    }
                }

            }

        }
        return res.toString();
    }

    /**
     *
     * @param input reevaluacion del string para
     * @return regresa el valor ya evaluado
     */
    public String Evaluo(String input) {
        Scanner scan = new Scanner(input);

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if(scan.hasNext()){
                String tem = scan.next();

                if (tem.equals(")")) {

                    res = new StringBuilder(queso(res.toString(), input));
                    return res.toString();
                }else if (!tem.equals("(")) {
                    res.append(tem);
                    res.append(" ");

                }else{
                    if(!res.toString().contains("T")){
                        res.append(Evaluo(input, scan));
                        res.append(" ");
                    }else{
                        return ("T");
                    }
                }

                // System.out.println(res); // borrar
            }


        }
        return res.toString();
    }

    /**
     *
     * @param input valor que dice que tiene que hacer la evaluacion
     * @param completo la string completo sin evaluar
     * @return la evaluacion ya resuelta
     */
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
            StringBuilder ros = new StringBuilder();
            for (int i = 2; i < temp.length; i++) {
                ros.append(temp[i]);
                ros.append(" ");
            }
            return queso(ros.toString(),"");

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
                StringBuilder til = new StringBuilder();
                for (int i = 0; i < t; i++) {
                    til.append(temp[i]);
                    til.append(" ");
                }
                for (int i = t+1; i < temp.length; i++) {
                    til.append(temp[i]);
                    til.append(" ");
                }
                return queso(til.toString(),"");
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
