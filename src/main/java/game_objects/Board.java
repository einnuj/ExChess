package main.java.game_objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Parent class for all square Boards
 *
 * Created by einnuj on 12/27/2015.
 */
public abstract class Board {
    protected ArrayList<ArrayList> grid = null;
    protected boolean isEmpty = true;
    protected int[] activePieceLocation = new int[] {-1, -1};
    protected List<Object> capturedPieces = null;

    protected Board() {}

    protected Board(int size) {
        grid = new ArrayList<ArrayList>(size);
        for (int i = 0; i < size; i++) {
            ArrayList<Object> aList = new ArrayList<Object>(size);
            for (int j = 0; j < size; j++) {
                aList.add(null);
            }
            grid.add(aList);
        }
    }

    protected Board(ArrayList<ArrayList> grid) {
        this.grid = grid;
    }

    /*
    Getters
     */

    protected boolean isEmpty() { return isEmpty; }

    protected int[] getActivePieceLocation() { return activePieceLocation; }

    /*
    Setters
     */

    protected void setGrid(ArrayList<ArrayList> grid) { this.grid = grid; }

    protected void setActivePieceLocation(int[] activePieceLocation) {
        this.activePieceLocation[0] = activePieceLocation[0];
        this.activePieceLocation[1] = activePieceLocation[1];
    }


    /*
    Concrete Methods
     */

    /**
     * Empties the board
     */
    protected void clearBoard() {
        for (ArrayList a : grid) {
            a.clear();
        }
    }

    /**
     * Moves a piece at int[x, y] to another place int[p, q]. Does not check
     * for validity of move, collision, victory, etc
     * @param pieceLocation the location of the piece to move
     * @param targetLocation the location the piece should move to
     */
    // @TODO: finish this first!
    protected void movePiece(int[] pieceLocation, int[] targetLocation) {
        return;
    }

    /**
     * Pretty prints the board
     */
    // @TODO: second. Also, decide on int lookup or pure object lists.
    protected void printBoard() {
        return;
    }

    /*
    Abstract Methods
     */

    /**
     * Sets up the board as specified by standard game rules
     */
    protected abstract void setupBoard();

    /**
     * Checks if a piece collides with another while moving. Does not check
     * for validity or victory.
     * @param pieceLocation the location of the piece to move
     * @param targetLocation the location the piece attempts to move to
     * @return
     */
    protected abstract boolean collides(int[] pieceLocation, int[]
            targetLocation);

    /**
     * Checks for game victory
     * @return an integer representing the victor; 0 otherwise.
     */
    protected abstract int isGameOver();
}
