import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Chess[][] board;

        System.out.println("Press Enter to start the game");
        String input = sc.nextLine();
        if (input.isEmpty()) {
            board = Chess.initializeGame();
            Chess.visualization(board);
        } else {
            System.out.println("See You next time!");
            return;
        }

        while (true) {
            if (Chess.colorToMove) {
                System.out.println("White to play:");
            } else {
                System.out.println("Black to play:");
            }
            input = sc.nextLine();
            if (input.equals("quit"))
                break;
            board = Chess.move(board, input);
            Chess.visualization(board);
        }
    }
}