package by.ITMan.homework.Lesson5;

import java.util.Iterator;
import java.util.Objects;

/**
 * This class implements a linked list.
 *
 * @param <T> the type of the elements
 *
 * @author Dmitry Wroblewski
 */
public class LinkedList<T> implements List<T> {

    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    public LinkedList() {
    }

    private class Node {
        private T currentElem;
        private Node nextNode;
        private Node prevNode;

        private Node(T currentElem, Node prevElem, Node nextElem) {
            this.currentElem = currentElem;
            this.prevNode = prevElem;
            this.nextNode = nextElem;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }

        public T getCurrentNodeContent() {
            return currentElem;
        }

        public void setCurrentNodeContent(T currentElem) {
            this.currentElem = currentElem;
        }
    }

    /**
     * Returns the first element from the list.
     *
     * @return the first element from the list
     */
    public T getFirst() {
        return firstNode.getCurrentNodeContent();
    }

    /**
     * Returns the last element from the list.
     *
     * @return the last element from the list
     */
    public T getLast() {
        return lastNode.getCurrentNodeContent();
    }

    /**
     * Inserts the specified element to the head of the list.
     *
     * @param o specified element to insert
     * @return {@code true} if element is inserted
     */
    boolean offerFirst(T o) {
        Node newNode = new Node(o, null, firstNode);

        if (firstNode == null) {
            lastNode = newNode;
        } else {
            firstNode.prevNode = newNode;
        }

        firstNode = newNode;
        size++;

        return true;
    }

    /**
     * Inserts the specified element to the tail of the list.
     *
     * @param o specified element to insert
     * @return {@code true} if element is inserted
     */
    boolean offerLast(T o) {
        Node newNode = new Node(o, lastNode, null);

        if (lastNode == null) {
            firstNode = newNode;
        } else {
            lastNode.nextNode = newNode;
        }

        lastNode = newNode;
        size++;

        return true;
    }

    /**
     * Removes the first element of the list and returns removed element.
     *
     * @return removed element
     */
    T pollFirst() {
        Node result = firstNode;

        firstNode = result.nextNode;
        firstNode.prevNode = null;
        size--;

        return result.getCurrentNodeContent();
    }

    /**
     * Removes the last element of the list and returns removed element.
     *
     * @return removed element
     */
    T pollLast() {
        Node result = lastNode;

        lastNode = result.prevNode;
        lastNode.nextNode = null;
        size--;

        return result.getCurrentNodeContent();
    }

    private Node findElemByIndex(int index) {
        Node elem = firstNode;
        for (int i = 0; i < index; i++) {
            elem = elem.nextNode;
        }

        return elem;
    }

    @Override
    public boolean add(int index, T o) {
        Node elem = findElemByIndex(index);

        Node newNode = new Node(o, elem.prevNode, elem);

        if (elem.prevNode != null) {
            elem.prevNode.nextNode = newNode;
        } else {
            firstNode = newNode;
        }

        elem.prevNode = newNode;
        size++;

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<T> collection) {
        int i = 0;

        for (T x : collection) {
            add(index + i, x);
            i++;
        }

        return true;
    }

    @Override
    public T get(int index) {
        return findElemByIndex(index).getCurrentNodeContent();
    }

    @Override
    public T set(int index, T o) {
        Node oldElem = findElemByIndex(index);

        setNode(oldElem, o);

        return oldElem.getCurrentNodeContent();
    }

    private void setNode(Node oldElem, T o) {
        Node newElem = new Node(o, oldElem.prevNode, oldElem.nextNode);

        oldElem.prevNode.nextNode = newElem;
        oldElem.nextNode.prevNode = newElem;
    }

    @Override
    public T remove(int index) {
        Node currentElem = findElemByIndex(index);
        removeNode(currentElem);

        return currentElem.getCurrentNodeContent();
    }

    private void removeNode(Node currentElem) {
        if (currentElem.prevNode == null) {
            firstNode = currentElem.nextNode;
            firstNode.prevNode = null;
        } else if (currentElem.nextNode == null) {
            lastNode = currentElem.prevNode;
            lastNode.nextNode = null;
        } else {
            currentElem.nextNode.prevNode = currentElem.prevNode;
            currentElem.prevNode.nextNode = currentElem.nextNode;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T o) {
        return offerLast(o);
    }

    @Override
    public boolean addAll(Collection<T> collection) {
        for (T o : collection) {
            offerLast(o);
        }

        return true;
    }

    @Override
    public boolean contains(T o) {
        for (T x : this) {
            if (Objects.equals(x, o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<T> collection) {
        for (T x : collection) {
            if (!contains(x)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean remove(T o) {
        Iterator itr = iterator();

        while (itr.hasNext()) {
            if (itr.next().equals(o)) {
                itr.remove();

                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(size()).append(" | elems: ");

        for (T x : this) {
            sb.append(x).append("  ");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        LinkedList list2 = (LinkedList) obj;

        if (size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < size(); i++) {
            if (!Objects.equals(get(i), list2.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<T> collection) {
        boolean result = false;

        for (T x : collection) {
            System.out.println(x);
            if (remove(x)) {
                result = true;
            }
        }

        return result;
    }

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
        lastNode = null;
    }

    @Override
    public T[] toArray() {
        T[] arr = (T[]) new Object[size()];

        int index = 0;
        for (T x : this) {
            arr[index++] = x;
        }

        return arr;
    }

    @Override
    public ListIterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements ListIterator<T> {
        private Node currentElem;
        private Node prevElem;
        private int index = 0;

        public LinkedListIterator() {
            currentElem = firstNode;
        }

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            prevElem = currentElem;
            currentElem = currentElem.nextNode;
            index++;

            return prevElem.getCurrentNodeContent();
        }

        @Override
        public void remove() {
            Node node = prevElem;

            LinkedList.this.removeNode(node);

            index--;
            currentElem = node.nextNode;
        }

        @Override
        public void set(T o) {
            LinkedList.this.setNode(prevElem, o);
        }
    }
}
