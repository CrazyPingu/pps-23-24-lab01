import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tddfilter.CircularFilteredList;
import tddfilter.CircularFilteredListImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularIteratorList implementation
 */
public class CircularFilteredListTest {

    private CircularFilteredList list;

    @BeforeEach
    void beforeEach() {
        list = new CircularFilteredListImpl();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void testNext() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.next().orElse(-1));
        assertEquals(2, list.next().orElse(-1));
        assertEquals(3, list.next().orElse(-1));
        assertEquals(1, list.next().orElse(-1));
    }

    @Test
    public void testPrevious() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.previous().orElse(-1));
        assertEquals(2, list.previous().orElse(-1));
        assertEquals(1, list.previous().orElse(-1));
        assertEquals(3, list.previous().orElse(-1));
    }

    @Test
    public void testReset() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.next().orElse(-1));
        assertEquals(2, list.next().orElse(-1));
        assertEquals(3, list.next().orElse(-1));
        list.reset();
        assertEquals(1, list.next().orElse(-1));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testFiltered() {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        assertEquals(2, list.filteredNext(e -> e % 2 == 0).orElse(-1));
        assertEquals(4, list.filteredNext(e -> e % 2 == 0).orElse(-1));
        assertEquals(6, list.filteredNext(e -> e % 2 == 0).orElse(-1));
        assertEquals(8, list.filteredNext(e -> e % 2 == 0).orElse(-1));
        assertEquals(10, list.filteredNext(e -> e % 2 == 0).orElse(-1));
        assertEquals(2, list.filteredNext(e -> e % 2 == 0).orElse(-1));

        assertEquals(Optional.empty(), list.filteredNext(e -> e > 10));
    }
}
