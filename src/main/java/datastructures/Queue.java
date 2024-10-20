package main.java.datastructures;

import java.util.LinkedList;
import java.util.List;

/**
 * Queue implementation using LinkedList.
 * 
 * @param <T> Type of elements in the queue
 */
public class Queue<T> implements Iterable<T> {
    private List<T> list;

    public Queue() {
        // Can be replaced with an ArrayList
        list = new LinkedList<>();
    }

    /**
     * Adds an item to the end of the queue.
     * 
     * @param item Item to add
     */
    public void enqueue(T item) {
        list.add(item);
    }

    /**
     * Removes and returns the item at the front of the queue.
     * 
     * @return Item at the front of the queue
     */
    public T dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        // Remove and return the first item in the list (FIFO)
        return list.remove(0);
    }

    /**
     * Returns the number of elements in this queue.
     * 
     * @return Size of the queue
     */
    public int size() {
        return list.size();
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return list.iterator();
    }
}
