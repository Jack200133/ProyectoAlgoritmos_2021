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

public class Variables {
    private String valor;

    /**
     * @post: constructor vacio de la clase
     */
    public Variables() {
    }

    /**
     * @post: constructor de la clase
     * @param valor define el valor que se almacenara.
     */
    public Variables(String valor) {
        this.valor = valor;

    }

    /**
     * @post: separa el input que se le es enviado con la finalidad de distinguir el nombre y el valor a almacenar.
     * @param input input que sera evaluado para identificar las diferentes partes de la variable.
     * @return regresa el valor que se almacena en la variable.
     */
    public Variables Defvar(String input) {
        String[] temp = input.split(" ");
        String res = "";
        if (temp[3].equals("(")){
            for(int i = 3; i < temp.length-1;i++){
                res+= temp[i];
            }
            return new Variables(res);
        }
        return new Variables(temp[3]);
    }

    /**
     * @post: metodo que indica el valor de la variable.
     * @return regresa el valor que se almacena en la variable.
     */
    public String getvalor(){
        return valor;
    }

    /**
     * @return regresa el valor que se almacena en la variable.
     */
    @Override
    public String toString() {
        return (valor);
    }
}
