import java.util.Scanner;

public class Main {

    static final int rows = 4;
    static final int cols = 4;

    public static void printBoard(char[][] board) {
        System.out.println();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("0 1 2 3");
    }

    public static boolean checkWin(char[][] board, char player) {

        // Check rows
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player &&
                board[i][3] == player) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == player &&
                board[1][j] == player &&
                board[2][j] == player &&
                board[3][j] == player) {
                return true;
            }
        }

        // Check main diagonal
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player &&
            board[3][3] == player) {
            return true;
        }

        // Check other diagonal
        if (board[0][3] == player &&
            board[1][2] == player &&
            board[2][1] == player &&
            board[3][0] == player) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] board = new char[rows][cols];

        // Initialize board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '-';
            }
        }

        char player = 'X';

        while (true) {

            printBoard(board);

            System.out.print(
                "Player " + player + " choose column (0-3): "
            );

            int col = sc.nextInt();

            // Check valid column
            if (col < 0 || col >= cols) {
                System.out.println("Invalid column!");
                continue;
            }

            boolean placed = false;

            // Place from bottom to top
            for (int row = rows - 1; row >= 0; row--) {

                if (board[row][col] == '-') {
                    board[row][col] = player;
                    placed = true;
                    break;
                }
            }

            // Check if column is full
            if (!placed) {
                System.out.println("Column full!");
                continue;
            }

            // Check winner
            if (checkWin(board, player)) {
                printBoard(board);
                System.out.println("Player " + player + " wins!");
                break;
            }

            // Switch player
            player = (player == 'X') ? 'O' : 'X';
        }

        sc.close();
    }
}

