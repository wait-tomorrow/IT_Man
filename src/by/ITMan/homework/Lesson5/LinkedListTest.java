package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void getFirst() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertEquals("1", ll.getFirst());
    }

    @Test
    void getLast() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertEquals("3", ll.getLast());
    }

    @Test
    void offerFirst() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertTrue(ll.offerFirst("999"));

        assertArrayEquals(new Object[]{"999", "1", "2", "3"}, ll.toArray());
    }

    @Test
    void offerLast() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertTrue(ll.offerLast("999"));

        assertArrayEquals(new Object[]{"1", "2", "3", "999"}, ll.toArray());
    }

    @Test
    void pollFirst() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        Object result = ll.pollFirst();

        assertEquals("1", result);
        assertArrayEquals(new Object[]{"2", "3"}, ll.toArray());
    }

    @Test
    void pollLast() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        Object result = ll.pollLast();

        assertEquals("3", result);
        assertArrayEquals(new Object[]{"1", "2"}, ll.toArray());
    }

    @Test
    void add() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertTrue(ll.add(0, "999"));

        assertArrayEquals(new Object[]{"999", "1", "2", "3"}, ll.toArray());

        ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertTrue(ll.add(2, "999"));

        assertArrayEquals(new Object[]{"1", "2", "999", "3"}, ll.toArray());
    }

    @Test
    void addAll() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        Vector vector = new Vector();
        assertTrue(vector.add("900"));
        assertTrue(vector.add("1000"));

        assertTrue(ll.addAll(1, vector));
        assertArrayEquals(new Object[]{"1", "900", "1000", "2", "3"}, ll.toArray());
    }

    @Test
    void get() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertEquals("2", ll.get(1));
    }

    @Test
    void set() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        Object result = ll.set(1, "999");

        assertEquals("2", result);
        assertArrayEquals(new Object[]{"1", "999", "3"}, ll.toArray());
    }

    @Test
    void remove() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));
        assertTrue(ll.offerLast("4"));
        assertTrue(ll.offerLast("5"));
        assertTrue(ll.offerLast("6"));

        assertEquals("3",ll.remove(2));

        assertArrayEquals(new Object[]{"1", "2", "4", "5", "6"}, ll.toArray());
    }

    @Test
    void size() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertEquals(3, ll.size());
    }

    @Test
    void isEmpty() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.isEmpty());

        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertFalse(ll.isEmpty());
    }

    @Test
    void testAdd() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertTrue(ll.add("999"));

        assertArrayEquals(new Object[]{"1", "2", "3", "999"}, ll.toArray());
    }

    @Test
    void testAddAll() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        Vector vector = new Vector();
        assertTrue(vector.add("900"));
        assertTrue(vector.add("1000"));

        assertTrue(ll.addAll(vector));
        assertArrayEquals(new Object[]{"1", "2", "3", "900", "1000"}, ll.toArray());
    }

    @Test
    void contains() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertTrue(ll.contains("2"));
    }

    @Test
    void containsAll() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        Vector vector = new Vector();
        assertTrue(vector.add("1"));
        assertTrue(vector.add("2"));

        assertTrue(ll.containsAll(vector));

        vector = new Vector();
        assertTrue(vector.add("1"));
        assertTrue(vector.add("2"));
        assertTrue(vector.add("10"));

        assertFalse(ll.containsAll(vector));
    }

    @Test
    void testRemove() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        boolean result = ll.remove("2");

        assertTrue(result);
        assertArrayEquals(new Object[]{"1", "3"}, ll.toArray());
    }

    @Test
    void removeAll() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));
        assertTrue(ll.offerLast("4"));
        assertTrue(ll.offerLast("5"));
        assertTrue(ll.offerLast("6"));

        Vector vector = new Vector();
        assertTrue(vector.add("1"));
        assertTrue(vector.add("3"));
        assertTrue(vector.add("5"));

        boolean result = ll.removeAll(vector);

        assertTrue(result);
        assertArrayEquals(new Object[]{"2", "4", "6"}, ll.toArray());
    }

    @Test
    void toStringTest() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertEquals("size = 3 | elems: 1  2  3  ", ll.toString());
    }

    @Test
    void clear() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        ll.clear();

        assertEquals("size = 0 | elems: ", ll.toString());
        assertEquals(0, ll.size());
    }

    @Test
    void toArray() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        assertArrayEquals(new Object[]{"1", "2", "3"}, ll.toArray());
    }

    @Test
    void iterator() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));

        int i = 1;
        for (Object x : ll) {
            assertEquals(i + "", x);
            i++;
        }
    }

    @Test
    void iteratorRemove() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.offerLast("1"));
        assertTrue(ll.offerLast("2"));
        assertTrue(ll.offerLast("3"));
        assertTrue(ll.offerLast("4"));
        assertTrue(ll.offerLast("5"));
        assertTrue(ll.offerLast("6"));

        Iterator itr = ll.iterator();
        while (itr.hasNext()) {
            Object temp = itr.next();

            if (temp.equals("5")) {
                itr.remove();
            }
        }

        assertArrayEquals(new Object[]{"1", "2", "3", "4", "6"}, ll.toArray());
    }
}