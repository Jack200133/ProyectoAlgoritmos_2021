public class Operaciones {

    public Operaciones() {

    }

    public String Operar(String dato1, String dato2 ,char signo){
        int d1 = Integer.parseInt(dato1);
        int d2 = Integer.parseInt(dato2);
        int res = switch (signo) {
            case '+' -> (d2 + d1);
            case '-' -> (d2 - d1);
            case '*' -> (d2 * d1);
            case '/' -> (d2 / d1);
            default -> 0;
        };

        return String.valueOf(res);
    }

}
