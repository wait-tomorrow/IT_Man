package by.ITMan.homework.Lesson5;

public interface Collection<T> extends Iterable<T> {
    /**
     * Returns the number of elements in the collection.
     *
     * @return the number of elements in the collection
     */
    int size();

    /**
     * Returns {@code true} if collection is empty
     *
     * @return {@code true} if collection is empty
     */
    boolean isEmpty();

    /**
     * Insert specified element in the end of the collection
     *
     * @param o element to insert
     * @return {@code true} if collection is changed
     */
    boolean add(T o);

    /**
     * Inserts all elements of the specified collection at the end of the collection.
     *
     * @param collection collection contains elements to insert
     * @return {@code true} if all specified elements are inserted successfully
     */
    boolean addAll(Collection<T> collection);

    /**
     * Returns {@code true} if this collection contains the specified element.
     *
     * @param o element to check
     * @return {@code true} if this collection contains the specified element
     */
    boolean contains(T o);

    /**
     * Returns {@code true} if this collection contains all elements of the specified collection.
     *
     * @param collection collection contains elements to check
     * @return {@code true} if this collection contains all elements of the specified collection
     */
    boolean containsAll(Collection<T> collection);

    /**
     * Removes specified element.
     *
     * @return {@code true} if collection is changed
     */
    boolean remove(T o);

    /**
     * Removes all elements contains in the specified collection.
     *
     * @param collection collection contains elements to remove
     * @return {@code true} if collection is changed
     */
    boolean removeAll(Collection<T> collection);

    /**
     * Removes all of the elements from collection.
     */
    void clear();

    /**
     * Returns {@code true} if specified object is the same as this collection.
     *
     * @param object object to compare
     * @return {@code true} if specified object is the same as this collection
     */
    boolean equals(Object object);

    /**
     * Returns an array created from elements in this collection.
     *
     * @return an array created from elements in this collection
     */
    T[] toArray();

    /**
     * Returns a String created from list elements.
     *
     * @return a String created from list elements
     */
    String toString();
}
