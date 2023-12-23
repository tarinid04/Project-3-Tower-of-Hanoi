package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tarini Duvvuri (tarinid)

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The main front-end work and the view for the Tower of Hanoi puzzle
 *
 * @author Tarini Duvvuri
 * @version 10.17.2023
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    /**
     * A factor in which the width of the disks are multiplied by
     */
    public static final int WIDTH_FACTOR = 15;
    /**
     * The vertical gap between each disk on the tower
     */
    public static final int DISK_GAP = 0;
    /**
     * The height of each disk on the tower
     */
    public static final int DISK_HEIGHT = 15;

    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g
     *            the game to create a view for
     */
    public PuzzleWindow(HanoiSolver g) {
        this.game = g;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        window.setSize(800, 600);

        int poleHeight = 400;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape(200 - 15 / 2, poleY, 15, poleHeight, new Color(50, 50,
            50));
        middle = new Shape((window.getGraphPanelWidth() / 2) - 15 / 2, poleY,
            15, poleHeight, new Color(50, 50, 50));
        right = new Shape((window.getGraphPanelWidth() - 200) - 15 / 2, poleY,
            15, poleHeight, new Color(50, 50, 50));

        int numDisks = game.disks();
        for (int width = (numDisks + 1)
            * WIDTH_FACTOR; width > WIDTH_FACTOR; width -= WIDTH_FACTOR) {
            Disk disk = new Disk(width);
            game.getTower(Position.LEFT).push(disk);
            window.addShape(disk);
            moveDisk(Position.LEFT);
        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        Button solveButton = new Button("Solve");
        window.addButton(solveButton, WindowSide.NORTH);
        solveButton.onClick(this, "clickedSolve");
    }


    private void moveDisk(Position position) {
        Tower tower = game.getTower(position);
        Disk currentDisk = tower.peek();
        Shape currentPole = null;

        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            case RIGHT:
                currentPole = right;
                break;
            default:
                break;
        }

        int newX = currentPole.getX() - (currentDisk.getWidth() / 2);
        int newY = currentPole.getY() - (currentDisk.getHeight() * (tower.size()
            - 1)) - DISK_GAP;
        currentDisk.moveTo(newX, newY);
    }


    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o
     *            The observable that triggered the update
     * @param arg
     *            arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }


    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button
     *            the button that was clicked
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread(() -> game.solve()).start();
    }


    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }

}
