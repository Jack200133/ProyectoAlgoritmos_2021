import org.junit.Test;

import static org.junit.Assert.*;

public class CondicionalesTest {

    @Test
    public void condi() {
        Condicionales cop = new Condicionales();
        String completo = "( cond ( ( = 1 1 ) 1 ) ) ( t 0 ) )";
        String input = "cond 1 T";
        assertEquals(cop.Condi(input,completo).getClass(),Condicionales.class);
    }
}