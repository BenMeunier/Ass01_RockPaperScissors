import java.util.Scanner;

class Ass01_RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            String playerA = getPlayerMove(scanner, "player A"); // player A
            String playerB = getPlayerMove(scanner, "player B"); // player B
            String result = determineWinner(playerA, playerB); // two outcomes
            System.out.println(result);

            System.out.print("play again [Y/N]? "); // ask to play again
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("Y")); // will play again

        scanner.close();
        System.out.println("game over"); // end game
    }

    private static String getPlayerMove(Scanner scanner, String playerName) {
        String move;
        do {
            System.out.printf("%s, enter move (R, P, S): ", playerName); // players moves
            move = scanner.nextLine().toUpperCase();
            if (!move.equals("R") && !move.equals("P") && !move.equals("S")) {
                System.out.println("Invalid move enter R, P, or S."); // asnwer not R P or S
            }
        } while (!move.equals("R") && !move.equals("P") && !move.equals("S"));
        return move;
    }

    private static String determineWinner(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            return moveToString(playerA) + " vs " + moveToString(playerB) + ". Tied!"; // when both players enter the same choice
        }

        String matchResult = switch (playerA) {
            case "R" -> (playerB.equals("S")) ? "rock beat scissors." : "paper beats rock."; // when one player choose rock and wins or loses
            case "P" -> (playerB.equals("R")) ? "paper beats rock." : "scissors beats paper."; // when one player choose papers and wins or loses
            case "S" -> (playerB.equals("P")) ? "scissors beats paper." : "rock beats scissors."; // when player choose scissors and wins or loses
            default -> "";
        };

        String winner = (matchResult.startsWith(playerA)) ? "A wins!" : "B wins!"; // decides which player wins or loses
        return matchResult + " " + winner;
    }

    private static String moveToString(String move) {
        return switch (move) {
            case "R" -> "Rock"; // option R = Rock
            case "P" -> "Paper"; // option P = paper
            case "S" -> "Scissors"; // option S = scissors
            default -> "Unknown"; // when the player enters not one of the three options
        };
    }
}
