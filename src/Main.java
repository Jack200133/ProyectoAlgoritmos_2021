/**
 * @author Juan Angel Carrera
 * @author Diego Franco
 * @author Andres de la Roca
 * @version 24/03/2021
 * @since 9/03/2021
 *
 * Clase main que inicia el programa
 */
import java.util.Scanner;

public class Main {
    /**
     *
     * @param args main para llamar al evaluador
     */
    public static void main(String[] args) {
        System.out.println("\nInterprete Lisp: \n");
        Scanner scan = new Scanner(System.in);
        Evaluar eval = new Evaluar();

        while(true){


            System.out.println("Ingrese su expresion: ");

            String input = scan.nextLine();
            Scanner scon = new Scanner(input);

            System.out.println(eval.Evaluo(input,scon));
        }



    }
}
