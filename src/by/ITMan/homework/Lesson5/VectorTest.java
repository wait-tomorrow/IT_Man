package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest extends AbstractListTest {

    @Override
    <T> Vector<T> createCollection() {
        return new Vector<>();
    }

    @Test
    void vectorIterator() {
        Vector<String> vector = createCollection();

        int i = 1;
        for (String x : vector) {
            assertEquals(i + "", x);
            i++;
        }
    }

    @Test
    void vectorIteratorRemove() {
        Vector<String> vector = createCollection();
        assertTrue(vector.add("1"));
        assertTrue(vector.add("2"));
        assertTrue(vector.add("3"));
        assertTrue(vector.add("4"));
        assertTrue(vector.add("5"));

        Iterator itr = vector.iterator();

        while (itr.hasNext()) {
            if (Objects.equals(itr.next(), "3")) {
                itr.remove();
            }
        }

        assertArrayEquals(new Object[]{"1", "2", "4", "5"}, vector.toArray());
    }

    @Test
    void vectorToString() {
        Vector<Integer> vector = createCollection();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

        assertEquals("size = 5 | [1] [2] [3] [4] [5] ", vector.toString());
    }
}