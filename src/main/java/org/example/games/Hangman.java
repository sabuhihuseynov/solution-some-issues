package org.example.games;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Hangman {
    private static final int MAX_ATTEMPTS = 6;
    private static final String[] WORDS = {
            "elephant", "chocolate", "airplane", "pyramid", "rainbow",
            "kangaroo", "giraffe", "volcano", "galaxy", "asteroid",
            "mountain", "ocean", "dolphin", "penguin", "avocado",
            "jungle", "lighthouse", "mermaid", "universe", "island",
            "diamond", "hurricane", "butterfly", "microscope",
            "fireworks", "waterfall", "moonlight", "sunflower",
            "alligator", "bamboo", "compass", "treasure", "sandcastle",
            "parachute", "sapphire", "tsunami", "honeycomb", "carousel",
            "helicopter", "squirrel", "telescope", "iceberg", "hibiscus",
            "submarine", "sundial", "strawberry", "thermometer"
    };

    private final String selectedWord;
    private final Set<Character> guessedLetters;
    private final Set<Character> wordCharacters;
    private int remainingAttempts;

    public Hangman() {
        Random random = new Random();
        selectedWord = WORDS[random.nextInt(WORDS.length)];
        guessedLetters = new HashSet<>();
        wordCharacters = new HashSet<>();
        for (char c : selectedWord.toCharArray()) {
            wordCharacters.add(c);
        }
        remainingAttempts = MAX_ATTEMPTS;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (remainingAttempts > 0) {
                displayWord();
                System.out.print("Guess a letter or the whole word (or type 'exit' to quit): ");
                String input = scanner.nextLine().trim().toLowerCase();

                if (input.equals("exit")) {
                    System.out.println("Thanks for playing!");
                    return;
                }

                if (input.length() == 1) {
                    processLetterGuess(input.charAt(0));
                } else if (processWordGuess(input)) {
                    return;
                }

                if (guessedLetters.containsAll(wordCharacters)) {
                    System.out.println("Congratulations! You've guessed the word: " + selectedWord);
                    return;
                }
            }
            System.out.println("Game Over! The word was: " + selectedWord);
        }
    }

    private void displayWord() {
        StringBuilder sb = new StringBuilder();
        for (char letter : selectedWord.toCharArray()) {
            sb.append(guessedLetters.contains(letter) ? letter : "_");
        }
        System.out.println(sb);
    }

    private void processLetterGuess(char guess) {
        if (guessedLetters.contains(guess)) {
            System.out.println("You've already guessed this letter.");
            return;
        }
        guessedLetters.add(guess);

        if (!wordCharacters.contains(guess)) {
            remainingAttempts--;
            System.out.println("Incorrect guess! Attempts left: " + remainingAttempts);
        }
    }

    private boolean processWordGuess(String input) {
        if (input.equals(selectedWord)) {
            System.out.println("Congratulations! You've guessed the word: " + selectedWord);
            return true;
        }
        remainingAttempts--;
        System.out.println("Incorrect guess! Attempts left: " + remainingAttempts);
        return false;
    }

    public static void main(String[] args) {
        new Hangman().start();
    }
}
