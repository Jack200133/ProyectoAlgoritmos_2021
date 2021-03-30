import org.junit.Test;

import static org.junit.Assert.*;

public class OperacionesTest {

    @Test
    public void operar() {
        Operaciones op = new Operaciones();
        String rs = "+ 5 5 5 5";
        String res = "* 2 2 2";
        assertEquals(op.Operar(rs),"20.0");
        assertEquals(op.Operar(res),"8.0");
    }
}