import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String playerName;
        String repeatGame;
        int playerScore = 0;
        int computerScore = 0;

        //Introduction
        System.out.println("Welcome to Rock, Paper, Scissors");
        System.out.println("Please enter your name below: ");
        playerName = myObj.nextLine();

        //Game loop
        while (true) {
            boolean gameResult;

            //Calling the two methods which run the game (See below main)
            gameResult = gameOutcome(convertPlayerChoice());
            if (gameResult == true) {
                System.out.println("");
                System.out.println("Congratulations " + playerName + ", you have won this round!");
                playerScore++;
                System.out.println("The current score is: " + playerName + ": " + playerScore + " vs. " + "Computer: " + computerScore + ".");
            } else {
                System.out.println("");
                System.out.println("Commiserations " + playerName + ", the computer won this round!");
                computerScore++;
                System.out.println("The current score is: " + playerName + ": " + playerScore + " vs. Computer: " + computerScore + ".");
            }
            System.out.println("");

            while (true) {
                System.out.println("Would you like to play another round? (Y/N)");
                repeatGame = myObj.nextLine();
                if (repeatGame.equalsIgnoreCase("N") || repeatGame.equalsIgnoreCase("No")) {

                    System.out.println("The final scores were: " + playerName + ": " + playerScore + " vs. Computer: " + computerScore + ".");
                    System.out.println("");
                    System.out.println("Thanks for playing!");
                    System.exit(0);

                } else if (repeatGame.equalsIgnoreCase("Y") || repeatGame.equalsIgnoreCase("Yes")) {

                    break;

                } else {
                    System.out.println("");
                    System.out.println("Input was unclear, please try again");

                    continue;

                }
            }
        }
    }

    //This first method receives a player input and converts it into an integer as that is easier to compare later
    public static int convertPlayerChoice() {
        Scanner myObj = new Scanner(System.in);
        int playerNumber;
        String playerChoice;

        //Input loop as if the player makes an error in inputting
        //Or there is a draw on the next method
        while (true) {
            System.out.println("");
            System.out.println("Please choose; Rock (R), Paper (P) or Scissors (S)");
            playerChoice = myObj.nextLine();
            if (playerChoice.equalsIgnoreCase("Rock") || playerChoice.equalsIgnoreCase("R")) {

                return playerNumber = 0;

            } else if (playerChoice.equalsIgnoreCase("Paper") || playerChoice.equalsIgnoreCase("P")) {

                return playerNumber = 1;

            } else if (playerChoice.equalsIgnoreCase("Scissors") || playerChoice.equalsIgnoreCase("S")) {

                return playerNumber = 2;

            } else {
                //Error checking for player input
                System.out.println("");
                System.out.println("Input was unclear, please try again");
                continue;
            }
        }
    }

    public static boolean gameOutcome(int playerNumber) {

        while (true) {

            Random random = new Random();
            int computerChoice = random.nextInt(2 - 0 + 1);

            if (playerNumber == computerChoice) {

                //This particular if statement checks for draws between player and computer and goes back to
                //Re-selecting the player choice if a draw is encountered
                System.out.println("");
                System.out.println("The result was a draw, please pick again: ");
                convertPlayerChoice();
                continue;

                //All the below are the possible outcomes of the games
                // 0 represents Rock, 1 represents Paper and 2 represents Scissors
            } else if (playerNumber == 0 && computerChoice == 2) {

                return true;

            } else if (playerNumber == 0 && computerChoice == 1) {

                return false;

            } else if (playerNumber == 1 && computerChoice == 0) {

                return true;

            } else if (playerNumber == 1 && computerChoice == 2) {

                return false;

            } else if (playerNumber == 2 && computerChoice == 1) {

                return true;

            } else if (playerNumber == 2 && computerChoice == 0) {

                return false;

            }

        }
    }
}
