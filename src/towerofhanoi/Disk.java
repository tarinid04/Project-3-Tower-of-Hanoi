package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tarini Duvvuri (tarinid)

import java.awt.Color;
import student.TestableRandom;
import cs2.Shape;

/**
 * The Disk class represents a disk in the Tower of Hanoi puzzle.
 * It extends the Shape class to visualize disks and implements the Comparable
 * interface
 * for comparing disks based on their widths.
 * 
 * @author Tarini Duvvuri
 * @version 10.17.23
 */
public class Disk extends Shape implements Comparable<Disk> {

    private int width;

    /**
     * Constructs a Disk with the specified width and a random background color.
     *
     * @param width
     *            The width of the disk.
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        this.width = width;
        // Set the disk's background color to a random color
        TestableRandom random = new TestableRandom();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        Color randomColor = new Color(red, green, blue);
        this.setBackgroundColor(randomColor);
    }


    /**
     * Compares this disk to another disk based on their widths.
     *
     * @param otherDisk
     *            The disk to compare to.
     * @return A negative number if this disk is smaller, a positive number if
     *         it's larger,
     *         and 0 if their widths are equal.
     * @throws IllegalArgumentException
     *             If the other disk is null.
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException(
                "Cannot compare to a null disk.");
        }
        return this.width - otherDisk.width;
    }


    /**
     * Returns the width of the disk as a string.
     *
     * @return The width of the disk as a string.
     */
    public String toString() {
        return String.valueOf(width);
    }


    /**
     * Checks if this disk is equal to another object based on their widths.
     *
     * @param obj
     *            The object to compare to.
     * @return true if the objects are equal based on width, false otherwise.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Disk otherDisk = (Disk)obj;
        return width == otherDisk.width;
    }

}
