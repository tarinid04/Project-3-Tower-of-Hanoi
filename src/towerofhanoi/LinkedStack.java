package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tarini Duvvuri (tarinid)

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * LinkedStack is an implementation of the StackInterface using a linked
 * structure.
 *
 * @param <T>
 *            The type of elements stored in the stack.
 * 
 * @author Tarini Duvvuri
 * @version 10.17.23
 */
public class LinkedStack<T> implements StackInterface<T> {
    private int size;
    private Node topNode;

    /**
     * Constructs an empty LinkedStack with size set to 0 and topNode set to
     * null.
     */
    public LinkedStack() {
        size = 0;
        topNode = null;
    }


    /**
     * Returns the number of elements in the stack.
     *
     * @return The size of the stack.
     */
    public int size() {
        return size;
    }


    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Clears the stack by setting size to 0 and topNode to null.
     */
    public void clear() {
        size = 0;
        topNode = null;
    }


    /**
     * Returns a string representation of the elements in the stack.
     *
     * @return A string representing the elements in the stack.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = topNode;
        while (current != null) {
            result.append(current.getData());
            if (current.getNextNode() != null) {
                result.append(", ");
            }
            current = current.getNextNode();
        }
        result.append("]");
        return result.toString();
    }


    /**
     * Pushes an element onto the top of the stack.
     *
     * @param anEntry
     *            The element to push onto the stack.
     */
    public void push(T anEntry) {
        Node newNode = new Node(anEntry, topNode);
        topNode = newNode;
        size++;
    }


    /**
     * Retrieves the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack.
     * @throws EmptyStackException
     *             if the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack.
     * @throws EmptyStackException
     *             if the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return data;
    }

    /**
     * Node is an inner class that represents a node in the linked structure.
     */
    private class Node {
        private T data;
        private Node next;

        /**
         * Constructs a node with the given data and a reference to the next
         * node.
         *
         * @param data
         *            The data to store in the node.
         * @param next
         *            The next node in the linked structure.
         */
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }


        /**
         * Returns the data stored in the node.
         *
         * @return The data stored in the node.
         */
        public T getData() {
            return data;
        }


        /**
         * Returns the next node in the linked structure.
         *
         * @return The next node in the linked structure.
         */
        public Node getNextNode() {
            return next;
        }
    }

}
