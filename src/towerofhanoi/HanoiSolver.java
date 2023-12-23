package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tarini Duvvuri (tarinid)

import java.util.Observable;

/**
 * Represents the logic for solving the Tower of Hanoi puzzle.
 * 
 * @author Tarini Duvvuri
 * @version 10.17.23
 */
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * Constructs a HanoiSolver with the specified number of disks and
     * initializes the towers.
     *
     * @param numDisks
     *            The number of disks in the puzzle.
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }

 
    /**
     * Get the number of disks in the puzzle.
     *
     * @return The number of disks.
     */
    public int disks() {
        return numDisks;
    }


    /**
     * Get the tower at the specified position.
     *
     * @param pos
     *            The position of the tower (LEFT, MIDDLE, or RIGHT).
     * @return The tower at the specified position.
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;
        }
    }


    /**
     * Returns a string representation of the current state of the puzzle.
     *
     * @return A string representation of the towers and their contents.
     */
    @Override
    public String toString() {
        return left.toString() + middle.toString() + right.toString();
    }


    /**
     * Moves a disk from the source tower to the destination tower.
     *
     * @param source
     *            The source tower.
     * @param destination
     *            The destination tower.
     */
    public void move(Tower source, Tower destination) {
        Disk disk = source.pop();
        destination.push(disk);
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * Recursive method to solve the Towers of Hanoi puzzle.
     *
     * @param currentDisks
     *            The number of disks to move.
     * @param startPole
     *            The source tower.
     * @param tempPole
     *            The temporary tower.
     * @param endPole
     *            The destination tower.
     */
    public void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * Initiates the solving of the Tower of Hanoi puzzle.
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }

}
