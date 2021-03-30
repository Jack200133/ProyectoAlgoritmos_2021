import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class EvaluarTest {

    @Test
    public void evaluo() {
        Evaluar eva = new Evaluar();
        String res = "( + 3 5 )";
        Scanner scan = new Scanner(res);
        assertEquals(eva.Evaluo(res,scan),"8.0 ");
    }

    @Test
    public void queso() {
        Evaluar eva = new Evaluar();
        String res = "< 5 10";
        assertEquals(eva.queso(res," "),"T");
    }
}