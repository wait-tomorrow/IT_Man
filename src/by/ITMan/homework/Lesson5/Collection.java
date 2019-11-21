package by.ITMan.homework.Lesson5;

public interface Collection extends Iterable {
    int size();

    boolean isEmpty();

    boolean add(Object o);

    boolean addAll(Collection collection);

    boolean contains(Object o);

    boolean containsAll(Collection collection);

    boolean remove(Object o);

    boolean removeAll(Collection collection);

    void clear();

    boolean equals(Object object);

    Object[] toArray();
}
