package by.ITMan.homework.Lesson5;

import java.util.Comparator;

public interface List<T> extends Collection<T> {

    /**
     * Inserts the specified element at the specified position.
     * Shifts the element currently at that position and other
     * elements to the right.
     *
     * @param index index determines the position of inserting element
     * @param o     element will be inserted
     * @return {@code true} if specified element is inserted successfully
     */
    boolean add(int index, T o);

    /**
     * Inserts all elements of the specified collection at the specified position.
     * Shifts the element currently at that position and other
     * elements to the right.
     *
     * @param index      index determines the start position of the inserting elements
     * @param collection collection contains elements to insert
     * @return {@code true} if all specified elements are inserted successfully
     */
    boolean addAll(int index, Collection<? extends T> collection);

    /**
     * Returns the element at the specified position.
     *
     * @param index index of element to return
     * @return the element at the specified position
     */
    T get(int index);

    /**
     * Replaces element at the specified position
     * with the specified element.
     *
     * @param index index of the element to replace
     * @param o     element that will be stored at the specified position after replace
     * @return replaced element
     */
    T set(int index, T o);

    /**
     * Removes element at the specified position.
     * Shifts other elements to the left.
     *
     * @param index index of the element to remove
     * @return removed element
     */
    T remove(int index);

    /**
     * Returns an iterator for this collection.
     *
     * @return an iterator for this collection
     */
    ListIterator<T> iterator();

    /**
     * This method will sort the list with O(N log N) complexity.
     *
     * @param comp comparator defines the way objects will be compared
     */
    void sort(Comparator<T> comp);
}
