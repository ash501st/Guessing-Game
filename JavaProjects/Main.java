import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Main class
public class Main {
    public static void main(String[] args) {
        // Creates an object for the class GuessingGame
        GuessingGame game = new GuessingGame();
        
        // Calls the function to start the game
        game.play();
    }
}

// GuessingGame class contains the instructions for the logic and rules
class GuessingGame {
    
    // Variables for the random number and maximum guessing attempts
    private int randomNumber;
    private int maxAttempts;
    
    // The array to store a list of all numbers the user guesses
    private ArrayList<Integer> pastGuesses;

     // GuessingGame function to set up the variables when the game object is created
    public GuessingGame() {
        this.maxAttempts = 7; // Maximum guess attempts allowed
        this.pastGuesses = new ArrayList<>(); // Initializing the empty collection list
    }

    // This function generates the random number that the user needs to guess
    public void generateSecretNumber() {
        Random randomGenerator = new Random();
        
        // Generates a random number between 0 and 49, then adds 1 to make it a range of 1 to 50
        this.randomNumber = randomGenerator.nextInt(50) + 1;
    }

    // Prints an introduction and the instructions
    public void printWelcomeMessage() {
        System.out.println("=========================================");
        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I have chosen a random number between 1 and 50.");
        System.out.println("You have " + this.maxAttempts + " total attempts to guess the right number.");
        System.out.println("=========================================");
    }

    // Loops through the Array and displays the previous guesses
    public void printGuessHistory() {
        System.out.print("Your previous guesses: ");
        
        // The for loop goes through the ArrayList one item at a time
        for (int i = 0; i < pastGuesses.size(); i++) {
            System.out.print(pastGuesses.get(i) + " ");
        }
        System.out.println(); // Moves the cursor to a new line
    }

    // This is where the core game loop takes place
    public void play() {
        // Triggers the setup functions
        generateSecretNumber();
        printWelcomeMessage();
        
        // Scanner reads the user input
        Scanner inputScanner = new Scanner(System.in);
        
        // A boolean to track if the player guessed correctly
        boolean staticWinStatus = false;
        
        // This loop runs once for every attempt until the user hits their max attempt
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            
            // Prints the current status
            System.out.println("\n--- Attempt " + attempt + " of " + maxAttempts + " ---");
            System.out.print("Enter your guess: ");
            
            // Reads the number the user types into the console
            int userGuess = inputScanner.nextInt();
            
            // Adds the user's current guess to the array
            pastGuesses.add(userGuess);
            
            // Checks if the user's guess matches, or is too high, or too low
            if (userGuess == randomNumber) {
                System.out.println("Correct! You guessed the right number!");
                staticWinStatus = true; // Marks that the user guessed correctly
                break; // Stops the loop
            } else if (userGuess > randomNumber) {
                System.out.println("Your guess is too high! Try a smaller number.");
            } else {
                System.out.println("Your guess is too low! Try a bigger number.");
            }
            
            // After a wrong guess this shows the previous guesses
            printGuessHistory();
        }
        
        // Prints if the user runs out of guesses
        if (staticWinStatus == false) {
            System.out.println("\n=========================================");
            System.out.println("Game Over! You have run out of guesses.");
            System.out.println("The secret number was: " + randomNumber);
            System.out.println("=========================================");
        }
        
        inputScanner.close();
    }
}