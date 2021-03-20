import java.util.Arrays;

public class Variables {
    private String valor;

    public Variables() {


    }
    public Variables(String valor) {
        this.valor = valor;

    }

    public Variables Defvar(String input) {
        String[] temp = input.split(" ");
        String res = "";
        if (temp[3].equals("(")){
            for(int i = 3; i < temp.length-1;i++){
                res+= temp[i];
            }
            return new Variables(res);
        }
        return new Variables(temp[3]);
    }

    public String getvalor(){
        return valor;
    }

    @Override
    public String toString() {
        return (valor);
    }
}
