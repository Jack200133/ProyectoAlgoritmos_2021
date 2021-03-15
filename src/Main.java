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

        Scanner scan = new Scanner(System.in);
        Evaluar eval = new Evaluar();

        System.out.println("Interprete Lisp: \n");

        System.out.println("Ingrese su expresion: ");

        String input = scan.nextLine();
        Scanner scon = new Scanner(input);
        System.out.printf(eval.Evaluo(input,scon));

    }
}
