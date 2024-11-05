import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int round = 1;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int maxAttempts = 5;
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + round + " ---");
            System.out.println("Guess the number between 1 and 100.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1);  // Higher score for fewer attempts
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == maxAttempts && !guessedCorrectly) {
                    System.out.println("Out of attempts! The correct number was " + targetNumber + ".");
                }
            }

            System.out.println("Score for this round: " + (guessedCorrectly ? (maxAttempts - attempts + 1) : 0));
            System.out.println("Total Score: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
            round++;
        }

        System.out.println("\nThank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
