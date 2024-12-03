package org.example.games;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    private String[] words = {
            "elephant", "chocolate", "airplane", "pyramid", "rainbow",
            "kangaroo", "giraffe", "volcano", "galaxy", "asteroid",
            "mountain", "ocean", "dolphin", "penguin", "avocado",
            "jungle", "lighthouse", "mermaid", "universe", "island",
            "diamond", "hurricane", "butterfly", "tornado", "microscope",
            "fireworks", "waterfall", "moonlight", "sunflower", "alligator",
            "bamboo", "compass", "treasure", "sandcastle", "parachute",
            "sapphire", "tsunami", "honeycomb", "carousel", "helicopter",
            "squirrel", "telescope", "iceberg", "hibiscus", "submarine",
            "sundial", "strawberry", "carousel", "thermometer", "tornado"
    };
    private String selectedWord;
    private HashSet<Character> guessedLetters;
    private int remainingAttempts;

    public Hangman() {
        Random random = new Random();
        selectedWord = words[random.nextInt(words.length)];
        guessedLetters = new HashSet<>();
        remainingAttempts = 6;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (remainingAttempts > 0) {
            displayWord();
            System.out.print("Guess a letter or the whole word (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing!");
                return;
            }
            if (input.length() == 1) {
                processLetterGuess(input.charAt(0));
            } else if(isWordGuessed(input)) {
                return;
            }
            if (isAllLettersGuessed()) {
                System.out.println("Congratulations! You've guessed the word: " + selectedWord);
                return;
            }
        }

        System.out.println("Game Over! The word was: " + selectedWord);
    }

    private void displayWord() {
        for (char letter : selectedWord.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                System.out.print(letter);
            } else {
                System.out.print("_");
            }
        }
        System.out.println();
    }

    public void processLetterGuess(char guess) {
        guessedLetters.add(guess);
        if (!selectedWord.contains(String.valueOf(guess))) {
            remainingAttempts--;
            System.out.println("Incorrect guess! Attempts left: " + remainingAttempts);
        }
    }

    public boolean isWordGuessed(String input) {
        if (input.equalsIgnoreCase(selectedWord)) {
            System.out.println("Congratulations! You've guessed the word: " + selectedWord);
            return true;
        }
        remainingAttempts--;
        System.out.println("Incorrect guess! Attempts left: " + remainingAttempts);
        return false;
    }

    private boolean isAllLettersGuessed() {
        for (char letter : selectedWord.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        new Hangman().start();
    }
}

