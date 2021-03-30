import org.junit.Test;

import static org.junit.Assert.*;

public class PredicadosTest {

    @Test
    public void testEquals() {

        Predicados pred = new Predicados();

        assertEquals(true,pred.equals( "= 2 2"));
    }

    @Test
    public void biggerThan() {
        Predicados pred = new Predicados();

        assertEquals(false,pred.equals( "> 2 3"));
    }

    @Test
    public void smallerThan() {
        Predicados pred = new Predicados();

        assertEquals(false,pred.equals( "< 2 1"));
    }
}