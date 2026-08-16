import java.util.Scanner;
import java.util.Random;

class Player {
    String name;
    String choice;

    public Player(String name) {
        this.name = name;
    }

    public String getChoice() {
        return choice;
    }

    public String getName() {
        return name;
    }
}

class HumanPlayer extends Player {
    Scanner sc = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }

    public void makeChoice() {
        System.out.print("Enter Rock, Paper, or Scissors: ");
        choice = sc.next();
    }
}

class ComputerPlayer extends Player {
    Random random = new Random();

    public ComputerPlayer(String name) {
        super(name);
    }

    public void makeChoice() {
        String[] options = {"Rock", "Paper", "Scissors"};
        choice = options[random.nextInt(3)];
    }
}

public class Main {
    public static void main(String[] args) {

        HumanPlayer player = new HumanPlayer("Player");
        ComputerPlayer computer = new ComputerPlayer("Computer");

        player.makeChoice();
        computer.makeChoice();

        System.out.println("Computer chose: " + computer.getChoice());

        String p = player.getChoice().toLowerCase();
        String c = computer.getChoice().toLowerCase();

        if (!(p.equals("rock") || p.equals("paper") || p.equals("scissors"))) {
            System.out.println("Invalid Choice!");
        }
        else if (p.equals(c)) {
            System.out.println("It's a Draw!");
        }
        else if ((p.equals("rock") && c.equals("scissors")) ||
                 (p.equals("paper") && c.equals("rock")) ||
                 (p.equals("scissors") && c.equals("paper"))) {
            System.out.println(player.getName() + " Wins!");
        }
        else {
            System.out.println(computer.getName() + " Wins!");
        }
    }
}
