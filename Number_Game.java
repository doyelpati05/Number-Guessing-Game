import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int attemptsLeft = 5; // Limited attempts
            int generatedNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between 1 and 100. You have " + attemptsLeft + " attempts.");

            for (int attempt = 1; attempt <= 5; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the correct number: " + generatedNumber);
                    totalScore += (6 - attempt); // Score based on attempts
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                attemptsLeft--;

                if (attemptsLeft == 0) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was: " + generatedNumber);
                }
            }

            System.out.println("Your current score: " + totalScore);
            System.out.print("Would you like to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
