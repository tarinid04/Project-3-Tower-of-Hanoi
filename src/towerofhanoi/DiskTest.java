package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tarini Duvvuri (tarinid)

import org.junit.Test;

/**
 * Test class for Disk
 * 
 * @author Tarini Duvvuri
 * @version 10.17.23
 */
public class DiskTest extends student.TestCase {
    /**
     * Test the compareTo method of the Disk class.
     */
    @Test
    public void testCompareTo() {
        Disk disk1 = new Disk(5);
        Disk disk2 = new Disk(7);

        // Test compareTo
        assertEquals("Comparing a smaller disk to a larger disk should "
            + "return a negative number.", disk1.compareTo(disk2), -2);
        assertEquals("Comparing a larger disk to a smaller disk should "
            + "return a positive number.", disk2.compareTo(disk1), 2);
        assertEquals("Comparing two disks of equal width should " + "return 0.",
            disk1.compareTo(disk1), 0);

        // Test compareTo with null argument
        try {
            disk1.compareTo(null);
            fail("Expected IllegalArgumentException "
                + "to be thrown, but it wasn't.");
        }
        catch (IllegalArgumentException e) {
            // The expected exception was thrown.
        }

    }


    /**
     * Test the equals method of the Disk class.
     */
    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void testEquals() {
        Disk disk1 = new Disk(5);
        Disk disk2 = new Disk(7);
        Disk disk1Copy = new Disk(5);

        // Test equals with equal disks
        assertTrue("Two disks with the same width should be equal.", disk1
            .equals(disk1Copy));

        // Test equals with different disks
        assertFalse("Two disks with different widths should not be equal.",
            disk1.equals(disk2));

        // Test equals with non-Disk object
        assertFalse(
            "Comparing a Disk to a non-Disk object should return false.", disk1
                .equals("Not a Disk"));
    }

}
