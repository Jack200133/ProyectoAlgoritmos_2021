import java.util.Arrays;

/**
 * @author Juan Angel Carrera
 * @author Diego Jose Franco
 * @author Andrés de la Roca
 * @version 24/03/2021
 * @since 14/03/2021
 * Clase que implementa el comando SetQ, define una variable que es evaluado como si tuviera quote.
 */
public class SetQ {

    private String q;

    /**
     * Constructor
     */
    public SetQ() {
    }

    /**
     * Constructor
     * @param in Valor ingresado al llamar a SetQ.
     */
    public SetQ(String in) {
        q = in;
    }

    /**
     * @pre: El input debe de tener el nombre de la variable por definir y el valor que se le quiere asignar.
     * @param input Expresion que se quiere definir por SetQ.
     * @return Regresa la expresion ya definida.
     */
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

    /**
     * 
     * @return El valor ingresado por medio del constructor
     */
    public String getvalor(){
        return q;
    }


    /**
     * @return El valor ingresado por medio del constructor como String.
     */
    @Override
    public String toString() {
        return (q);
    }

}
