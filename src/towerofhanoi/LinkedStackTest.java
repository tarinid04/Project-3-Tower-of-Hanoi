package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tarini Duvvuri (tarinid)

import java.util.EmptyStackException;
import org.junit.Before;

/**
 * Test cases for the LinkedStack class.
 * 
 * @author Tarini Duvvuri
 * @version 10.17.23
 */
public class LinkedStackTest extends student.TestCase {

    private LinkedStack<Integer> stack;

    /**
     * Set up a fresh LinkedStack for each test case.
     */
    @Before
    public void setUp() {
        stack = new LinkedStack<>();
    }


    /**
     * Test pushing an element onto the stack and peeking at the top element.
     */
    public void testPushAndPeek() {
        stack.push(1);
        stack.push(2);

        int expected = 2;
        int actual = stack.peek();

        assertEquals("Peek should return the top element (2) after pushing "
            + "1 and 2 onto the stack.", expected, actual);
    }


    /**
     * Test pushing elements onto the stack and popping them off.
     */
    public void testPushAndPop() {
        stack.push(1);
        stack.push(2);

        int popped1 = stack.pop();
        int popped2 = stack.pop();

        int expected1 = 2;
        int expected2 = 1;

        assertEquals("First popped element should be 2 after pushing 1 "
            + "and 2 onto the stack.", expected1, popped1);
        assertEquals("Second popped element should be 1 after pushing 1 "
            + "and 2 onto the stack.", expected2, popped2);
    }


    /**
     * Test pushing elements onto the stack and checking if it's empty.
     */
    public void testIsEmpty() {
        assertTrue("A new LinkedStack should be empty.", stack.isEmpty());

        stack.push(1);

        assertFalse("A LinkedStack with one element should not be empty.", stack
            .isEmpty());
    }


    /**
     * Test pushing elements onto the stack and clearing it.
     */
    public void testClear() {
        stack.push(1);
        stack.push(2);

        stack.clear();

        assertTrue("After clearing the LinkedStack, it should be empty.", stack
            .isEmpty());
    }


    /**
     * Test the size of the stack after pushing elements onto it.
     */
    public void testSize() {
        assertEquals("A new LinkedStack should have a size of 0.", 0, stack
            .size());

        stack.push(1);
        stack.push(2);

        assertEquals(
            "After pushing 1 and 2 onto the LinkedStack, the size should be 2.",
            2, stack.size());
    }


    /**
     * Test popping from an empty stack should throw an EmptyStackException.
     */
    public void testPopEmptyStackException() {
        boolean exceptionThrown = false;
        try {
            stack.pop();
        }
        catch (EmptyStackException e) {
            exceptionThrown = true;
        }

        assertEquals("Expected EmptyStackException to be thrown", true,
            exceptionThrown);
    }


    /**
     * Test peeking into an empty stack should throw an EmptyStackException.
     */
    public void testPeekEmptyStackException() {
        boolean exceptionThrown = false;

        try {
            stack.peek();
        }
        catch (EmptyStackException e) {
            // The expected exception was thrown.
            exceptionThrown = true;
        }

        assertTrue("Expected EmptyStackException to be thrown",
            exceptionThrown);
    }


    /**
     * Test the toString method to represent the elements in the stack.
     */
    public void testToString() {
        stack.push(1);
        stack.push(2);

        String expected = "[2, 1]";
        String actual = stack.toString();

        assertEquals(
            "The string representation of the LinkedStack should be [2, 1].",
            expected, actual);
    }

}
