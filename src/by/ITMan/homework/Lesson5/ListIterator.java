package by.ITMan.homework.Lesson5;

import java.util.Iterator;

public interface ListIterator<T> extends Iterator<T> {

    boolean hasNext();

    T next();

    void remove();

    /**
     * Replaces element at the specified position with the specified object.
     *
     * @param o the element that will be stored at the specified position after replace
     */
    void set(T o);
}
