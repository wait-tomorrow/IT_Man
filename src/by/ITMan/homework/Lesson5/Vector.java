package by.ITMan.homework.Lesson5;

import java.util.Comparator;
import java.util.Objects;
import java.util.RandomAccess;

/**
 * This one provides the ability to create a dimensionless array.
 *
 * @param <T> the type of the elements
 * @author Dmitry Wroblewski
 */
public class Vector<T> implements List<T>, RandomAccess {

    /**
     * This array contains all stored elements.
     */
    private T[] list;

    /**
     * The number of elements that list is contains.
     */
    private int countElements;

    /**
     * Constructs a Vector with standard initial capacity.
     */
    public Vector() {
        this(10);
    }

    /**
     * Constructs a Vector with specified capacity.
     *
     * @param initialSize value that determines the initial size of array
     */
    @SuppressWarnings("unchecked")
    public Vector(int initialSize) {
        list = (T[]) new Object[initialSize];
        countElements = 0;
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > countElements) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndexForGetOrRemove(int index) {
        if (index < 0 || index >= countElements) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean add(int index, T o) {
        checkIndexForAdd(index);

        if (countElements == list.length) {
            resize();
        }

        if (countElements - index >= 0) {
            System.arraycopy(list, index, list, index + 1, countElements - index);
        }
        list[index] = o;
        countElements++;

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        checkIndexForAdd(index);

        if (collection.size() == 0) {
            return false;
        }

        if (size() + collection.size() > list.length) {
            resize(list.length - size() + collection.size());
        }

        int i = 0;
        for (T o : collection) {
            add(index + i, o);
            i++;
        }

        return true;
    }

    @Override
    public T get(int index) {
        checkIndexForGetOrRemove(index);

        return list[index];
    }

    @Override
    public T set(int index, T o) {
        checkIndexForGetOrRemove(index);

        T oldElem = list[index];
        list[index] = o;

        return oldElem;
    }

    @Override
    public T remove(int index) {
        checkIndexForGetOrRemove(index);

        T deletedElem = list[index];

        countElements--;
        if (countElements - index >= 0) {
            System.arraycopy(list, index + 1, list, index, countElements - index);
        }

        //delete last elem
        list[countElements] = null;

        return deletedElem;
    }

    @Override
    public int size() {
        return countElements;
    }


    @Override
    public boolean isEmpty() {
        return countElements == 0;
    }

    //====Collection
    @Override
    public boolean add(T o) {
        return add(countElements, o);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return addAll(countElements, collection);
    }

    @Override
    public boolean contains(T o) {
        return findElem(o) != -1;
    }

    @Override
    public boolean containsAll(Collection<? extends T> collection) {
        for (T o : collection) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean remove(T o) {
        int elemIndex = findElem(o);

        if (elemIndex != -1) {
            remove(elemIndex);
            return true;
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<? extends T> collection) {
        boolean isVectorChanged = false;

        for (T o : collection) {
            if (remove(o)) {
                isVectorChanged = true;
            }
        }

        return isVectorChanged;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        countElements = 0;
        int size = list.length;
        list = (T[]) new Object[size];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        int arrSize = size();
        T[] copy = (T[]) new Object[arrSize];

        System.arraycopy(list, 0, copy, 0, arrSize);

        return copy;
    }

    //return element index
    private int findElem(T o) {
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(list[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @SuppressWarnings("unchecked")
    private void resize(int addCapacity) {
        int newCapacity;

        if (addCapacity == 0) {
            newCapacity = list.length + addCapacity;
        } else {
            newCapacity = list.length * 2;
        }

        T[] newList = (T[]) new Object[newCapacity];

        System.arraycopy(list, 0, newList, 0, list.length);

        this.list = newList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(size()).append(" | ");

        for (int i = 0; i < size(); i++) {
            sb.append("[").append(list[i]).append("] ");
        }

        return sb.toString();
    }

    private void resize() {
        resize(0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Vector v2 = (Vector) obj;

        if (size() != v2.size()) {
            return false;
        }

        for (int i = 0; i < size(); i++) {
            if (!Objects.equals(get(i), v2.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void sort(Comparator comp) {
        quickSort(list, 0, size() - 1, comp);
    }

    @SuppressWarnings("unchecked")
    private void quickSort(Object[] a, int l, int r, Comparator comp) {
        int m = l + (r - l) / 2;

        if (comp.compare(a[l], a[m]) > 0) {
            Object t = a[l];
            a[l] = a[m];
            a[m] = t;
        }

        if (comp.compare(a[l], a[r]) > 0) {
            Object t = a[l];
            a[l] = a[r];
            a[r] = t;
        }

        if (comp.compare(a[m], a[r]) > 0) {
            Object t = a[r];
            a[r] = a[m];
            a[m] = t;
        }

        Object x = a[m];

        int i = l + 1;
        int j = r - 1;

        while (i <= j) {
            while (comp.compare(a[i], x) < 0) {
                i++;
            }
            while (comp.compare(a[j], x) > 0) {
                j--;
            }
            if (i <= j) {
                Object t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }

        if (l < j) {
            quickSort(a, l, j, comp);
        }

        if (i < r) {
            quickSort(a, i, r, comp);
        }
    }

    @Override
    public ListIterator iterator() {
        return new VectorIterator();
    }

    class VectorIterator implements ListIterator<T> {
        private int index;

        public VectorIterator() {
            this.index = -1;
        }

        @Override
        public boolean hasNext() {
            return index + 1 < size();
        }

        @Override
        public T next() {
            index++;
            return get(index);
        }

        @Override
        public void remove() {
            checkIndex();

            Vector.this.remove(index);
            index--;
        }

        public void set(T o) {
            checkIndex();

            Vector.this.set(index, o);
        }

        private void checkIndex() {
            if (index == -1) {
                throw new IllegalStateException();
            }
        }
    }
}
