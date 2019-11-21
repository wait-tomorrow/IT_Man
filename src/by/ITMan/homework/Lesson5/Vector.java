package by.ITMan.homework.Lesson5;

import java.util.Iterator;

public class Vector implements List {
    private Object[] list;
    private int countElements;
    private java.util.Vector test = new java.util.Vector();

    public Vector() {
        list = new Object[10];
        countElements = 0;
    }

    public Vector(int size) {
        list = new Object[size];
        countElements = 0;
    }

    @Override
    public boolean add(int index, Object o) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection collection) {
        return false;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object o) {
        return null;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return countElements;
    }

    @Override
    public boolean isEmpty() {
        if(countElements > 0){
            return false;
        } else {
            return true;
        }
    }

    //====Collection
    @Override
    public boolean add(Object o) {
        if(countElements == list.length){
            this.increaseSize();
        }

        list[countElements] = o;
        countElements++;
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

    private void increaseSize() {
        Object[] newList = new Object[list.length * 2];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }

        this.list = newList;
    }
}
