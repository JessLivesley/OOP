import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain){
            int secretNumber = random.nextInt(100)+ 1;
            int guess = 0;
            int attempts = 0;

            System.out.println("Welcome to the guessing game.");
            System.out.println("Im thinking of a number between 1 and 100...");

            while (guess != secretNumber) {
                System.out.println("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number!");
                    scanner.next();
                    continue;
                }

                guess = scanner.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                } else if (guess < secretNumber) {
                    System.out.println("To low please try again");
                } else if (guess > secretNumber) {
                    System.out.println("To high please try again");
                } else {
                    System.out.println(" Correct! You guessed it right!!");
                }

            }
            System.out.println("Would you like to try again? (Yes/No): ");
            scanner.nextLine();
            String response = scanner.nextLine().trim().toLowerCase();

            if(!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
                System.out.println("Thanks for playing");
             }
         }
    }
}

