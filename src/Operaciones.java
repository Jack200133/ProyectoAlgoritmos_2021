public class Operaciones {

    Evaluar ev;
    public Operaciones() {
        ev = new Evaluar();
    }

    public String Operar(String op){
        String res = "";
        String[] temp = op.split("()");
        char s1 = op.charAt(2);
        char s2 = op.charAt(4);

        if(temp[0] == "+" ||temp[0] == "*" ||temp[0] == "-"||temp[0] == "/"){
            if(Character.isDigit(s1) && Character.isDigit(s2))  {
                 res = Operar(temp[2], temp[4], temp[0]);
            }else{
                for (int i = 1; i <= temp.length - 1; i++) {
                    temp[i-1] = temp[i];
                }
                String eva = "";
                for (int i = 0; i <= temp.length-3; i++) {
                    eva+=temp[i];
                }
                System.out.print(eva);
                Operar(ev.Evaluo(eva));
                //(+ 3 (+ 2 5))
            }
        }else
        {
            ev.Evaluo(op);
        }
        return res;
    }

    public String Operar(String dato1, String dato2 ,String signo){
        int d1 = Integer.parseInt(dato1);
        int d2 = Integer.parseInt(dato2);
        int res = switch (signo) {
            case "+" -> (d2 + d1);
            case "-" -> (d2 - d1);
            case "*" -> (d2 * d1);
            case "/" -> (d2 / d1);
            default -> 0;
        };

        return String.valueOf(res);
    }

    boolean isNumber(String str) {
        if (str.length() == 0)
            return false; //To check if string is empty

        if (str.charAt(0) == '-')
            str = str.replaceFirst("-", "");// for handling -ve numbers

        System.out.println(str);

        str = str.replaceFirst("\\.", ""); //to check if it contains more than one decimal points

        if (str.length() == 0)
            return false; // to check if it is empty string after removing -ve sign and decimal point
        System.out.println(str);

        return str.replaceAll("[0-9]", "").length() == 0;
    }
}
