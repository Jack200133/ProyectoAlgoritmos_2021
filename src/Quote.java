import java.lang.*;
import java.util.Arrays;

/**
 * @author Juan Angel Carrera
 * @author Diego Jose Franco
 * @author Andrés de la Roca
 * @version 24/03/2021
 * @since 9/03/2021
 * 
 * Clase que implementa Quote, comando que regresa el argumento ingresado
 * sin evaluarlo.
 */
public class Quote {

    /**
     * Constructor
     */
    public Quote() {
        
    }
    /**
     * @pre: El input debe tener 2 o mas expresiones.
     * @param input Expresion que se quiere evaluar.
     * @return Expresion evaluada por Quote.
     */
    public String DeQuote(String input) {
        String[] temp = input.split(" ");
        return temp[1];

    }

}
