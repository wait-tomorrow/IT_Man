package by.ITMan.homework.Lesson5;

import java.util.Iterator;

public interface ListIterator<T> extends Iterator {

    boolean hasNext();

    T next();

    void remove();

    void set(T o);
}
