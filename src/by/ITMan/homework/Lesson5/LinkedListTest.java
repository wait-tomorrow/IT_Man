package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest extends AbstractListTest {
    @Override
    <T> LinkedList<T> createCollection(T... elements) {
        LinkedList<T> linkedList = new LinkedList<>();
        for (T x : elements) {
            linkedList.add(x);
        }
        return linkedList;
    }

    @Test
    void linkedListGetFirst() {
        LinkedList<String> ll = createCollection("1", "2", "3");

        assertEquals("1", ll.getFirst());
    }

    @Test
    void linkedListGetLast() {
        LinkedList<String> ll = createCollection("1", "2", "3");

        assertEquals("3", ll.getLast());
    }

    @Test
    void linkedListOfferFirst() {
        LinkedList<String> ll = createCollection("1", "2", "3");

        assertTrue(ll.offerFirst("900"));

        assertArrayEquals(new Object[]{"900", "1", "2", "3"}, ll.toArray());
    }

    @Test
    void linkedListOfferLast() {
        LinkedList<String> ll = createCollection("1", "2", "3");

        assertTrue(ll.offerLast("999"));

        assertArrayEquals(new Object[]{"1", "2", "3", "999"}, ll.toArray());
    }

    @Test
    void linkedListPollFirst() {
        LinkedList<String> ll = createCollection("1", "2", "3");

        Object result = ll.pollFirst();

        assertEquals("1", result);
        assertArrayEquals(new Object[]{"2", "3"}, ll.toArray());
    }

    @Test
    void linkedListPollLast() {
        LinkedList<String> ll = createCollection("1", "2", "3");

        Object result = ll.pollLast();

        assertEquals("3", result);
        assertArrayEquals(new Object[]{"1", "2"}, ll.toArray());
    }

    @Test
    void linkedListToString() {
        LinkedList<String> ll = createCollection("1", "2", "3");

        assertEquals("size = 3 | elems: 1  2  3  ", ll.toString());
    }

    @Test
    void linkedListToArray() {
        LinkedList<String> ll = createCollection("1", "2", "3");

        assertArrayEquals(new Object[]{"1", "2", "3"}, ll.toArray());
    }
}