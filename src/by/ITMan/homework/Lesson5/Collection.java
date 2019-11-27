package by.ITMan.homework.Lesson5;

public interface Collection<T> extends Iterable<T> {
    int size();

    boolean isEmpty();

    boolean add(T o);

    boolean addAll(Collection<T> collection);

    boolean contains(T o);

    boolean containsAll(Collection<T> collection);

    boolean remove(T o);

    boolean removeAll(Collection<T> collection);

    void clear();

    boolean equals(Object object);

    T[] toArray();
}
