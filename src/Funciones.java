import java.util.Arrays;

public class Funciones {
    String hacer;

    public Funciones() {

    }

    public Funciones(String s) {
       hacer = s;
    }

    public Funciones Defun(String input) {
        String[] temp = input.split(" ");
        System.out.println(Arrays.toString(temp));
        return new Funciones(temp[2]);
    }

    public void loquehace(String x){
        //( define doble ( * x 2 ) )
        //split "" *,x,2
        //fori x la var !isDigit y !+*-/
        //buscar a  lo que se tiene que remplazar
    }

    @Override
    public String toString() {
        String[] temp = hacer.split("");
        StringBuilder ve = new StringBuilder();
        for (String s : temp) {
            ve.append(s);
            ve.append(" ");
        }
        ve.deleteCharAt(temp.length+2);
        return (" ("+ve +")");
    }
}
