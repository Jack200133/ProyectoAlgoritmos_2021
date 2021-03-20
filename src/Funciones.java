import java.util.Arrays;

public class Funciones {
    private String parametros;
    private String hacer;

    public Funciones() {

    }

    public Funciones(String hacer,String parametros) {
        this.hacer = hacer;
        this.parametros = parametros;
    }

    public Funciones Defun(String input) {
        String[] temp = input.split(" ");
        System.out.println(Arrays.toString(temp));
        String s = "";
        for (int i = 6; i < temp.length-1; i++) {
            s += temp[i];
        }

        return new Funciones(s,temp[4]);
    }

    public String loquehace(String x){

        String[] temp = hacer.split("");
        String eve = "";
        for (int i = 0; i < temp.length; i++){
            if(temp[i].equals(parametros)){
                temp[i] = x;
            }
            eve += temp[i];
            eve += " ";
        }

        return eve;
    }

    @Override
    public String toString() {
        String[] temp = hacer.split("");
        StringBuilder ve = new StringBuilder();
        for (String s : temp) {
            ve.append(s);
            ve.append(" ");
        }
        //ve.deleteCharAt(temp.length+2);
        return (ve.toString());
    }
}
