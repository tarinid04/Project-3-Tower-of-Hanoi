package towerofhanoi;

import org.junit.Test;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tarini Duvvuri (tarinid)
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tarini Duvvuri (tarinid)

/**
 * Test cases for the Tower class.
 * 
 * @author Tarini Duvvuri
 * @version 10.17.2023
 */
public class TowerTest extends student.TestCase {
    /**
     * Test pushing a valid disk onto an empty tower (valid).
     */
    @Test
    public void testPushValidEmptyTower() {
        Tower tower = new Tower(Position.LEFT);
        Disk disk = new Disk(3);

        try {
            // Push a valid disk onto an empty tower (valid)
            tower.push(disk);
        }
        catch (Exception e) {
            // If an exception is thrown, fail the test
            throw new AssertionError(
                "Expected no exception when pushing a valid disk.");
        }

        // No exception should be thrown, and the tower should contain the
        // pushed disk.
        assertEquals(1, tower.size());
    }


    /**
     * Test pushing a smaller disk onto the tower (valid).
     */
    @Test
    public void testPushValidSmallerDisk() {
        Tower tower = new Tower(Position.LEFT);
        Disk disk1 = new Disk(3);
        Disk disk2 = new Disk(2);

        try {
            // Push a valid disk onto the tower (valid)
            tower.push(disk1);
        }
        catch (Exception e) {
            // If an exception is thrown, fail the test
            throw new AssertionError(
                "Expected no exception when pushing a valid disk.");
        }

        try {
            // Push a smaller disk onto the tower (valid)
            tower.push(disk2);
        }
        catch (Exception e) {
            // If an exception is thrown, fail the test
            throw new AssertionError(
                "Expected no exception when pushing a smaller disk.");
        }
        // No exception should be thrown, and the tower should contain both
        // disks.
        assertEquals(2, tower.size());
    }


    /**
     * Test pushing a larger disk onto the tower (invalid).
     */
    @Test
    public void testPushInvalidLargerDisk() {
        Tower tower = new Tower(Position.LEFT);
        Disk disk1 = new Disk(2);
        Disk disk2 = new Disk(3);

        try {
            // Push a valid disk onto the tower (valid)
            tower.push(disk1);
        }
        catch (Exception e) {
            // If an exception is thrown, fail the test
            throw new AssertionError(
                "Expected no exception when pushing a valid disk.");
        }

        try {
            // Attempt to push a larger disk onto the tower (invalid)
            tower.push(disk2);
            // If the push operation doesn't throw an exception, fail the test
            throw new AssertionError("Expected an IllegalStateException when "
                + "pushing a larger disk.");
        }
        catch (IllegalStateException e) {
            // The expected exception was thrown.
            assertEquals("Exception message should match the expected message",
                "Invalid disk push.", e.getMessage());

        }
        // The tower should not contain the larger disk.
        assertEquals(1, tower.size());
    }


    /**
     * Test pushing a null disk onto the tower (invalid).
     */
    @Test
    public void testPushInvalidNullDisk() {
        Tower tower = new Tower(Position.LEFT);
        Disk nullDisk = null;

        try {
            // Attempt to push a null disk onto the tower (invalid)
            tower.push(nullDisk);
            // If the push operation doesn't throw an exception, fail the test
            throw new AssertionError(
                "Expected an IllegalArgumentException when "
                    + "pushing a null disk.");
        }
        catch (IllegalArgumentException e) {
            // The expected exception was thrown.
            assertEquals("Exception message should match the expected message",
                "Invalid disk push.", e.getMessage());

        }

        // The tower should remain empty.
        assertEquals(0, tower.size());
    }


    /**
     * Test the position method of the Tower class.
     */
    public void testPosition() {
        Tower tower = new Tower(Position.RIGHT);
        Position expected = Position.RIGHT;
        Position actual = tower.position();

        assertEquals("The tower's position should match the expected position.",
            expected, actual);
    }

}
