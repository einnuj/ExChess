package game_logic.game_objects;

/**
 * Object that inherits ChessPiece, representing a Pawn
 *
 * Created by einnuj on 12/22/2015.
 */
public class PawnPiece extends ChessPiece{

    /*
    Constructor
     */

    public PawnPiece() {
        super();
    }

    public PawnPiece(boolean white) {
        super(white);
    }

    public PawnPiece(boolean white, int[] location) {
        super(white, location);
    }


    /*
    Methods
     */

    @Override
    protected boolean isValidMove(int[] target) {
        // Again, we assume the target is already within board bounds

        int x = this.location[0];
        int y = this.location[1];

        if ((target[0] == x) && (target[1] == y + 1)) {
            return true;
        }

        if ((target[0] == x) && (target[1] == y + 2) && (y == 1)) {
            return true;
        }

        // The Capture Case
        if (((target[0] == x + 1) || ((target[0] == x - 1) && x > 0)) &&
                (target[1] == y
                + 1)) {
            return true;
        }

        return false;
    }
}
