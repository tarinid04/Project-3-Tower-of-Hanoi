package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tarini Duvvuri (tarinid)

/**
 * The ProjectRunner class contains the main method to run the Tower of Hanoi
 * puzzle.
 * 
 * @author Tarini Duvvuri
 * @version 10.17.23
 */
public class ProjectRunner {

    public static void main(String[] args) {
        int disks = 6; // Default number of disks

        if (args.length == 1) {
            // Parse the number of disks from the command line argument
            disks = Integer.parseInt(args[0]);
        }

        // Create a new PuzzleWindow and pass it a new HanoiSolver with the
        // number of disks
        @SuppressWarnings("unused")
        PuzzleWindow puzzleWindow = new PuzzleWindow(new HanoiSolver(disks));
    }

}
