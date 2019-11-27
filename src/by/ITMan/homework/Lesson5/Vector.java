package by.ITMan.homework.Lesson5;

import java.util.Iterator;
import java.util.Objects;
import java.util.RandomAccess;

public class Vector<T> implements List<T>, RandomAccess {
    private T[] list;
    private int countElements;

    public Vector() {
        this(10);
    }

    public Vector(int initialSize) {
        list = (T[]) new Object[initialSize];
        countElements = 0;
    }

    @Override
    public boolean add(int index, T o) {
        if (index < 0 || index > countElements) {
            return false;
        }

        if (countElements == list.length) {
            resize();
        }

        for (int i = countElements - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = o;
        countElements++;

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<T> collection) {
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
        return list[index];
    }

    @Override
    public T set(int index, T o) {
        T oldElem = list[index];
        list[index] = o;

        return oldElem;
    }

    @Override
    public T remove(int index) {
        T deletedElem = list[index];

        countElements--;
        for (int i = index; i < countElements; i++) {
            list[i] = list[i + 1];
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
    public boolean addAll(Collection<T> collection) {
        return addAll(countElements, collection);
    }

    @Override
    public boolean contains(T o) {
        return findElem(o) != -1;
    }

    @Override
    public boolean containsAll(Collection<T> collection) {
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
    public boolean removeAll(Collection<T> collection) {
        boolean isVectorChanged = false;

        for (T o : collection) {
            if (remove(o)) {
                isVectorChanged = true;
            }
        }

        return isVectorChanged;
    }

    @Override
    public void clear() {
        countElements = 0;
        int size = list.length;
        list = (T[]) new Object[size];
    }

    @Override
    public T[] toArray() {
        int arrSize = size();
        T[] copy = (T[]) new Object[arrSize];

        for (int i = 0; i < arrSize; i++) {
            copy[i] = list[i];
        }

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

    @Override
    public Iterator iterator() {
        return new VectorIterator();
    }

    private void resize(int addCapacity) {
        int newCapacity = 0;

        if (addCapacity == 0) {
            newCapacity = list.length + addCapacity;
        } else {
            newCapacity = list.length * 2;
        }

        T[] newList = (T[]) new Object[newCapacity];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }

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

    private class VectorIterator implements Iterator {
        private int currentElem;

        public VectorIterator() {
            currentElem = -1;
        }

        @Override
        public boolean hasNext() {
            return currentElem + 1 < countElements;
        }

        @Override
        public T next() {
            return list[++currentElem];
        }

        @Override
        public void remove() {
            Vector.this.remove(currentElem);
            currentElem--;
        }
    }
}
