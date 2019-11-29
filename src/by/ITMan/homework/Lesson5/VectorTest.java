package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest extends AbstractListTest {

    @Override
    <T> Vector<T> createCollection() {
        return new Vector<>();
    }

    @Test
    void vectorAdd2() {
        Vector<Integer> vector = new Vector<>(2);
        assertTrue(vector.add(1));
        assertTrue(vector.add(2));

        assertArrayEquals(new Object[]{1, 2}, vector.toArray());
    }
}