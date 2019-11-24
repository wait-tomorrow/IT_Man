package by.ITMan.homework.Lesson5;

import java.util.Iterator;
import java.util.Objects;

public class LinkedList implements List {
    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    public LinkedList() {
    }

    private class Node {
        private Object currentElem;
        private Node nextNode;
        private Node prevNode;

        private Node(Object currentElem, Node prevElem, Node nextElem) {
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

        public Object getCurrentNodeContent() {
            return currentElem;
        }

        public void setCurrentNodeContent(Object currentElem) {
            this.currentElem = currentElem;
        }
    }

    Object getFirst() {
        return firstNode.getCurrentNodeContent();
    }

    Object getLast() {
        return lastNode.getCurrentNodeContent();
    }

    boolean offerFirst(Object o) {
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

    boolean offerLast(Object o) {
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

    Object pollFirst() {
        Node result = firstNode;

        firstNode = result.nextNode;
        firstNode.prevNode = null;
        size--;

        return result.getCurrentNodeContent();
    }

    Object pollLast() {
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
    public boolean add(int index, Object o) {
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
    public boolean addAll(int index, Collection collection) {
        int i = 0;

        for (Object x : collection) {
            add(index + i, x);
            i++;
        }

        return true;
    }

    @Override
    public Object get(int index) {
        return findElemByIndex(index).getCurrentNodeContent();
    }

    @Override
    public Object set(int index, Object o) {
        Node oldElem = findElemByIndex(index);
        Node newElem = new Node(o, oldElem.prevNode, oldElem.nextNode);

        oldElem.prevNode.nextNode = newElem;
        oldElem.nextNode.prevNode = newElem;

        return oldElem.getCurrentNodeContent();
    }

    @Override
    public Object remove(int index) {
        Iterator itr = this.iterator();

        int i = 0;
        Object deletedElem;
        while (itr.hasNext()) {
            deletedElem = itr.next();

            if (i == index) {
                itr.remove();
                return deletedElem;
            }
            i++;
        }

        return null;
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
    public boolean add(Object o) {
        return offerLast(o);
    }

    @Override
    public boolean addAll(Collection collection) {
        for (Object o : collection) {
            offerLast(o);
        }

        return true;
    }

    @Override
    public boolean contains(Object o) {
        for(Object x : this){
            if(Objects.equals(x,o)){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        for (Object x : collection){
            if(!contains(x)){
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
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
        String result = "size = " + size() + " | elems: ";

        for (Object x : this) {
            result = result + x + "  ";
        }

        return result;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean result = false;

        for (Object x : collection) {
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
    public Object[] toArray() {
        Object[] arr = new Object[size()];

        int index = 0;
        for (Object x : this) {
            arr[index++] = x;
        }

        return arr;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {
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
        public Object next() {
            prevElem = currentElem;
            currentElem = currentElem.nextNode;
            index++;

            return prevElem.getCurrentNodeContent();
        }

        @Override
        public void remove() {
            Node node = prevElem;

            if (node.prevNode == null) {
                firstNode = node.nextNode;
                firstNode.prevNode = null;
            } else if (node.nextNode == null) {
                lastNode = node.prevNode;
                lastNode.nextNode = null;
            } else {
                node.nextNode.prevNode = node.prevNode;
                node.prevNode.nextNode = node.nextNode;
            }

            size--;
            index--;
            currentElem = node.nextNode;
        }
    }
}
