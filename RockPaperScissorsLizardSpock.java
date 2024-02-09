import java.util.Scanner;

public class RockPaperScissorsLizardSpock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Player 1: ");
        String move1 = scanner.nextLine().trim().toLowerCase();

        System.out.print("Player 2: ");
        String move2 = scanner.nextLine().trim().toLowerCase();

        if (!isValidMove(move1) || !isValidMove(move2)) {
            System.out.println("Invalid move! Choose either rock, paper, scissors, lizard, or spock.");
            return;
        }

        if (move1.equals(move2)) {
            System.out.println("It's a tie!");
        } else {
            String winner;
            String reason;

            if (isMove1Win(move1, move2)) {
                winner = "Player 1";
                reason = getReason(move1, move2);
            } else {
                winner = "Player 2";
                reason = getReason(move2, move1);
            }

            System.out.println(winner + " wins. " + reason);
        }
    }

    public static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") ||
                move.equals("scissors") || move.equals("lizard") || move.equals("spock");
    }

    public static boolean isMove1Win(String move1, String move2) {
        return (move1.equals("rock") && (move2.equals("scissors") || move2.equals("lizard"))) ||
                (move1.equals("paper") && (move2.equals("rock") || move2.equals("spock"))) ||
                (move1.equals("scissors") && (move2.equals("paper") || move2.equals("lizard"))) ||
                (move1.equals("lizard") && (move2.equals("paper") || move2.equals("spock"))) ||
                (move1.equals("spock") && (move2.equals("scissors") || move2.equals("rock")));
    }

    public static String getReason(String move1, String move2) {
        if (move1.equals("rock")) {
            if (move2.equals("scissors")) {
                return "Rock crushes scissors!";
            } else {
                return "Rock crushes lizard!";
            }
        } else if (move1.equals("paper")) {
            if (move2.equals("rock")) {
                return "Paper covers rock!";
            } else {
                return "Paper disproves Spock!";
            }
        } else if (move1.equals("scissors")) {
            if (move2.equals("paper")) {
                return "Scissors cut paper!";
            } else {
                return "Scissors decapitate lizard!";
            }
        } else if (move1.equals("lizard")) {
            if (move2.equals("paper")) {
                return "Lizard eats paper!";
            } else {
                return "Lizard poisons Spock!";
            }
        } else if (move1.equals("spock")) {
            if (move2.equals("scissors")) {
                return "Spock smashes scissors!";
            } else {
                return "Spock vaporizes rock!";
            }
        } else {
            return "";
        }
    }
}
