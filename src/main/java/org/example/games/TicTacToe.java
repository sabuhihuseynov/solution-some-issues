package org.example.games;

import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameWon = false;

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = getValidInput(scanner);
            int col = getValidInput(scanner);

            if (board[row][col] != ' ') {
                System.out.println("This move is invalid. Try again.");
                continue;
            }
            board[row][col] = currentPlayer;
            printBoard();
            if (checkWin(currentPlayer, row, col)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameWon = true;
                break;
            }
            if (isBoardFull()) {
                System.out.println("The game is a draw!");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        if (!gameWon) {
            System.out.println("Game Over. No winner.");
        }
        scanner.close();
    }

    private static int getValidInput(Scanner scanner) {
        int input = 1;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 1 && input <= 3) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return input - 1;
    }

    public static void printBoard() {
        System.out.println("  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("  ---------  ");
        }
    }

    public static boolean checkWin(char player, int row, int col) {
        if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
            return true;
        }

        if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
            return true;
        }

        if (row == col && board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        return row + col == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

