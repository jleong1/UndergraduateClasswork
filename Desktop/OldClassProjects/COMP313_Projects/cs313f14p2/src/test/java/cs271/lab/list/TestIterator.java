package cs271.lab.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIterator {

	private List<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<Integer>();


	@After
	public void tearDown() throws Exception {
		list = null;
	}

	@Test// TODO also try with a LinkedList - does it make any difference?
    //LinkedList is faster performance wise than ArrayList
}
	public void testEmpty() {
		final Iterator<Integer> i = list.iterator();
		assertFalse(i.hasNext());
	}

	@Test
	public void testNonempty() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		final Iterator<Integer> i = list.iterator();
		assertTrue(i.hasNext());
		assertEquals(33, i.next().intValue());
		// TODO fix the expected values in the assertions below
		assertTrue(i.hasNext());
		assertEquals(77, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(44, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(77, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(55, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(77, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(66, i.next().intValue());
		assertFalse(i.hasNext());
	}

	@Test
	public void testRemove() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		final Iterator<Integer> i = list.iterator();
		while (i.hasNext()) {
			if (i.next() == 77) {
				i.remove(); // TODO what happens if you use list.remove(77)?
                // if you use list.remove(77), it will only remove the first occurrence of 77
                // in the list, not as you are iterating the list, so it would not remove all 77s
			}
		}
		// TODO using assertEquals and Arrays.asList (see above)
		// express which values are left in the list
		assertEquals(Arrays.asList(33,44,55,66),list.subList(0,4));
		// remove this line when done
	}

	@Test
	public void testAverageValues() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		double sum = 0;
		int n = 0;
		// TODO use an iterator and a while loop to compute the average (mean) of the values
		// (defined as the sum of the items divided by the number of items)
        final Iterator<Integer> i = list.iterator();
        while(i.hasNext()) {
            sum += i.next();
            n++;
        }
		assertEquals(61.3, sum / n, 0.1);
		assertEquals(7, n);
	}
}
