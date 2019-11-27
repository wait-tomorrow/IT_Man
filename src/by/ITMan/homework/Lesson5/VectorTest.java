package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest extends AbstractListTest {

    @Override
    <T> Vector<T> createCollection(Class<T> clazz) {
        return new Vector<T>();
    }

    @Test
    void vectorIterator() {
        Vector<String> vector = createCollection(String.class);

        int i = 1;
        for (String x : vector) {
            assertEquals(i + "", x);
            i++;
        }
    }

    @Test
    void vectorIteratorRemove() {
        Vector<String> vector = createCollection(String.class);
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
        Vector<String> vector = createCollection(String.class);

        assertEquals("size = 5 | [1] [2] [3] [4] [5] ", vector.toString());
    }
}