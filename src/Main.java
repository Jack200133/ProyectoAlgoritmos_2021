import java.util.Scanner;

/**
 *
 */
public class Main {
    /**
     *
     * @param args
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
