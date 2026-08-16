import java.util.Scanner;

public class Main {

    static char[] board = {
        '1', '2', '3',
        '4', '5', '6',
        '7', '8', '9'
    };

    static void displayBoard() {

        System.out.println();

        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);

        System.out.println();
    }

    static boolean checkWinner(char ch) {

        int[][] win = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
        };

        for (int[] w : win) {

            if (board[w[0]] == ch &&
                board[w[1]] == ch &&
                board[w[2]] == ch) {

                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char player = 'X';

        for (int move = 0; move < 9; move++) {

            displayBoard();

            System.out.print(
                "Player " + player + ", enter position (1-9): "
            );

            int pos = sc.nextInt() - 1;

            if (pos < 0 || pos > 8 ||
                board[pos] == 'X' ||
                board[pos] == 'O') {

                System.out.println("Invalid Move!");
                move--;
                continue;
            }

            board[pos] = player;

            if (checkWinner(player)) {

                displayBoard();
                System.out.println("Player " + player + " Wins!");
                return;
            }

            player = (player == 'X') ? 'O' : 'X';
        }

        displayBoard();
        System.out.println("Match Draw!");
    }
}
