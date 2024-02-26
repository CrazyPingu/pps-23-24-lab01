import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListImpl();
    }

    @Test
    public void testAdd() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(3, circularList.size());
    }

    @Test
    public void testNext() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);

        assertEquals(1, circularList.next().orElse(-1));
        assertEquals(2, circularList.next().orElse(-1));
        assertEquals(3, circularList.next().orElse(-1));
        assertEquals(1, circularList.next().orElse(-1));
    }

    @Test
    public void testPrevious() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(3, circularList.previous().orElse(-1));
        assertEquals(2, circularList.previous().orElse(-1));
        assertEquals(1, circularList.previous().orElse(-1));
        assertEquals(3, circularList.previous().orElse(-1));
    }

    @Test
    public void testReset() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(1, circularList.next().orElse(-1));
        assertEquals(2, circularList.next().orElse(-1));
        assertEquals(3, circularList.next().orElse(-1));
        circularList.reset();
        assertEquals(1, circularList.next().orElse(-1));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(circularList.isEmpty());
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

}
