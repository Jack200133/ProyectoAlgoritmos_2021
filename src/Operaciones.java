/**
 * @author Juan Angel Carrera
 * @author Diego Franco
 * @author Andres de la Roca
 * @version 24/03/2021
 * @since 23/02/2021
 *
 * Clase que hace las operaciones aritmeticas
 */

public class Operaciones {

    /**
     * Instancion de la clase operar
     */
    public Operaciones() {

    }

    /**
     *
     * @param datos daots que se multiplicaran/ sumaran/ restana y diviran
     * @return los datos ya operados
     * Puede operar varios datos al mismo tiempo
     */
    public String Operar(String datos){
        String[] temp = datos.split(" ");
        double res;
        try {
            res = Double.parseDouble(temp[1]);
           if(temp.length > 2) {
               switch (temp[0]) {
                   case "+":
                       for (int i = 2; i < temp.length; i++) {
                           if (!temp[i].equals(" ")&&!temp[i].equals("*")&&!temp[i].equals("")) {
                               res += Double.parseDouble(temp[i]);
                           }
                       }
                       break;
                   case "-":
                       for (int i = 2; i < temp.length; i++) {
                           if (!temp[i].equals(" ")&&!temp[i].equals("*")&&!temp[i].equals("")) {
                               res -= Double.parseDouble(temp[i]);
                           }
                       }
                       break;
                   case "*":
                       for (int i = 2; i < temp.length; i++) {
                           if (!temp[i].equals(" ")&&!temp[i].equals("*")&&!temp[i].equals("")) {
                               res = res * Double.parseDouble(temp[i]);
                           }
                       }

                       break;
                   case "/":
                       for (int i = 2; i < temp.length; i++) {
                           if (!temp[i].equals(" ")&&!temp[i].equals("*")&&!temp[i].equals("")) {

                               res = res / Double.parseDouble(temp[i]);
                           }
                       }
                       break;
               }
           }
           else{
               return temp[1];
           }
        }
        catch (Exception e){
            try {
                res = Double.parseDouble(temp[temp.length-1]);
                switch (temp[0]) {
                    case "+":
                        for (int i = temp.length-2; i > 0; i--) {
                            if (!temp[i].equals(" ")&&!temp[i].equals("*")&&!temp[i].equals("")) {
                                res += Double.parseDouble(temp[i]);
                            }
                        }
                        break;
                    case "-":
                        for (int i = temp.length-2; i > 0; i--) {
                            if (!temp[i].equals(" ")&&!temp[i].equals("*")&&!temp[i].equals("")) {
                                res -= Double.parseDouble(temp[i]);
                            }
                        }
                        break;
                    case "*":
                        for (int i = temp.length-2; i > 0; i--) {
                            if (!temp[i].equals(" ")&&!temp[i].equals("*")&&!temp[i].equals("")) {
                                res = res * Double.parseDouble(temp[i]);
                            }else{
                                res = res * 1.0f;
                            }
                        }

                        break;
                    case "/":
                        for (int i = temp.length-2; i > 0; i--) {
                            if (!temp[i].equals(" ")&&!temp[i].equals("*")&&!temp[i].equals("")) {

                                res = Double.parseDouble(temp[i]) / res ;
                            }
                        }
                        break;

                }
            } catch (Exception f){
                return datos;
            }
        }

        if(temp[0].equals("T")||temp[0].equals("t")){
            return temp[1];
        }
        return String.valueOf(res);
    }


}
