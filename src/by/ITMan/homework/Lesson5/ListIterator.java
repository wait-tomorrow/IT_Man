package by.ITMan.homework.Lesson5;

import java.util.Iterator;

public class ListIterator<T> implements Iterator {
    private int index;
    private List<T> list;

    public ListIterator(List list) {
        this.list = list;
        this.index = -1;
    }

    @Override
    public boolean hasNext() {
        return index + 1 < list.size();
    }

    @Override
    public T next() {
        index++;
        return list.get(index);
    }

    @Override
    public void remove() {
        if (index == -1) {
            throw new IllegalStateException();
        }

        list.remove(index);
        index--;
    }

    public void set(T o) {
        list.set(index, o);
    }
}
