package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest extends AbstractListTest {

    @Override
    <T> Vector<T> createCollection() {
        return new Vector<>();
    }

    @Test
    void vectorSort() {
        Vector<Integer> vector = createCollection();
        assertTrue(vector.add(4));
        assertTrue(vector.add(5));
        assertTrue(vector.add(2));
        assertTrue(vector.add(7));
        assertTrue(vector.add(5));
        assertTrue(vector.add(10));
        assertTrue(vector.add(0));
        assertTrue(vector.add(-5));

        vector.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer x1 = (Integer) o1;
                Integer x2 = (Integer) o2;

                return x1.compareTo(x2);
            }
        });

        assertArrayEquals(new Object[]{-5, 0, 2, 4, 5, 5, 7, 10}, vector.toArray());
    }
}