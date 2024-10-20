package main.java.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Stack implementation using ArrayList.
 * 
 * @param <T> Type of elements in the stack
 */
public class Stack<T> {
    private List<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    /**
     * Constructor that takes a list.
     * 
     * @param list List to use as the stack
     */
    public Stack(List<T> list) {
        this.list = list;
    }

    /**
     * Adds an item to the top of the stack.
     * 
     * @param item Item to add
     */
    public void push(T item) {
        list.add(item);
    }

    /**
     * Removes and returns the item at the top of the stack.
     * 
     * @return Item at the top of the stack
     */
    public T pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        // Remove and return the last item in the list (LIFO)
        return list.remove(list.size() - 1);
    }

    /**
     * Returns the item at the top of the stack without removing it.
     * 
     * @return Item at the top of the stack
     */
    public void shuffle() {
        Collections.shuffle(list);
    }
}
