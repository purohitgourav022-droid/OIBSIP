import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Random random = new Random();
            
            int totalScore = 0;
            
            System.out.println("===== GUESS THE NUMBER GAME =====");
            System.out.print("Enter number of rounds: ");
            int rounds = sc.nextInt();
            
            for (int round = 1; round <= rounds; round++) {
                
                int secretNumber = random.nextInt(MAX - MIN + 1) + MIN;
                int attemptsLeft = MAX_ATTEMPTS;
                boolean guessedCorrectly = false;
                
                System.out.println("\n--- Round " + round + " ---");
                System.out.println("Guess a number between " + MIN + " and " + MAX);
                System.out.println("You have " + MAX_ATTEMPTS + " attempts.");
                
                while (attemptsLeft > 0) {
                    
                    System.out.print("Enter your guess: ");
                    
                    if (!sc.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        sc.next();
                        continue;
                    }
                    
                    int guess = sc.nextInt();
                    
                    if (guess < MIN || guess > MAX) {
                        System.out.println("Enter a number between "
                                + MIN + " and " + MAX);
                        continue;
                    }
                    
                    attemptsLeft--;
                    
                    if (guess == secretNumber) {
                        
                        guessedCorrectly = true;
                        
                        int points = attemptsLeft * 10 + 10;
                        totalScore += points;
                        
                        System.out.println("Correct! You guessed the number.");
                        System.out.println("Attempts used: "
                                + (MAX_ATTEMPTS - attemptsLeft));
                        System.out.println("Points earned: " + points);
                        
                        break;
                        
                    } else if (guess < secretNumber) {
                        System.out.println("Too low!");
                    } else {
                        System.out.println("Too high!");
                    }
                    
                    System.out.println("Attempts left: " + attemptsLeft);
                }
                
                if (!guessedCorrectly) {
                    System.out.println("You ran out of attempts.");
                    System.out.println("The correct number was: " + secretNumber);
                }
            }
            
            System.out.println("\n===== GAME OVER =====");
            System.out.println("Final Score: " + totalScore);
        }
    }

    public static int getMAX_ATTEMPTS() {
        return MAX_ATTEMPTS;
    }
}