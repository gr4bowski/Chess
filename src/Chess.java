public class Chess {

    boolean color; // 0 - black / 1 - white /

    char name;
    // P - Pawn
    // N - Knight
    // B - Bishop
    // Q - Queen
    // R - Rook
    // K - King

    boolean hasMoved;

    static boolean colorToMove = true;
    Chess(char name, boolean color) {
        this.name = name;
        this.color = color;
    }

    public static Chess[][] initializeGame() {
        Chess[][] board = new Chess[8][8];
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                Chess piece = new Chess('.', false); // . for free squares
                if (i == 2 || i == 7) { // setting up pawns
                    piece.name = 'P';
                } else if (i == 1 || i == 8) {
                    if (j == 1 || j == 8)
                        piece.name = 'R';
                    else if (j == 2 || j == 7)
                        piece.name = 'N';
                    else if (j == 3 || j == 6)
                        piece.name = 'B';
                    else if (j == 4)
                        piece.name = 'Q';
                    else
                        piece.name = 'K';
                }
                piece.color = i < 4;
                board[i-1][j-1] = piece;
            }
        }
        return board;
    }
    public static void visualization (Chess[][] board) {
        for (Chess[] row : board)
        {
            for (Chess piece : row)
                if (piece.name != '.') {
                    if (piece.color)
                        System.out.print("W" + piece.name + " ");
                    else
                        System.out.print("B" + piece.name + " ");
                } else
                    System.out.print(" . ");
            System.out.println();
        }
    }

    // movement notation => (xS yD): xS - starting position, yD - destination
    // x/y - letter (a - h)
    // S/D - number (1 - 8)
    public static Chess[][] move (Chess[][] board, String movement) {
        if (movement.length() != 5)
            return board;
        else
            movement = movement.toLowerCase();
        String[] move = movement.split(" ");
        String start = move[0];
        String destination = move[1];
        int i = Integer.parseInt(String.valueOf(start.charAt(1)))-1;
        int j = (int)start.charAt(0)-97;
        int m = Integer.parseInt(String.valueOf(destination.charAt(1)))-1;
        int n = (int)destination.charAt(0)-97;
        boolean possible = false;

        if (!(i > 0 && i < 9 && j > 0 && j < 9))
            return board;
        else if (board[m][n].name != '.' && board[m][n].color == board[i][j].color) {
            return board;
        }

        if (board[i][j].color == Chess.colorToMove)
                switch (board[i][j].name) {
            case '.':
                return board;
            case 'P':
                if ((i == 1 || i == 6) && Math.abs(i-m) == 2 && j - n == 0) {       // if pawn wants to move 2 tiles forward
                    if (board[(i+m)/2][n].name == '.' && board[m][n].name == '.')
                        possible = true;
                } else if (Math.abs(i-m) == 1) {                                    // if pawn wants to move 1 tile forward
                    if (Math.abs(j - n) == 1) {                                     // if pawn wants to take left/right
                        if (board[m][n].name != '.')
                            possible = true;
                    } else if (j - n == 0 && board[m][n].name == '.')
                        possible = true;
                }
                break;
            case 'N':
                break;
            case 'B':
                break;
            case 'R':
                break;
            case 'Q':
                break;
        }

        if (possible) {
            board[m][n] = board[i][j];
            board[i][j] = new Chess('.', false);
            Chess.colorToMove = !colorToMove;
        }
        return board;
    }
}
