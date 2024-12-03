package org.example.games;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumbersGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int targetNumber = random.nextInt(101);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Let the game begin!");

        int[] guesses = new int[100];
        int guessCount = 0;

        while (true) {
            int guess = getValidInput(scanner);

            guesses[guessCount] = guess;
            guessCount++;

            if (guess < targetNumber) {
                System.out.println("Your number is too small. Please, try again.");
            } else if (guess > targetNumber) {
                System.out.println("Your number is too big. Please, try again.");
            } else {
                System.out.println("Congratulations, " + name + "!");
                break;
            }
        }
        printResult(guesses, guessCount);
    }

    private static int getValidInput(Scanner scanner) {
        int input = 0;
        while (true) {
            System.out.print("Enter your guess (0-100): ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input <= 100) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return input;
    }

    private static void reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    private static void printResult(int[] guesses, int guessCount) {
        System.out.print("Your numbers: ");
        int[] playerGuesses = Arrays.copyOfRange(guesses, 0, guessCount);
        Arrays.sort(playerGuesses);
        reverseArray(playerGuesses);
        for (int guess : playerGuesses) {
            System.out.print(guess + " ");
        }
    }
}

