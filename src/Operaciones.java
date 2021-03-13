public class Operaciones {


    public Operaciones() {

    }

    public String Operar(String op){
        Evaluar ev = Singlenton.getEvaluacion();
        String res = "";
        String[] temp = op.split("()");
        char s1 = op.charAt(2);
        char s2 = op.charAt(4);
        //System.out.println(op);
        if(temp[0].equals("+")||temp[0].equals("*") ||temp[0].equals("-")||temp[0].equals("/")){
            if(Character.isDigit(s1) && Character.isDigit(s2))  {
                 res = Operar(temp[2], temp[4], temp[0]);
            }else {

                if(temp[2].equals("(") && temp[temp.length-1].equals(")")) {
                    String r1 = "";
                    for (int i = 2; i < 9; i++) {
                        r1 += temp[i];
                    }

                    int firstBracket = op.indexOf('(');
                    String ct = op.substring(firstBracket + 1, op.indexOf(')', firstBracket));

                    System.out.println(ct);
                    String dq = ev.Evaluo(r1);

                    String r2 = "";
                    for (int i = temp.length-7; i < temp.length; i++) {
                        r2 += temp[i];
                    }
                    String dp = ev.Evaluo(r2);

                    res = Operar(dq, dp, temp[0]);


                }
                else if(temp[2].equals("(") && !temp[temp.length-1].equals(")")){
                    String r1 ="";
                    for (int i = 2; i < 9; i++) {
                        r1 += temp[i];
                    }
                    String dq = ev.Evaluo(r1);

                    res = Operar(dq,temp[temp.length-1],temp[0]);



                }
                else if(!temp[2].equals("(") && temp[temp.length-1].equals(")")){

                    String r2 = "";
                    for (int i = 4; i < temp.length; i++) {
                        r2 += temp[i];
                    }
                    String dp = ev.Evaluo(r2);

                    res = Operar(temp[2], dp, temp[0]);

                }


                //(+ (+ (- 3 1) (* 2 1)) (+ 3 1))
                //(+ (+ 3 1) 5)
                //(+ (* 2 1) (+ 3 1))


            }
        }else{
            res = ev.Evaluo(op);

        }
        return res;
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
