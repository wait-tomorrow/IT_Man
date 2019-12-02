package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void binarySearch() {
        List<Integer> list = CollectionUtils.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        assertEquals(0, CollectionUtils.binarySearch(list, 1, comp));
        assertEquals(1, CollectionUtils.binarySearch(list, 2, comp));
        assertEquals(2, CollectionUtils.binarySearch(list, 3, comp));
        assertEquals(3, CollectionUtils.binarySearch(list, 4, comp));
        assertEquals(4, CollectionUtils.binarySearch(list, 5, comp));
        assertEquals(5, CollectionUtils.binarySearch(list, 6, comp));
        assertEquals(6, CollectionUtils.binarySearch(list, 7, comp));
        assertEquals(7, CollectionUtils.binarySearch(list, 8, comp));
        assertEquals(-1, CollectionUtils.binarySearch(list, 100, comp));
    }

    @Test
    void binarySearchForLinkedList() {
        List<Integer> list = new LinkedList<>();
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));
        assertTrue(list.add(4));
        assertTrue(list.add(5));
        assertTrue(list.add(6));
        assertTrue(list.add(7));
        assertTrue(list.add(8));
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6, 7, 8}, list.toArray());

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        assertEquals(0, CollectionUtils.binarySearch(list, 1, comp));
        assertEquals(1, CollectionUtils.binarySearch(list, 2, comp));
        assertEquals(2, CollectionUtils.binarySearch(list, 3, comp));
        assertEquals(3, CollectionUtils.binarySearch(list, 4, comp));
        assertEquals(4, CollectionUtils.binarySearch(list, 5, comp));
        assertEquals(5, CollectionUtils.binarySearch(list, 6, comp));
        assertEquals(6, CollectionUtils.binarySearch(list, 7, comp));
        assertEquals(7, CollectionUtils.binarySearch(list, 8, comp));
        assertEquals(-1, CollectionUtils.binarySearch(list, 100, comp));
    }

    @Test
    void reverseVectorList() {
        List<Integer> list = new Vector<>();
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));
        assertTrue(list.add(4));
        assertTrue(list.add(5));
        assertTrue(list.add(6));

        CollectionUtils.reverse(list);
        assertArrayEquals(new Object[]{6, 5, 4, 3, 2, 1}, list.toArray());
    }

    @Test
    void reverseLinkedList() {
        List<Integer> list = new LinkedList<>();
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));
        assertTrue(list.add(4));
        assertTrue(list.add(5));
        assertTrue(list.add(6));

        CollectionUtils.reverse(list);
        assertArrayEquals(new Object[]{6, 5, 4, 3, 2, 1}, list.toArray());
    }

    @Test
    void shuffleList() {
        List<Integer> list1 = new LinkedList<>();
        assertTrue(list1.add(1));
        assertTrue(list1.add(2));
        assertTrue(list1.add(3));
        assertTrue(list1.add(4));

        List<Integer> list2 = new LinkedList<>();
        assertTrue(list2.add(1));
        assertTrue(list2.add(2));
        assertTrue(list2.add(3));
        assertTrue(list2.add(4));

        assertEquals(list1, list2);

        CollectionUtils.shuffle(list1);
        assertNotEquals(list1, list2);
    }
}
