import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // Display game title
    public static void showTitle() {

        System.out.println("====================================");
        System.out.println("         NUMBER GUESS GAME");
        System.out.println("====================================");

    }

    // Get player names
    public static String[] getPlayerNames() {

        String[] players = new String[2];

        System.out.print("Enter Player 1 Name: ");
        players[0] = sc.next();

        System.out.print("Enter Player 2 Name: ");
        players[1] = sc.next();

        return players;
    }

    // Player 1 chooses secret number
    public static int chooseNumber(String player1) {

        int number;

        System.out.print(player1 + ", enter a secret number (1-100): ");
        number = sc.nextInt();

        while (number < 1 || number > 100) {
            System.out.print("Invalid! Enter number between 1 and 100: ");
            number = sc.nextInt();
        }

        return number;
    }

    // Reduced clear screen gap
    public static void clearScreen() {

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

    }

    // Give hints
    public static void giveHint(int guess, int secretNumber) {

        int difference = Math.abs(secretNumber - guess);

        if (difference == 0) {
            System.out.println("Excellent! Correct Guess.");
        }
        else if (difference <= 5) {
            System.out.println("Very Close!");
        }
        else if (difference <= 15) {
            System.out.println("Close Guess!");
        }
        else {
            System.out.println("Far Away!");
        }

        if (guess > secretNumber) {
            System.out.println("Hint: Try a Smaller Number");
        }
        else if (guess < secretNumber) {
            System.out.println("Hint: Try a Bigger Number");
        }

    }

    // Start game
    public static void startGame(String player2, int secretNumber) {

        int guess;
        int attempts = 0;
        int score = 100;

        long startTime = System.currentTimeMillis();

        do {

            System.out.print("\n" + player2 + ", enter your guess: ");
            guess = sc.nextInt();

            attempts++;

            if (guess != secretNumber) {
                score -= 10;
            }

            giveHint(guess, secretNumber);

        } while (guess != secretNumber);

        long endTime = System.currentTimeMillis();

        double totalTime = (endTime - startTime) / 1000.0;

        showResult(player2, attempts, score, totalTime);
    }

    // Display final result
    public static void showResult(String player2, int attempts, int score, double time) {

        if (score < 0) {
            score = 0;
        }

        System.out.println("\n========== GAME RESULT ==========");
        System.out.println("Winner         : " + player2);
        System.out.println("Attempts Taken : " + attempts);
        System.out.println("Final Score    : " + score);
        System.out.println("Time Taken     : " + time + " seconds");

        if (score >= 80) {
            System.out.println("Performance    : Excellent");
        }
        else if (score >= 50) {
            System.out.println("Performance    : Good");
        }
        else {
            System.out.println("Performance    : Average");
        }

        System.out.println("=================================");
    }

    // Ask to play again
    public static char playAgain() {

        System.out.print("\nDo you want to play again? (Y/N): ");
        return sc.next().charAt(0);
    }

    // Main method
    public static void main(String[] args) {

        char choice;

        do {

            showTitle();

            String[] players = getPlayerNames();

            int secretNumber = chooseNumber(players[0]);

            clearScreen();

            System.out.println(players[1] + ", start guessing the number!");

            startGame(players[1], secretNumber);

            choice = playAgain();

        } while (choice == 'Y' || choice == 'y');

        System.out.println("\nThank you for playing Number Guess Game!");

        sc.close();
    }
}

