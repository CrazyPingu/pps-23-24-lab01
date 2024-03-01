import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdditerator.CircularIteratorList;
import tdditerator.CircularIteratorListImpl;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularIteratorList implementation
 */
public class CircularIteratorListTest {

    private CircularIteratorList list;

    @BeforeEach
    void beforeEach() {
        list = new CircularIteratorListImpl();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void testForwardIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.forwardIterator();

        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(1, iterator.next());
    }

    @Test
    public void testBackwardIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.backwardIterator();

        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(3, iterator.next());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

}
