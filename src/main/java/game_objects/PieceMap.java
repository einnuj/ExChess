package main.java.game_objects;

/**
 * Maps integers to ChessPieces
 *
 * Created by einnuj on 1/1/2016.
 */
public class PieceMap {
    private static PieceMap instance = new PieceMap();
    private ChessPiece[] map = new ChessPiece[6];

    private PieceMap() {
        map[0] = new PawnPiece();
        map[1] = new KnightPiece();

        // map[2] = new BishopPiece();
        // map[3] = new RookPiece();
        // map[4] = new QueenPiece();
        // map[5] = new KingPiece();
    }

    public static PieceMap getInstance() {
        return instance;
    }
}
