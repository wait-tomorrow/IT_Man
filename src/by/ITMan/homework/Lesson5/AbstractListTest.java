package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractListTest extends AbstractCollectionTest {
    abstract <T> List<T> createCollection();

    @Test
    void listAdd() {
        List<String> list = createCollection();
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.add("3"));
        assertTrue(list.add("4"));
        assertTrue(list.add("5"));

        assertTrue(list.add(2, "999"));

        assertArrayEquals(new Object[]{"1", "2", "999", "3", "4", "5"}, list.toArray());
    }

    @Test
    void listAddAll() {
        List<String> list = createCollection();
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.add("3"));
        assertTrue(list.add("4"));
        assertTrue(list.add("5"));

        List<String> addElems = createCollection();
        assertTrue(addElems.add("1"));
        assertTrue(addElems.add("1"));
        assertTrue(addElems.add("10"));
        assertTrue(addElems.add("8"));

        assertTrue(list.addAll(2, addElems));

        assertArrayEquals(new Object[]{"1", "2", "1", "1", "10", "8", "3", "4", "5"}, list.toArray());
    }

    @Test
    void listGet() {
        List<String> list = createCollection();
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.add("3"));
        assertTrue(list.add("4"));
        assertTrue(list.add("5"));

        assertEquals("1", list.get(0));
    }

    @Test
    void listSet() {
        List<String> list = createCollection();
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.add("3"));
        assertTrue(list.add("4"));
        assertTrue(list.add("5"));

        assertEquals("2", list.set(1, "999"));

        assertArrayEquals(new Object[]{"1", "999", "3", "4", "5"}, list.toArray());
    }

    @Test
    void listRemove() {
        List<String> list = createCollection();
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.add("3"));
        assertTrue(list.add("4"));
        assertTrue(list.add("5"));

        assertEquals("2", list.remove(1));

        assertArrayEquals(new Object[]{"1", "3", "4", "5"}, list.toArray());
    }
}
