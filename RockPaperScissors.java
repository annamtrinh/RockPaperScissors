import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] choices = {"Rock", "Paper", "Scissors"};

        int userWins = 0;
        int computerWins = 0;
        int ties = 0;
        int gamesPlayed = 0;
        boolean playing = true;

        while (playing) {
            System.out.println("\nROCK PAPER SCISSORS! Choose: 1 for Rock, 2 for Paper, 3 for Scissors:");

            int userChoice;
            try {
                userChoice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter 1, 2, or 3.");
                continue;
            }

            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Please enter 1, 2, or 3.");
                continue;
            }

            int computerChoice = (int) (Math.random() * 3) + 1;
            System.out.println("You chose " + choices[userChoice - 1] + ".");
            System.out.println("I choose " + choices[computerChoice - 1] + "!");

            if (userChoice == computerChoice) {
                System.out.println("It's a tie!");
                ties++;
            } else if ((userChoice == 1 && computerChoice == 3)
                    || (userChoice == 2 && computerChoice == 1)
                    || (userChoice == 3 && computerChoice == 2)) {
                System.out.println("You win!");
                userWins++;
            } else {
                System.out.println("You lose!");
                computerWins++;
            }

            gamesPlayed++;
            System.out.println("You have won " + userWins + " games");
            System.out.println("The compiler has won " + computerWins + " games");
            System.out.println("You have tied " + ties + " games");
            System.out.println("Games played: " + gamesPlayed);

            // Ask to play again until the answer is valid
            while (true) {
                System.out.println("Would you like to play again? (1 for yes, 2 for no)");
                String again = scan.nextLine();
                if (again.equals("1")) {
                    break;
                } else if (again.equals("2")) {
                    playing = false;
                    break;
                } else {
                    System.out.println("Please enter 1 or 2.");
                }
            }
        }

        System.out.println("\nThe end result is:");
        System.out.println(userWins + " won");
        System.out.println(computerWins + " lost");
        System.out.println(ties + " tied");
        System.out.println("and a total of " + gamesPlayed + " games played");
        System.out.println("Thanks for playing!");

        scan.close();
    }
}