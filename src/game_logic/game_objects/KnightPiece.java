package game_logic.game_objects;

/**
 * Object that inherits ChessPiece, representing a Knight
 *
 * Created by einnuj on 12/21/2015.
 */
public class KnightPiece extends ChessPiece {

    /*
    Constructor
     */
    public KnightPiece() {
        super();
    }

    public KnightPiece(boolean white) {
        super(white);
    }

    public KnightPiece(boolean white, int[] location) {
        super(white, location);
    }


    /*
    Methods
     */

    @Override
    protected boolean isValidMove(int[] target) {
        // We must assume this target is within the bounds of the board. Let
        // the controller check this for us, as our pieces have no business
        // doing so.

        // Create a temp location to mess around with
        int x = this.location[0];
        int y = this.location[1];

        // Horizontal L Valid
        if ((x + 2 == target[0] || x - 2 == target[0]) && (y + 1 ==
                target[1] || y - 1 == target[1])) {
            return true;
        }

        // Vertical L Valid
        if ((y + 2 == target[1] || y - 2 == target[1]) && (x + 1 ==
                target[0] || x - 1 == target[0])) {
            return true;
        }

        // Reaching here means the Knight can never reach the target in one
        // move.
        return false;
    }
}
