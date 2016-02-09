import org.junit.Test;
import static org.junit.Assert.*;

public class TestIntPair {
    @Test
    public void testDefaultIntPair() {
        final IntPair p = new DefaultIntPair(3, 5); 
        final IntPair q = new DefaultIntPair(5, 3);
        assertEquals(3, p.first()); 
        assertEquals(5, p.second()); 
        assertEquals("<3, 5>", p.toString()); 
        assertTrue(p.equals(p)); 
        assertFalse(p.equals(q)); 
        assertFalse(q.equals(p)); 
        assertFalse(p.equals(null)); 
        assertTrue(p.equals(q.reverse()));
    }
}
