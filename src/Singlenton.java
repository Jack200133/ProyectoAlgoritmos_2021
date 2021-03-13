public final class Singlenton<E> {

    private static Evaluar ev; //se guarda el stack

    /**
     * @post: Se crea la instancia de St
     */

    private Singlenton(){
        Evaluar eva = new Evaluar();
        ev = eva; //Aqui se pone que tipo de Stack se Quiere
    }

    /**
     * @post: llama a la intsancia del S
     * @return regresa la intancia del stack
     */
    public static Evaluar getEvaluacion(){
        if(ev==null){
            new Singlenton();
        }

        return ev;
    }
}
