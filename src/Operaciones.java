public class Operaciones {


    public Operaciones() {

    }

    public String Operar(String dato1, String dato2 ,String signo){
        char inds = dato1.charAt(0);
        char inds1 = dato2.charAt(0);

        if(Character.isDigit(inds) && Character.isDigit(inds1)){
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
        }else
        {
            String respu = "";
            respu += signo;
            respu += dato1;
            respu += dato2;


            return respu;
        }




    }


}
