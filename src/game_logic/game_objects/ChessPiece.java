package game_logic.game_objects;

/**
 * Created by einnuj on 12/21/2015.
 */
public abstract class ChessPiece {
    // Is this piece white or black?
    private boolean white = true;

    // Currently being 'held'
    private boolean activePiece = false;

    // X by Y coordinates of piece
    private int[] location = new int[2];


    /*
    Getters
     */

    private boolean isWhite() { return white; }

    private boolean isActivePiece() { return activePiece; }

    private int[] getLocation() { return location; }

    /*
    Setters
     */

    private void setActivePiece(boolean activePiece) {
        this.activePiece = activePiece;
    }

    private void setLocation(int[] location) {
        this.location = location;
    }


    /*
    Methods
     */

    /**
     * Checks to see if this piece can execute this move
     * @param target - the coordinates the piece is to be moved
     * @return a boolean reflecting whether the move is legal
     */
    abstract boolean isValidMove(int[] target);
}
