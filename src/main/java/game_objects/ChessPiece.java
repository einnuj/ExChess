package main.java.game_objects;

/**
 * Abstract class representing traits/methods all pieces should have
 *
 * Created by einnuj on 12/21/2015.
 */
public abstract class ChessPiece {
    // Is this piece white or black?
    protected boolean white = true;

    // Currently being 'held'
    protected boolean activePiece = false;

    // X by Y coordinates of piece
    protected int[] location = new int[2];

    /*
    Constructors
     */

    protected ChessPiece() {}

    protected ChessPiece(boolean white) {
        this.white = white;
        setLocation(new int[] {-1, -1});
    }

    protected ChessPiece(boolean white, int[] location) {
        this.white = white;
        setActivePiece(false);
        setLocation(location);
    }

    /*
    Getters
     */

    protected boolean isWhite() { return white; }

    protected boolean isActivePiece() { return activePiece; }

    protected int[] getLocation() { return location; }

    /*
    Setters
     */

    protected void setActivePiece(boolean activePiece) {
        this.activePiece = activePiece;
    }

    protected void setLocation(int[] location) {
        this.location[0] = location[0];
        this.location[1] = location[1];
    }


    /*
    Methods
     */

    /**
     * Checks to see if this piece can execute this move
     * @param target - the coordinates the piece is to be moved
     * @return a boolean reflecting whether the move is legal
     */
    protected abstract boolean isValidMove(int[] target);
}
