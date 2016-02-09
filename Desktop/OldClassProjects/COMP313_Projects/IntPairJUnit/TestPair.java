import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestPair {
	private Pair<Integer> p;
	private Pair<Integer> p2;
	private Pair<Integer> p3;
	private Pair<Integer> q;
	private Pair<String> s;

	@Before
	public void setup() {
        p = new DefaultPair<Integer>(3, 5);
        p2 = new DefaultPair<Integer>(3, 5);
        p3 = new DefaultPair<Integer>(3, 5);
        q = new DefaultPair<Integer>(5, 3);
		s = new DefaultPair<String>("3", "5");
	}

    @Test
    public void testPair() {
        /* 
		assertEquals(3, p.first()); 
        assertEquals(5, p.second()); 
		*/
        assertTrue(p.first().equals(3)); 
        assertTrue(p.second().equals(5));
		assertEquals(p.first(), q.second());
		assertEquals(p.second(), q.first());
        assertEquals("<3, 5>", p.toString()); 
		// Reflexive
        assertTrue(p.equals(p)); 
		assertEquals(p, p);
		// Symmetric
        assertFalse(p.equals(q)); 
        assertFalse(q.equals(p)); 
		// Transitive
		assertTrue(p.equals(p2));
		assertTrue(p2.equals(p3));
		assertTrue(p.equals(p3));
		// Not null
        assertFalse(p.equals(null)); 
		// Other
        assertTrue(p.equals(q.reverse()));
        assertEquals(p, q.reverse());
		assertFalse(p.equals(s));
    }
}
