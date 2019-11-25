package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
    Vector createVector() {
        // DO NOT CHANGE THIS METHOD!!!!
        // I MEAN IT!!!!!

        //no, seriously, don't do it

        Vector newVector = new Vector();

        newVector.add("1");
        newVector.add("2");
        newVector.add("3");
        newVector.add("4");
        newVector.add("5");

        return newVector;
    }

    @Test
    void get() {
        Vector testVector = createVector();

        assertEquals("1", testVector.get(0));
    }

    @Test
    void set() {
        Vector testVector = createVector();

        assertEquals("2", testVector.set(1, "999"));

        assertArrayEquals(new Object[]{"1", "999", "3", "4", "5"}, testVector.toArray());
    }

    @Test
    void add() {
        Vector vector = createVector();

        assertTrue(vector.add("999"));

        assertArrayEquals(new Object[]{"1", "2", "3", "4", "5", "999"}, vector.toArray());
    }

    @Test
    void addAll() {
        Vector vector = createVector();
        Vector addElems = new Vector();

        assertTrue(addElems.add("1"));
        assertTrue(addElems.add("1"));
        assertTrue(addElems.add("10"));
        assertTrue(addElems.add("8"));

        assertTrue(vector.addAll(2, addElems));

        assertArrayEquals(new Object[]{"1", "2", "1", "1", "10", "8", "3", "4", "5"}, vector.toArray());
    }

    @Test
    void addAllColection() {
        Vector vector = createVector();
        Vector addElems = new Vector();

        assertTrue(addElems.add("1"));
        assertTrue(addElems.add("1"));
        assertTrue(addElems.add("10"));
        assertTrue(addElems.add("8"));

        assertTrue(vector.addAll(addElems));

        assertArrayEquals(new Object[]{"1", "2", "3", "4", "5", "1", "1", "10", "8"}, vector.toArray());
    }

    @Test
    void remove() {
        Vector vector = createVector();
        assertEquals("2", vector.remove(1));

        assertArrayEquals(new Object[]{"1", "3", "4", "5"}, vector.toArray());
    }

    @Test
    void size() {
        Vector vector = new Vector();
        assertTrue(vector.add("2"));
        assertTrue(vector.add("3"));

        assertEquals(2, vector.size());
    }

    @Test
    void isEmpty() {
        Vector vector = new Vector();

        assertTrue(vector.isEmpty());
    }

    @Test
    void contains() {
        Vector vector = createVector();

        assertTrue(vector.contains("5"));
        assertFalse(vector.contains("10"));
    }

    @Test
    void containsAll() {
        Vector vector = createVector();

        Vector v2 = new Vector();
        assertTrue(v2.add("2"));
        assertTrue(v2.add("4"));
        assertTrue(v2.add("5"));

        Vector v3 = new Vector();
        assertTrue(v3.add("2"));
        assertTrue(v3.add("10"));
        assertTrue(v3.add("5"));

        assertTrue(vector.containsAll(v2));
        assertFalse(vector.containsAll(v3));
    }

    @Test
    void testRemove() {
        Vector vector = createVector();
        assertTrue(vector.remove("4"));

        assertArrayEquals(new Object[]{"1", "2", "3", "5"}, vector.toArray());
    }

    @Test
    void removeAll() {
        Vector vector = createVector();

        Vector vectorForRemove = new Vector();
        assertTrue(vectorForRemove.add("2"));
        assertTrue(vectorForRemove.add("4"));

        assertTrue(vector.removeAll(vectorForRemove));

        assertArrayEquals(new Object[]{"1", "3", "5"}, vector.toArray());
    }

    @Test
    void testIterator() {
        Vector vector = createVector();

        int i = 1;
        for (Object x : vector) {
            assertEquals(i + "", x);
            i++;
        }
    }

    @Test
    void testIteratorRemove() {
        Vector vector = createVector();
        Iterator itr = vector.iterator();

        while (itr.hasNext()) {
            if (Objects.equals(itr.next(), "3")) {
                itr.remove();
            }
        }
        
        assertArrayEquals(new Object[]{"1", "2", "4", "5"}, vector.toArray());
    }

    @Test
    void testToString() {
        Vector vector = createVector();

        assertEquals("size = 5 | [1] [2] [3] [4] [5] ", vector.toString());
    }
}