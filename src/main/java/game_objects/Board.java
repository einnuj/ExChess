package main.java.game_objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Parent class for all square Boards
 *
 * Created by einnuj on 12/27/2015.
 */
public abstract class Board {
    protected int[][] grid = new int[8][8];
    protected boolean isEmpty = true;
    protected int[] activePieceLocation = new int[] {-1, -1};
    protected List<Object> capturedPieces = null;

    protected Board() {}

    protected Board(int size) {
        grid = new int[size][size];
    }

    protected Board(int[][] grid) {
        this.grid = grid;
    }

    /*
    Getters
     */

    protected boolean isEmpty() { return isEmpty; }

    protected int[] getActivePieceLocation() { return activePieceLocation; }

    protected List<Object> getCapturedPieces() { return capturedPieces; }

    /*
    Setters
     */

    protected void setGrid(int[][] grid) { this.grid = grid; }

    protected void setActivePieceLocation(int[] activePieceLocation) {
        this.activePieceLocation[0] = activePieceLocation[0];
        this.activePieceLocation[1] = activePieceLocation[1];
    }

    protected void setCapturedPieces(ArrayList<Object> capturedPieces) {
        this.capturedPieces = capturedPieces;
    }


    /*
    Concrete Methods
     */

    /**
     * Empties the board and sets isEmpty to true
     */
    protected void clearBoard() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = -1;
            }
        }
        isEmpty = true;
    }

    /**
     * Resets active piece location
     */
    protected void resetActivePiece() {
        setActivePieceLocation(new int[] {-1, -1});
    }

    /**
     * Clears captured pieces
     */
    protected void clearCapturedPieces() {
        setCapturedPieces(new ArrayList<Object>());
    }

    /**
     * Resets the board entirely
     */
    protected void resetBoard() {
        clearBoard();
        resetActivePiece();
        clearCapturedPieces();
    }

    /**
     * Moves a piece at int[x, y] to another place int[p, q]. Does not check
     * for validity of move, collision, victory, etc
     * @param pieceLocation the location of the piece to move
     * @param targetLocation the location the piece should move to
     */
    protected void movePiece(int[] pieceLocation, int[] targetLocation) {
        int movingPiece = grid[pieceLocation[0]][pieceLocation[1]];
        grid[pieceLocation[0]][pieceLocation[1]] = -1;
        grid[targetLocation[0]][targetLocation[1]] = movingPiece;
    }

    /**
     * Pretty prints the board
     */
    protected void printBoard() {
        for (int i = 0; i < grid.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                s.append(grid[i][j]);
                s.append(' ');
            }
            System.out.println(s);
        }
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
