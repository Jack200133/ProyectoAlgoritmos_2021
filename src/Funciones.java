
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
        StringBuilder eve = new StringBuilder();

        for (int i = 6; i < temp.length; i++) {
            try {
                char c = input.charAt(i);

                if(Character.isLetterOrDigit(c)){

                    if(temp[i].equals("(") || temp[i].equals(")") || temp[i].equals("=") || temp[i].equals("-") || temp[i].equals("+") || temp[i].equals("*") || temp[i].equals("/")|| temp[i].equals("<") || temp[i].equals(">") ){
                        eve.append(" ");
                        eve.append(temp[i]);
                        eve.append(" ");
                    }else{

                        eve.append(" ");
                        eve.append(temp[i]);
                        eve.append(" ");
                    }
                }
                else{
                    verifica(temp, eve, i);
                }
            }catch (Exception e){
                verifica(temp, eve, i);
            }

        }
        System.out.println("HACE ESTO "+eve);
        return new Funciones(eve.toString(),temp[4]);
    }

    private void verifica(String[] temp, StringBuilder eve, int i) {
        if(temp[i].equals("(") || temp[i].equals(")") || temp[i].equals("=") || temp[i].equals("-") || temp[i].equals("+") || temp[i].equals("*") || temp[i].equals("/")|| temp[i].equals("<") || temp[i].equals(">") ){

            eve.append(" ");
            eve.append(temp[i]);
            eve.append(" ");
        }else{
            eve.append(temp[i]);
        }
    }

    public String loquehace(String x){

        String[] temp = hacer.split(" ");
        StringBuilder eve = new StringBuilder();
        for (int i = 0; i < temp.length; i++){
            if(temp[i].equals(parametros)){
                temp[i] = x;
            }
            eve.append(temp[i]);
            eve.append(" ");
        }

        return eve.toString();
    }

    @Override
    public String toString() {
        return (hacer);
    }
}
