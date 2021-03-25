import java.util.*;

/**
 * @author Juan Angel Carrera
 * @author Diego Jose Franco
 * @author Andrés de la Roca
 * @version 24/03/2021
 * @since 21/03/2021
 * Clase que maneja las funciones de predicados como atom, listp, <, > y equal.
 */
public class Predicados {

    /**
     * Constructor
     */
    public Predicados() {

    }

    /**
     * @pre: Debe tener 2 o mas valores por comparar.
     * @param input Valores que quieren ser comparados.
     * @return Regresa un boolean dependiendo si los valores son iguales o no.
     */
    public boolean equals(String input) {
        String temp[] = input.split(" ");

        int length = temp.length;
        String first = temp[1];
        boolean state = true;
        for(int i = 1; i < length; i++) {
            if(temp[i].equals(first)) {
                state = true;
            } else {
                state = false;
                return state;
            }
        }
        System.out.println(Arrays.toString(temp));
        return state;
    }

    /**
     * @pre: Debe tener 2 o mas valores por comparar
     * @param input Valores que quieren ser comparados
     * @return Regresa un boolean dependiendo si los valores dados son mayores que el siguiente.
     */
    public boolean biggerThan(String input) {
        String temp[] = input.split(" ");
        int length = temp.length;
        int comparison1 = Integer.parseInt(temp[1]);
        boolean state = true;
        for(int i = 2; i < length; i++) {
            int comparison2 = Integer.parseInt(temp[i]);
            if(comparison1 > comparison2) {
                state = true;
                comparison1 = comparison2;
            } else {
                state = false;
                return state;
            }
        }
        return state;
    
    }

    /**
     * @pre: Debe tener 2 o mas valores por comparar
     * @param input Valores que quieren ser comparados
     * @return Regresa un boolean dependiendo si los valores dados son menores que el siguiente.
     */
    public boolean smallerThan(String input) {
        String temp[] = input.split(" ");
        int length = temp.length;
        int comparison1 = Integer.parseInt(temp[1]);
        boolean state = true;
        for(int i = 2; i < length; i++) {
            int comparison2 = Integer.parseInt(temp[i]);
            if(comparison1 < comparison2) {
                state = true;
                comparison1 = comparison2;
            } else {
                state = false;
                return state;
            }
        }
        return state;
    }

}
