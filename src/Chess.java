public class Chess {

    boolean color; // 0 - black / 1 - white /

    char name;
    // P - Pawn
    // N - Knight
    // B - Bishop
    // Q - Queen
    // R - Rook
    // K - King

    Chess(char name, boolean color) {
        this.name = name;
        this.color = color;
    }

    public static Chess[][] initializeGame() {
        Chess[][] board = new Chess[8][8];
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                Chess piece = new Chess('.', false); // # for free squares
                if (i == 2 || i == 7) { // setting up pawns
                    piece.name = 'P';
                    piece.color = i == 2;
                } else if (i == 1 || i == 8) {
                    if (j == 1 || j == 8) {
                        piece.name = 'R';

                    }
                }
                board[i-1][j-1] = piece;
            }
        }
        return board;
    }
    public static void visualization (Chess[][] board) {
        for (Chess[] row : board)
        {
            for (Chess piece : row)
                System.out.print(piece.name + " ");
            System.out.println();
        }
    }
}
