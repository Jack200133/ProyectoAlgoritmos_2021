import org.junit.Test;

import static org.junit.Assert.*;

public class QuoteTest {

    @Test
    public void deQuote() {
        Quote quote = new Quote();
        assertEquals("prueba1",quote.DeQuote( "quote prueba1"));

    }
}