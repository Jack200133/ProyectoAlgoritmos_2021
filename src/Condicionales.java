import java.util.Arrays;

public class Condicionales {
    private Predicados pred;
    private String falso;
    private String comprobar;
    public Condicionales() {
        pred = new Predicados();
    }
    public Condicionales(String fe, String que) {
        falso = fe;
        comprobar = que;
    }

    public Condicionales Condi(String input, String completo) {



        String[] temp = input.split(" ");
        String[] tamp = completo.split(" ");
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(tamp));
        int ontast = 0;
        String pruebas = "";

        for (int i = 11; i < tamp.length; i++) {

            if (tamp[i].equals("t")){
                ontast = i;
            }
        }
        for (int i = ontast+1; i < tamp.length ; i++) {
            pruebas += tamp[i];
            pruebas += " ";
        }
        if(temp[1].equals("NIL")){
            System.out.println("ENTRE AL NIL");
            return new Condicionales(pruebas, "NIL");
        }else{
            System.out.println("ENTRE AL T");
            return new Condicionales(temp[1],"T");

        }
    }

    public String Condicionar() {

        return falso;
    }
    public String Estado(){
        return comprobar;
    }

    private String compara(String input){

        if (input.contains("equal") || input.contains("=")) {
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
        return input;
    }

}
