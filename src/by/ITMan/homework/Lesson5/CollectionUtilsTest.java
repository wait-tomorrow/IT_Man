package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CollectionUtilsTest {

    @Test
    void asList() {
        List<Integer> list = CollectionUtils.asList(1, 2, 3);

        assertThrows(UnsupportedOperationException.class, () -> list.add(3));
        assertEquals(1, list.get(0));
    }

    @Test
    void unmodifiableCollection() {
        List<Integer> list = CollectionUtils.asList(1, 2, 3);
        Collection<Integer> c = CollectionUtils.unmodifiableCollection(list);

        assertThrows(UnsupportedOperationException.class, () -> c.add(3));
        assertEquals(1, list.get(0));
    }

    @Test
    void unmodifiableLinkedList() {
        List<Integer> list = CollectionUtils.asList(1, 2, 3);
        Collection<Integer> c = CollectionUtils.unmodifiableList(list);

        assertThrows(UnsupportedOperationException.class, () -> c.add(3));
        assertEquals(1, list.get(0));
    }

    @Test
    void min() {
        Collection<Integer> collection = CollectionUtils.asList(5, 3, 8, 6, 0, 1);

        assertEquals(0, CollectionUtils.min(collection, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }));
    }

    @Test
    void max() {
        Collection<Integer> collection = CollectionUtils.asList(5, 3, 8, 6, 0, 1);

        assertEquals(8, CollectionUtils.max(collection, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }));
    }
}
