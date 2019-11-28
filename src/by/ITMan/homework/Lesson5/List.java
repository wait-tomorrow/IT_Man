package by.ITMan.homework.Lesson5;

import java.util.Comparator;

public interface List<T> extends Collection<T> {
    boolean add(int index, T o);

    boolean addAll(int index, Collection<T> collection);

    T get(int index);

    T set(int index, T o);

    T remove(int index);

    ListIterator iterator();

    default void sort(Comparator comp){

    };
}
