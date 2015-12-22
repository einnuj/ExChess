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
        return false;
    }
}
