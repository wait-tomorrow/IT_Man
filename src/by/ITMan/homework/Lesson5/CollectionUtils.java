package by.ITMan.homework.Lesson5;

import java.util.Comparator;

public class CollectionUtils {

    /**
     * Returns an unmodifiable list of elements.
     *
     * @param elements elements to insert to new list
     * @return an unmodifiable list of elements
     */
    public static <T> List<T> asList(T... elements) {
        return new UnmodifiableList<>(elements);
    }

    /**
     * Returns an unmodifiable collection.
     *
     * @param collection collection of elements to insert
     * @return an unmodifiable collection
     */
    public static <T> Collection<T> unmodifiableCollection(Collection<T> collection) {
        T[] arr = collection.toArray();

        return asList(arr);
    }

    /**
     * Returns an unmodifiable linked list.
     *
     * @param list list of elements
     * @return an unmodifiable list
     */
    public static <T> List<T> unmodifiableList(List<T> list) {
        return new UnmodifiableLinkedList<>(list);
    }

    /**
     * Returns the first minimal element.
     *
     * @param collection collection of the elements
     * @param comp       comparator
     * @return the first minimal element
     */
    public static <T> T min(Collection<T> collection, Comparator<T> comp) {
        T min = null;

        for (T element : collection) {
            if (min == null || comp.compare(min, element) > 0) {
                min = element;
            }
        }

        return min;
    }

    /**
     * Returns the first max element.
     *
     * @param collection collection of the elements
     * @param comp       comparator
     * @return the first max element
     */
    public static <T> T max(Collection<T> collection, Comparator<T> comp) {
        T max = null;

        for (T element : collection) {
            if (max == null || comp.compare(max, element) < 0) {
                max = element;
            }
        }

        return max;
    }

    /**
     * Reverse the specified array.
     *
     * @param list list to reverse
     */
    public static <T> void reverse(List<T> list) {

    }

    private static class UnmodifiableLinkedList<T> extends LinkedList<T> {
        public UnmodifiableLinkedList(List<T> list) {
            for (T element : list) {
                super.offerLast(element);
            }
        }

        @Override
        public boolean offerFirst(T o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean offerLast(T o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public T pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override
        public T pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean add(int index, T o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int index, Collection<? extends T> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public T set(int index, T o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public T remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean add(T o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection<? extends T> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(T o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<? extends T> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void sort(Comparator<T> comp) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    private static class UnmodifiableList<T> extends Vector<T> {
        public UnmodifiableList(T[] elements) {
            for (int i = 0; i < elements.length; i++) {
                super.add(i, elements[i]);
            }
        }

        @Override
        public boolean add(int index, T o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int index, Collection<? extends T> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public T set(int index, T o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public T remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean add(T o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection<? extends T> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(T o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<? extends T> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void sort(Comparator comp) {
            throw new UnsupportedOperationException();
        }
    }

    public static <T> void mergeSort(T[] a, T[] t, int l, int r, Comparator<T> comp) {
        if (l >= r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(a, t, l, m, comp);
        mergeSort(a, t, m + 1, r, comp);

        {
            int i = l;
            int j = m + 1;
            int k = l;
            while (i <= m && j <= r) {
                while (i <= m && (comp.compare(a[i], a[j]) <= 0)) {
                    t[k++] = a[i++];
                }
                if (i <= m) {
                    while (j <= r && (comp.compare(a[j], a[i]) < 0)) {
                        t[k++] = a[j++];
                    }
                }
            }
            while (i <= m) {
                t[k++] = a[i++];
            }
            while (j <= r) {
                t[k++] = a[j++];
            }
        }
        if (r + 1 - l >= 0) {
            System.arraycopy(t, l, a, l, r + 1 - l);
        }
    }

}
