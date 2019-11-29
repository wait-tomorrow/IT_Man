package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

abstract class AbstractCollectionTest {
    abstract <T> Collection<T> createCollection();

    @Test
    void collectionIsEmpty() {
        Collection<String> collection = createCollection();

        assertTrue(collection.isEmpty());
    }

    @Test
    void collectionAdd() {
        Collection<String> collection = createCollection();
        assertTrue(collection.add("1"));
        assertTrue(collection.add("2"));
        assertTrue(collection.add("3"));
        assertTrue(collection.add("4"));
        assertTrue(collection.add("5"));

        assertTrue(collection.add("999"));

        assertArrayEquals(new Object[]{"1", "2", "3", "4", "5", "999"}, collection.toArray());
    }

    @Test
    void collectionAddAll() {
        Collection<String> collection = createCollection();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        collection.add("4");
        collection.add("5");

        Collection<String> addElems = createCollection();

        addElems.add("1");
        addElems.add("1");
        addElems.add("10");
        addElems.add("8");

        assertTrue(collection.addAll(addElems));

        assertArrayEquals(new Object[]{"1", "2", "3", "4", "5", "1", "1", "10", "8"}, collection.toArray());
    }

    @Test
    void collectionContains() {
        Collection<String> collection = createCollection();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        collection.add("4");
        collection.add("5");

        assertTrue(collection.contains("5"));
        assertFalse(collection.contains("10"));
    }

    @Test
    void collectionContainsAll() {
        Collection<String> collection = createCollection();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        collection.add("4");
        collection.add("5");

        Collection<String> c2 = createCollection();
        c2.add("2");
        c2.add("4");
        c2.add("5");

        Collection<String> c3 = createCollection();
        c3.add("2");
        c3.add("10");
        c3.add("5");

        assertTrue(collection.containsAll(c2));
        assertFalse(collection.containsAll(c3));
    }

    @Test
    void collectionRemove() {
        Collection<Integer> collection = createCollection();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);

        assertTrue(collection.remove(4));

        assertArrayEquals(new Object[]{1, 2, 3, 5}, collection.toArray());
    }

    @Test
    void collectionRemoveAll() {
        Collection<String> collection = createCollection();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        collection.add("4");
        collection.add("5");

        Collection<String> collectionForRemove = createCollection();
        collectionForRemove.add("2");
        collectionForRemove.add("4");

        assertTrue(collection.removeAll(collectionForRemove));

        assertArrayEquals(new Object[]{"1", "3", "5"}, collection.toArray());
    }

    @Test
    void collectionClear() {
        Collection<String> collection = createCollection();
        collection.add("1");
        collection.add("2");
        collection.add("3");

        collection.clear();

        assertArrayEquals(new String[0], collection.toArray());
        assertEquals(0, collection.size());
    }

    @Test
    void collectionEquals() {
        Collection<String> c1 = createCollection();
        c1.add("1");
        c1.add("2");
        c1.add("3");

        Collection<String> c2 = createCollection();
        c2.add("1");
        c2.add("2");
        c2.add("3");

        assertArrayEquals(new Object[]{"1", "2", "3"}, c1.toArray());
        assertArrayEquals(new Object[]{"1", "2", "3"}, c2.toArray());
        assertEquals(c1, c2);

        assertTrue(c2.remove("3"));
        assertNotEquals(c1, c2);
    }

    @Test
    void collectionToArray() {
        Collection<String> collection = createCollection();
        collection.add("1");
        collection.add("2");
        collection.add("3");

        assertArrayEquals(new Object[]{"1", "2", "3"}, collection.toArray());
    }
}
