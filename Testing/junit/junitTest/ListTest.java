import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ListTest {

    private List testPeople = new List();

    @Before
    public void setUp() throws Exception {
        testPeople.add("Adam");
        testPeople.add("George");
    }

    @Test
    public void testAdd() {
        testPeople.add("Eva");
        assertEquals("Check addition", 3, testPeople.size());

    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveAnElementNotExist() {
        testPeople.remove("Norbert");
    }

    @Test
    public void testRemoveAnElementIsExist() {
        testPeople.remove("Adam");
        assertEquals("Check remove one element", 1, testPeople.size());
    }

    @Test
    public void size() {
        assertEquals("Check size", 2, testPeople.size());

    }

    @Test
    public void isEmpty() {
        assertFalse(testPeople.isEmpty());
    }

    @Test
    public void removeAllFromNotEmptyList() {
        testPeople.removeAll();
        assertTrue(testPeople.isEmpty());

    }

    @After
    public void destroy() throws Exception {
        testPeople.removeAll();
    }
}
