import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class SetQTest {

    @Test
    public void defq() {
        SetQ setq = new SetQ();
        String set = "( setq prueba 1 )";
        assertNotEquals(new SetQ("1"),setq.defq(set));

    }
}