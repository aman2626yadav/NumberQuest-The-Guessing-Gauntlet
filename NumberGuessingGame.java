import java.util.Random;
import java.util.Scanner;

/**
 * Number Guessing Game
 * ---------------------
 * - Computer picks a random number in a range (default 1-100).
 * - Player guesses the number and gets feedback: too high / too low / correct.
 * - Limited attempts per round.
 * - Score tracking across multiple rounds (based on attempts used).
 * - Option to play again.
 */
public class NumberGuessingGame {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("      WELCOME TO THE NUMBER GUESSING GAME");
        System.out.println("=============================================");

        int totalScore = 0;
        int roundsPlayed = 0;
        int roundsWon = 0;

        while (true) {
            int low = 1;
            int high = 100;
            int maxAttempts = 7;

            System.out.print("\nCustomize range and attempts? (y/n): ");
            String customize = scanner.nextLine().trim().toLowerCase();

            if (customize.equals("y")) {
                try {
                    System.out.print("Enter lower bound: ");
                    low = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Enter upper bound: ");
                    high = Integer.parseInt(scanner.nextLine().trim());
                    if (low >= high) {
                        System.out.println("Lower bound must be less than upper bound. Using defaults 1-100.");
                        low = 1;
                        high = 100;
                    }
                    System.out.print("Enter max attempts: ");
                    maxAttempts = Integer.parseInt(scanner.nextLine().trim());
                    if (maxAttempts <= 0) {
                        System.out.println("Attempts must be positive. Using default of 7.");
                        maxAttempts = 7;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Using defaults (1-100, 7 attempts).");
                    low = 1;
                    high = 100;
                    maxAttempts = 7;
                }
            }

            int points = playRound(low, high, maxAttempts);
            roundsPlayed++;
            if (points > 0) {
                roundsWon++;
            }
            totalScore += points;

            System.out.println("\n--- SCOREBOARD ---");
            System.out.println("Rounds played: " + roundsPlayed);
            System.out.println("Rounds won:    " + roundsWon);
            System.out.println("Total score:   " + totalScore);
            System.out.println("------------------");

            System.out.print("\nPlay another round? (y/n): ");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("y")) {
                break;
            }
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Final Score: " + totalScore + " points over " + roundsPlayed +
                " round(s), won " + roundsWon + ".");
        System.out.println("Goodbye! \uD83D\uDC4B");

        scanner.close();
    }

    /**
     * Plays a single round. Returns points earned this round (0 if lost).
     */
    private static int playRound(int low, int high, int maxAttempts) {
        int target = random.nextInt(high - low + 1) + low;
        int attemptsUsed = 0;

        System.out.println("\nI'm thinking of a number between " + low + " and " + high + ".");
        System.out.println("You have " + maxAttempts + " attempts. Good luck!\n");

        while (attemptsUsed < maxAttempts) {
            int guess = getValidGuess(low, high);
            attemptsUsed++;
            int remaining = maxAttempts - attemptsUsed;

            if (guess == target) {
                int points = Math.max(100 - (attemptsUsed - 1) * 10, 10);
                System.out.println("\n\uD83C\uDF89 Correct! The number was " + target + ".");
                System.out.println("You used " + attemptsUsed + " attempt(s) and scored " + points + " points.");
                return points;
            } else if (guess < target) {
                System.out.print("Too low! ");
            } else {
                System.out.print("Too high! ");
            }

            if (remaining > 0) {
                System.out.println(remaining + " attempt(s) left.\n");
            } else {
                System.out.println();
            }
        }

        System.out.println("\n\uD83D\uDE22 Out of attempts! The number was " + target + ".");
        return 0;
    }

    /**
     * Keeps asking until the user enters a valid integer within range.
     */
    private static int getValidGuess(int low, int high) {
        while (true) {
            System.out.print("Enter your guess (" + low + "-" + high + "): ");
            String raw = scanner.nextLine().trim();

            try {
                int guess = Integer.parseInt(raw);
                if (guess < low || guess > high) {
                    System.out.println("Your guess must be between " + low + " and " + high + ".");
                    continue;
                }
                return guess;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}
