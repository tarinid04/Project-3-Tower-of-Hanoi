package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tarini Duvvuri (tarinid)

/**
 * Test cases for the HanoiSolver class.
 * 
 * @author Tarini Duvvuri
 * @version 10.17.23
 */
public class HanoiSolverTest extends student.TestCase {

    private HanoiSolver solver;

    /**
     * Set up the test by creating an instance of HanoiSolver with 3 disks.
     */
    public void setUp() {
        solver = new HanoiSolver(3);
    }


    /**
     * Test the {@link HanoiSolver#disks()} method.
     */
    public void testDisks() {
        assertEquals(3, solver.disks());
    }


    /**
     * Test the getTower method of the HanoiSolver class.
     */
    public void testGetTower() {

        // Test getting left tower
        assertEquals(
            "Getting the left tower should return the left tower instance.",
            solver.getTower(Position.LEFT), solver.getTower(Position.LEFT));

        // Test getting middle tower
        assertEquals(
            "Getting the middle tower should return the middle tower instance.",
            solver.getTower(Position.MIDDLE), solver.getTower(Position.MIDDLE));

        // Test getting right tower
        assertEquals(
            "Getting the right tower should return the right tower instance.",
            solver.getTower(Position.RIGHT), solver.getTower(Position.RIGHT));

        // Test getting default tower
        assertEquals("Getting the default tower should return the middle tower "
            + "instance.", solver.getTower(Position.MIDDLE), solver.getTower(
                Position.DEFAULT));
    }


    /**
     * Test the toString method of the HanoiSolver class.
     */
    public void testToString() {
        Disk disk1 = new Disk(3);
        Disk disk2 = new Disk(2);

        // Set up towers
        solver.getTower(Position.LEFT).push(disk1);
        solver.getTower(Position.RIGHT).push(disk2);

        String actual = solver.toString();

        assertEquals(
            "The string representation of the towers should match the expected "
                + "string.", "[3][][2]", actual);
    }


    /**
     * Test the solve method of the HanoiSolver class.
     */
    public void testSolve() {
        // Add disks to the left tower
        solver.getTower(Position.LEFT).push(new Disk(3));
        solver.getTower(Position.LEFT).push(new Disk(2));
        solver.getTower(Position.LEFT).push(new Disk(1));

        // Call solve
        solver.solve();

        // Check that all disks have moved to the right tower
        assertTrue("The left tower should be empty after solving.", solver
            .getTower(Position.LEFT).isEmpty());
        assertTrue("The middle tower should not be empty after solving.", solver
            .getTower(Position.MIDDLE).isEmpty());
        assertFalse("The right tower should not be empty after solving.", solver
            .getTower(Position.RIGHT).isEmpty());
    }

}
