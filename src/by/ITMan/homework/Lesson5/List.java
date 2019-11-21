package by.ITMan.homework.Lesson5;

public interface List extends Collection {
    boolean add(int index, Object o);

    boolean addAll(int index, Collection collection);

    Object get(int index);

    Object set(int index, Object o);

    Object remove(int index);
}
