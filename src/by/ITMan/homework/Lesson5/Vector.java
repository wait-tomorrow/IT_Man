package by.ITMan.homework.Lesson5;

import java.util.Iterator;
import java.util.Objects;
import java.util.RandomAccess;

public class Vector implements List, RandomAccess {
    private Object[] list;
    private int countElements;

    public Vector() {
        this(10);
    }

    public Vector(int initialSize) {
        list = new Object[initialSize];
        countElements = 0;
    }

    @Override
    public boolean add(int index, Object o) {
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
    public boolean addAll(int index, Collection collection) {
        if (collection.size() == 0) {
            return false;
        }

        if (size() + collection.size() > list.length) {
            resize(list.length - size() + collection.size());
        }

        int i = 0;
        for (Object o : collection) {
            add(index + i, o);
            i++;
        }

        return true;
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public Object set(int index, Object o) {
        list[index] = o;
        return true;
    }

    @Override
    public Object remove(int index) {
        Object deletedElem = list[index];

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
    public boolean add(Object o) {
        return add(countElements, o);
    }

    @Override
    public boolean addAll(Collection collection) {
        return addAll(countElements, collection);
    }

    @Override
    public boolean contains(Object o) {
        return findElem(o) != -1;
    }

    @Override
    public boolean containsAll(Collection collection) {
        for (Object o : collection) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int elemIndex = findElem(o);

        if (elemIndex != -1) {
            remove(elemIndex);
            return true;
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean isVectorChanged = false;

        for (Object o : collection) {
            if (remove(o)) {
                isVectorChanged = true;
            }
        }

        return isVectorChanged;
    }

    @Override
    public void clear() {
        int size = list.length;
        list = new Object[size];
    }

    @Override
    public Object[] toArray() {
        Object[] copy = new Object[list.length];

        for (int i = 0; i < list.length; i++) {
            copy[i] = list[i];
        }

        return copy;
    }

    //return element index
    private int findElem(Object o) {
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(list[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public Iterator iterator() {
        return new vectorIterator();
    }

    private void resize(int addCapacity) {
        int newCapacity = 0;

        if (addCapacity == 0) {
            newCapacity = list.length + addCapacity;
        } else {
            newCapacity = list.length * 2;
        }

        Object[] newList = new Object[newCapacity];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }

        this.list = newList;
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

    private class vectorIterator implements Iterator {
        private int currentElem;

        public vectorIterator() {
            currentElem = 0;
        }

        @Override
        public boolean hasNext() {
            return currentElem + 1 <= countElements;
        }

        @Override
        public Object next() {
            return list[currentElem++];
        }
    }
}
