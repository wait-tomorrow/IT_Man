package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest extends AbstractListTest {

    @Override
    <T> Vector<T> createCollection(T... elements) {
        Vector<T> vector = new Vector<>();
        for (T x : elements) {
            vector.add(x);
        }
        return vector;
    }

    @Test
    void vectorAdd2() {
        Vector<Integer> vector = new Vector<>(2);
        assertTrue(vector.add(1));
        assertTrue(vector.add(2));

        assertArrayEquals(new Object[]{1, 2}, vector.toArray());
    }
}