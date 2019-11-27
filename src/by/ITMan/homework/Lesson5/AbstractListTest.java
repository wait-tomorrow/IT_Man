package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract public class AbstractListTest extends AbstractCollectionTest {
    abstract <T> List<T> createCollection(Class<T> clazz);

    @Test
    void listAdd() {
        List<String> list = createCollection(String.class);

        assertTrue(list.add(2, "999"));

        assertArrayEquals(new Object[]{"1", "2", "3", "4", "5", "999"}, list.toArray());
    }

    @Test
    void listAddAll() {
        List<String> list = createCollection(String.class);
        List<String> addElems = new Vector();

        assertTrue(addElems.add("1"));
        assertTrue(addElems.add("1"));
        assertTrue(addElems.add("10"));
        assertTrue(addElems.add("8"));

        assertTrue(list.addAll(2, addElems));

        assertArrayEquals(new Object[]{"1", "2", "1", "1", "10", "8", "3", "4", "5"}, list.toArray());
    }

    @Test
    void listGet() {
        List<String> list = createCollection(String.class);

        assertEquals("1", list.get(0));
    }

    @Test
    void listSet() {
        List list = createCollection(String.class);

        assertEquals("2", list.set(1, "999"));

        assertArrayEquals(new Object[]{"1", "999", "3", "4", "5"}, list.toArray());
    }

    @Test
    void listRemove() {
        List<String> list = createCollection(String.class);
        assertEquals("2", list.remove(1));

        assertArrayEquals(new Object[]{"1", "3", "4", "5"}, list.toArray());
    }
}
