package CodSoftTasks;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int min = 1;
        int max = 100;
        int MaxAttempts = 10;
        boolean PlayAgain = true;

        while (PlayAgain) {  //if the user wants to play again the loop will run
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("I have generated a number between " + min + " and " + max + ". Can you guess it?");
            
            while (attempts < MaxAttempts && !guessedCorrectly) {  //if the user has not guessed correctly and the attempts are less than the max attempts the loop will run
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;
                
                if (userGuess < numberToGuess) {   //conditions to check if the user's guess is too low or too high
                    System.out.println("Guessed Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Guessed Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                }
            }
            
            if (!guessedCorrectly) {  //if the user has not guessed correctly and the attempts are equal to the max attempts
                System.out.println("Sorry, you've used all " + MaxAttempts + " attempts. The number was " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String ask = sc.next();
            if (!ask.equalsIgnoreCase("yes")) {
                PlayAgain = false;    //if the user does not want to play again the loop will end
            }
        }
        
        System.out.println("Thank you for playing!");
        sc.close();
    }
}
