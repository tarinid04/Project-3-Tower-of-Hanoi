package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tarini Duvvuri (tarinid)

/**
 * A class representing a tower in the Tower of Hanoi puzzle.
 * 
 * @author Tarini Duvvuri
 * @version 10.17.23
 */
public class Tower extends LinkedStack<Disk> {

    private Position position;

    /**
     * Constructs a new Tower with the specified position.
     *
     * @param position
     *            The position of the tower (LEFT, MIDDLE, or RIGHT).
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * Get the position of the tower.
     *
     * @return The position of the tower.
     */
    public Position position() {
        return position;
    }


    /**
     * Push a disk onto the tower. Checks if it's a valid move according to the
     * Tower of Hanoi rules.
     *
     * @param disk
     *            The disk to push onto the tower.
     * @throws IllegalStateException
     *             If the move is invalid.
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException("Invalid disk push.");
        }

        else if (!isEmpty() && peek().compareTo(disk) <= 0) {
            throw new IllegalStateException("Invalid disk push.");
        }
        super.push(disk);
    }

}
