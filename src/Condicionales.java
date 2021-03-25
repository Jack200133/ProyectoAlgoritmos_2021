/**
 * @author Juan Angel Carrera
 * @author Diego Franco
 * @author Andres de la Roca
 * @version 24/03/2021
 * @since 23/02/2021
 *
 * Clase que define el funcionamiento de las variables
 */
import java.util.Arrays;

public class Condicionales {
    private String falso;
    private String comprobar;

    /**
     * @post: constructor vacio de la clase
     */
    public Condicionales() {
    }

    /**
     * @post: constructor de la clase
     * @param fe lo que se debe de realizar segun el valor de la comparacion.
     * @param estado el resultado de evaluar la condicion siendo verdadera o falsa.
     */
    public Condicionales(String fe, String estado) {
        falso = fe;
        comprobar = estado;
    }

    /**
     * @post: indicar que instruccion se debe realizar segun la condicion que fue ingresada.
     * @param input son las instrucciones a evaluar separadas por espacio.
     * @param completo son las instrucciones a evaluar sin ser modificadas siendo el input del usuario.
     * @return regresa la instruccion que se debe realizar dependiendo de la condicion.
     */
    public Condicionales Condi(String input, String completo) {
        String[] temp = input.split(" ");
        String[] tamp = completo.split(" ");
        int ontast = 0;
        StringBuilder pruebas = new StringBuilder();

        for (int i = 11; i < tamp.length; i++) {

            if (tamp[i].equals("t")){
                ontast = i;
            }
        }
        for (int i = ontast+1; i < tamp.length ; i++) {
            pruebas.append(tamp[i]);
            pruebas.append(" ");
        }
        if(temp[1].equals("NIL")){
            return new Condicionales(pruebas.toString(), "NIL");
        }
        else{
            return new Condicionales(temp[1],"T");

        }
    }

    /**
     * @post: metodo qeue se encarga de indicar la instruccion por realizar.
     * @return regresa la instruccion que se debe realizar
     */
    public String Condicionar() {

        return falso;
    }

    /**
     * @post: metodo qeue se encarga de indicar el resultado de la condicion.
     * @return regresa el valor de la condicion evaluada siendo verdadera o falsa.
     */
    public String Estado(){
        return comprobar;
    }


}
