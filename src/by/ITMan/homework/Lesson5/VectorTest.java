package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

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

        testVector.set(1, "999");

        assertArrayEquals(new Object[]{"1", "999", "3", "4", "5", null, null, null, null, null}, testVector.toArray());
    }

    @Test
    void add() {
        Vector v1 = new Vector();
        Vector v2 = new Vector();

        v1.add("1");
        v2.add("1");

        assertEquals(v1, v2);
    }

    @Test
    void addAll() {
        Vector v1 = createVector();
        Vector v2 = new Vector();
        Vector v3 = new Vector();

        v2.add("1");
        v2.add("1");
        v2.add("10");
        v2.add("8");

        v1.addAll(5, v2);

        v3.add("1");
        v3.add("2");
        v3.add("3");
        v3.add("4");
        v3.add("5");
        v3.add("1");
        v3.add("1");
        v3.add("10");
        v3.add("8");
        assertEquals(v1, v3);
    }

    @Test
    void addAllColection() {
        Vector v1 = createVector();
        Vector v2 = new Vector();
        Vector v3 = new Vector();

        v2.add("1");
        v2.add("1");
        v2.add("10");
        v2.add("8");

        v1.addAll(v2);

        v3.add("1");
        v3.add("2");
        v3.add("3");
        v3.add("4");
        v3.add("5");
        v3.add("1");
        v3.add("1");
        v3.add("10");
        v3.add("8");
        assertEquals(v1, v3);
    }

    @Test
    void remove() {
        Vector vector = createVector();
        vector.remove(1);

        Vector expectedVector = new Vector();

        expectedVector.add("1");
        expectedVector.add("3");
        expectedVector.add("4");
        expectedVector.add("5");

        assertEquals(expectedVector, vector);
    }

    @Test
    void size() {
        Vector vector = new Vector();
        vector.add("2");
        vector.add("3");

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
        v2.add("2");
        v2.add("4");
        v2.add("5");

        Vector v3 = new Vector();
        v3.add("2");
        v3.add("10");
        v3.add("5");

        assertTrue(vector.containsAll(v2));
        assertFalse(vector.containsAll(v3));
    }

    @Test
    void testRemove() {
        Vector vector = createVector();
        vector.remove("4");

        Vector expectedVector = new Vector();

        expectedVector.add("1");
        expectedVector.add("2");
        expectedVector.add("3");
        expectedVector.add("5");

        assertEquals(expectedVector, vector);

        ///////////////////

        vector = createVector();
        vector.remove("10");

        expectedVector = new Vector();

        expectedVector.add("1");
        expectedVector.add("2");
        expectedVector.add("3");
        expectedVector.add("4");
        expectedVector.add("5");

        assertEquals(expectedVector, vector);
    }

    @Test
    void removeAll() {
        Vector vector = createVector();

        Vector vectorForRemove = new Vector();
        vectorForRemove.add("2");
        vectorForRemove.add("4");

        vector.removeAll(vectorForRemove);

        Vector expectedVector = new Vector();
        expectedVector.add("1");
        expectedVector.add("3");
        expectedVector.add("5");

        assertEquals(expectedVector, vector);
    }
}