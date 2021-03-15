public class Operaciones {


    public Operaciones() {

    }

    public String Operar(String dato1, String dato2 ,String signo){
        int d1 = Integer.parseInt(dato1);
        int d2 = Integer.parseInt(dato2);
        int res = switch (signo) {
            case "+" -> (d2 + d1);
            case "-" -> (d1 - d2);
            case "*" -> (d2 * d1);
            case "/" -> (d1 / d2);
            default -> 0;
        };

        return String.valueOf(res);
    }


}
