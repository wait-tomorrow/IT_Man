package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest extends AbstractListTest {

    @Override
    <T> Vector<T> createCollection() {
        return new Vector<>();
    }

    @Test
    void vectorToString() {
        Vector<Integer> vector = createCollection();
        assertTrue(vector.add(1));
        assertTrue(vector.add(2));
        assertTrue(vector.add(3));
        assertTrue(vector.add(4));
        assertTrue(vector.add(5));

        assertEquals("size = 5 | [1] [2] [3] [4] [5] ", vector.toString());
    }
}