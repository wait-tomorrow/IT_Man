package by.ITMan.homework.Lesson5;

import java.util.Iterator;
import java.util.RandomAccess;

public class Vector implements List, RandomAccess {
    private Object[] list;
    private int countElements;

    public Vector() {
        list = new Object[10];
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

        for (int i = countElements - 1; i >= index; i++) {
            list[i + 1] = list[i];
        }
        list[index] = o;

        return true;
    }

    @Override
    public boolean addAll(int index, Collection collection) {


        return false;
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

        return deletedElem;
    }

    @Override
    public int size() {
        return countElements;
    }

    @Override
    public boolean isEmpty() {
        if (countElements > 0) {
            return false;
        } else {
            return true;
        }
    }

    //====Collection
    @Override
    public boolean add(Object o) {
        return add(countElements, o);
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean result = this.isEmpty();
        this.clear();

        return result;
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

    @Override
    public Iterator iterator() {
        return null;
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


}
