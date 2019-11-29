package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractListTest extends AbstractCollectionTest {
    abstract <T> List<T> createCollection();

    @Test
    void listAdd() {
        List<String> list = createCollection();
        assertTrue(list.add("1"));
        assertTrue(list.add("2"));
        assertTrue(list.add("3"));
        assertTrue(list.add("4"));
        assertTrue(list.add("5"));

        assertTrue(list.add(2, "999"));

        assertArrayEquals(new Object[]{"1", "2", "999", "3", "4", "5"}, list.toArray());
    }

    @Test
    void listAddAll() {
        List<String> list = createCollection();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        List<String> addElems = createCollection();
        addElems.add("1");
        addElems.add("1");
        addElems.add("10");
        addElems.add("8");

        assertThrows(IllegalArgumentException.class, () -> list.addAll(2, list));

        list.addAll(2, addElems);
        assertArrayEquals(new Object[]{"1", "2", "1", "1", "10", "8", "3", "4", "5"}, list.toArray());
    }

    @Test
    void listGet() {
        List<String> list = createCollection();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        assertEquals("1", list.get(0));
    }

    @Test
    void listSet() {
        List<String> list = createCollection();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        assertEquals("2", list.set(1, "999"));

        assertArrayEquals(new Object[]{"1", "999", "3", "4", "5"}, list.toArray());
    }

    @Test
    void listRemove() {
        List<String> list = createCollection();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        assertEquals("2", list.remove(1));

        assertArrayEquals(new Object[]{"1", "3", "4", "5"}, list.toArray());
    }

    @Test
    void listIterator() {
        List<String> ll = createCollection();
        ll.add("1");
        ll.add("2");
        ll.add("3");

        int i = 1;
        for (Object x : ll) {
            assertEquals(i + "", x);
            i++;
        }
    }

    @Test
    void listIteratorRemove() {
        List<String> ll = createCollection();
        ll.add("1");
        ll.add("2");
        ll.add("3");
        ll.add("4");
        ll.add("5");
        ll.add("6");

        ListIterator itr = ll.iterator();
        while (itr.hasNext()) {
            Object temp = itr.next();

            if (Objects.equals(temp, "4")) {
                itr.remove();
            }
        }

        assertArrayEquals(new Object[]{"1", "2", "3", "5", "6"}, ll.toArray());
    }

    @Test
    void listIteratorRemoveFirst() {
        List<String> ll = createCollection();
        ll.add("1");
        ll.add("2");
        ll.add("3");
        ll.add("4");
        ll.add("5");
        ll.add("6");

        ListIterator itr = ll.iterator();
        while (itr.hasNext()) {
            Object temp = itr.next();

            if (Objects.equals(temp, "1")) {
                itr.remove();
            }
        }

        assertArrayEquals(new Object[]{"2", "3", "4", "5", "6"}, ll.toArray());
    }

    @Test
    void listIteratorRemoveLast() {
        List<String> ll = createCollection();
        ll.add("1");
        ll.add("2");
        ll.add("3");
        ll.add("4");
        ll.add("5");
        ll.add("6");

        ListIterator itr = ll.iterator();
        while (itr.hasNext()) {
            Object temp = itr.next();

            if (Objects.equals(temp, "6")) {
                itr.remove();
            }
        }

        assertArrayEquals(new Object[]{"1", "2", "3", "4", "5"}, ll.toArray());
    }

    @Test
    void listIteratorRemoveMany() {
        List<String> ll = createCollection();
        ll.add("1");
        ll.add("2");
        ll.add("3");
        ll.add("4");
        ll.add("5");
        ll.add("6");

        ListIterator itr = ll.iterator();
        while (itr.hasNext()) {
            Object temp = itr.next();

            if (!Objects.equals(temp, "1") && !Objects.equals(temp, "6")) {
                itr.remove();
            }
        }

        assertArrayEquals(new Object[]{"1", "6"}, ll.toArray());
    }

    @Test
    @SuppressWarnings("unchecked")
    void listIteratorSet() {
        List<String> ll = createCollection();
        ll.add("1");
        ll.add("2");
        ll.add("3");
        ll.add("4");
        ll.add("5");
        ll.add("6");

        ListIterator itr = ll.iterator();
        while (itr.hasNext()) {
            Object temp = itr.next();

            if (Objects.equals(temp, "2")) {
                itr.set("999");
            }
        }

        assertArrayEquals(new Object[]{"1", "999", "3", "4", "5", "6"}, ll.toArray());
    }

    @Test
    void listAddWrongIndexException() {
        List<String> list = createCollection();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-2, "999"));
    }

    @Test
    void listRemoveWrongIndexException() {
        List<String> list = createCollection();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-2));
    }

    @Test
    @SuppressWarnings("unchecked")
    void listIteratorCheckIllegalStateException() {
        List<String> ll = createCollection();
        ll.add("1");
        ll.add("2");
        ll.add("3");

        ListIterator itr = ll.iterator();

        assertThrows(IllegalStateException.class, () -> itr.remove());
        assertThrows(IllegalStateException.class, () -> itr.set("999"));
    }

    @Test
    void listSort() {
        List<Integer> list = createCollection();
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(10);
        list.add(0);
        list.add(-5);

        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer x1 = (Integer) o1;
                Integer x2 = (Integer) o2;

                return x1.compareTo(x2);
            }
        });

        assertArrayEquals(new Object[]{-5, 0, 2, 4, 5, 5, 7, 10}, list.toArray());
    }

    @Test
    void listSort2() {
        List<String> list = createCollection();
        list.add("113");
        list.add("1");
        list.add("11115");
        list.add("12");
        list.add("1114");

        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int x1 = ((String) o1).length();
                int x2 = ((String) o2).length();

                return x1 - x2;
            }
        });

        assertArrayEquals(new Object[]{"1", "12", "113", "1114", "11115"}, list.toArray());
    }
}
