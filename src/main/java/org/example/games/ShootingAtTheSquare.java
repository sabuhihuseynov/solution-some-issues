package org.example.games;

import java.util.Random;
import java.util.Scanner;

public class ShootingAtTheSquare {


    public static char[][] field = new char[5][5];

    public static void initializeField() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                field[i][j] = '-';
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        initializeField();

        int targetRow = random.nextInt(5);
        int targetCol = random.nextInt(5);

        System.out.println("All set. Get ready to rumble!");

        while (true) {
            int row = getValidInput(scanner, "Enter line (1-5): ", 5) - 1;
            int col = getValidInput(scanner, "Enter column (1-5): ", 5) - 1;

            if (field[row][col] == '*') {
                System.out.println("You already shot here! Try again.");
                continue;
            }
            if (row == targetRow && col == targetCol) {
                field[row][col] = 'x';
                printField(field);
                System.out.println("You have won!");
                break;
            } else {
                field[row][col] = '*';
            }
            printField(field);
        }
        scanner.close();
    }

    private static int getValidInput(Scanner scanner, String prompt, int max) {
        int input = 0;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 1 && input <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return input;
    }

    private static void printField(char[][] field) {
        System.out.print("  ");
        for (int i = 1; i <= 5; i++) {
            System.out.print("| " + i + " ");
        }
        System.out.println("|");

        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print("| " + field[i][j] + " ");
            }
            System.out.println("|");
        }
    }
}

