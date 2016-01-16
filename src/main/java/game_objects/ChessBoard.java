package main.java.game_objects;

/**
 * Inherits from Board and simulates a standard Chess Board
 *
 * Created by einnuj on 1/1/2016.
 */

public class ChessBoard extends Board {

    private void initBackrow(boolean white) {
        int lookupOffset = white ? 0 : 6;

        for (int i = 0; i < grid[0].length; i++) {
            if (i == 0 || i == 7) {
                // Find index of relevant "Rook" piece in PieceMap. We're
                // coding it to be 3 for now.
                grid[0][i] = 3 + lookupOffset;
            }
            else if (i == 1 || i == 6) {
                // Same as before
                grid[0][i] = 1 + lookupOffset;
            }
            else if (i == 2 || i == 5) {
                grid[0][i] = 2 + lookupOffset;
            }
            else if (i == 3) {
                grid[0][i] = 4 + lookupOffset;
            }
            else if (i == 4) {
                grid[0][i] = 5 + lookupOffset;
            }
            else {
                // This should never occur. Handle it.
            }
        }
    }

    @Override
    protected void setupBoard() {
        // [0][0] = WRook
        // [0][1] = WKnight
        // [0][2] = WBishop
        // [0][3] = WQueen
        // [0][4] = WKing
        // [0][5] = WBishop
        // [0][6] = WKnight
        // [0][7] = WRook

        // Init White Backrow
        initBackrow(true);

        // Init White Frontrow
        for (int i = 0; i < grid[1].length; i++) {
            // Same thing; find the relevant index. Hard-coded for now.
            grid[1][i] = 0;
        }

        // Init Black Backrow
        initBackrow(false);

        // Init Black Frontrow
        for (int i = 0; i < grid[6].length; i++) {
            grid[6][i] = 6;
        }
    }

    @Override
    protected boolean collides(int[] pieceLocation, int[] targetLocation) {
        return false;
    }

    @Override
    protected int isGameOver() {
        return 0;
    }
}
