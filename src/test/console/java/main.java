package test.console.java;

import main.java.game_objects.KnightPiece;
import main.java.game_objects.PawnPiece;

import java.util.Random;
import java.util.Scanner;

/**
 * This class exists to test ExChess in the terminal
 *
 * Created by einnuj on 12/26/2015.
 */

public class main {

    public static void initBoard(Object[][] board) throws Exception {
        Random r = new Random();
        int kCount = 4;
        int pCount = 10;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int rand = r.nextInt(3);
                int white = r.nextInt(2);
                switch (rand) {
                    case 0:
                        board[i][j] = new Integer(-1);
                        break;
                    case 1:
                        if (pCount > 0) {
                            board[i][j] = new PawnPiece(white == 1, new int[]{i,
                                    j});
                            pCount--;
                        }
                        else {
                            board[i][j] = new Integer(-1);
                        }
                        break;
                    case 2:
                        if (kCount > 0) {
                            board[i][j] = new KnightPiece(white == 1, new int[]
                                    {i, j});
                            kCount--;
                        }
                        else {
                            board[i][j] = new Integer(-1);
                        }
                        break;
                    default:
                        throw new Exception();
                }
            }
        }
    }

    public static void printBoard(Object[][] board) {
        for (int i = 0; i < board.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                Object index = board[i][j];
                if (index instanceof Integer) {
                    s.append("--");
                }
                else if (index instanceof PawnPiece) {
                    PawnPiece p = (PawnPiece) index;
                    if (p.isWhite()) {
                        s.append("WP");
                    }
                    else {
                        s.append("BP");
                    }
                }
                else if (index instanceof KnightPiece) {
                    KnightPiece k = (KnightPiece) index;
                    if (k.isWhite()) {
                        s.append("WK");
                    }
                    else {
                        s.append("BK");
                    }
                }
                s.append(" ");
            }
            System.out.println(s);
        }
    }

    public static void manipulateBoard(Object[][] board) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean cont = true;

        while(cont) {
            printBoard(board);
            System.out.println("Enter a move: ");
            input = scanner.next();
        }
    }

    public static void main(String[] args) {
        Object[][] board = new Object[8][8];
        try {
            initBoard(board);
        }
        catch (Exception ex) {
            System.out.println("Error initializing board");
            System.exit(1);
        }
        printBoard(board);
        System.exit(0);
    }
}
