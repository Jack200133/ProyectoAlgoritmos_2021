import org.junit.Test;

import static org.junit.Assert.*;

public class VariablesTest {

    @Test
    public void defvar() {
        Variables var = new Variables();
        String varr = "( defvar prueba 1 )";
        assertNotEquals(new Variables("1"),var.Defvar(varr));
    }
}