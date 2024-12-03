package org.example.games;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class ShipBattleGame {

    private static final int MAP_SIZE = 10;
    private static final int TOTAL_BOMBS = 100;
    private static char[][] map = new char[MAP_SIZE][MAP_SIZE];
    private static char[][] visibleMap = new char[MAP_SIZE][MAP_SIZE];
    private static int[][] shipMap = new int[MAP_SIZE][MAP_SIZE];
    private static int[] shipHealth;
    private static int totalShips;
    private static final Random random = new SecureRandom();

    private static void initializeMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = '.';
                visibleMap[i][j] = '.';
                shipMap[i][j] = -1;
            }
        }
    }

    private static void placeShips() {
        int[] shipSizes = {5, 4, 3, 3, 2, 2};
        totalShips = shipSizes.length;
        shipHealth = new int[totalShips];

        for (int shipId = 0; shipId < shipSizes.length; shipId++) {
            boolean placed = false;
            int size = shipSizes[shipId];

            while (!placed) {
                int x = random.nextInt(MAP_SIZE);
                int y = random.nextInt(MAP_SIZE);
                boolean horizontal = random.nextBoolean();

                if (canPlaceShip(x, y, size, horizontal)) {
                    for (int i = 0; i < size; i++) {
                        int nx = x + (horizontal ? 0 : i);
                        int ny = y + (horizontal ? i : 0);
                        map[nx][ny] = 'S';
                        shipMap[nx][ny] = shipId;
                    }
                    shipHealth[shipId] = size;
                    placed = true;
                }
            }
        }
    }

    private static boolean canPlaceShip(int x, int y, int size, boolean horizontal) {
        for (int i = 0; i < size; i++) {
            int nx = x + (horizontal ? 0 : i);
            int ny = y + (horizontal ? i : 0);

            if (nx < 0 || ny < 0 || nx >= MAP_SIZE || ny >= MAP_SIZE || map[nx][ny] == 'S') {
                return false;
            }

            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    int sx = nx + dx;
                    int sy = ny + dy;
                    if (sx >= 0 && sy >= 0 && sx < MAP_SIZE && sy < MAP_SIZE && map[sx][sy] == 'S') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        int bombs = TOTAL_BOMBS;
        int shipsRemaining = totalShips;

        while (bombs > 0 && shipsRemaining > 0) {
            printVisibleMap();

            System.out.println("Bombs left: " + bombs);
            System.out.print("Enter coordinates (x y): ");
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;

            if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE) {
                System.out.println("Invalid coordinates. Try again.");
                continue;
            }

            if (visibleMap[x][y] != '.') {
                System.out.println("You already targeted this spot. Try a different coordinate.");
                continue;
            }

            bombs--;

            if (map[x][y] == 'S') {
                visibleMap[x][y] = 'X';
                map[x][y] = 'X';
                int shipId = shipMap[x][y];
                shipHealth[shipId]--;

                if (shipHealth[shipId] == 0) {
                    shipsRemaining--;
                    System.out.println("Destroyed!");
                } else {
                    System.out.println("Damaged!");
                }
            } else {
                visibleMap[x][y] = 'O';
                System.out.println("Not damaged.");
            }
        }

        if (shipsRemaining == 0) {
            System.out.println("Win! All ships destroyed!");
        } else {
            System.out.println("Defeat! You ran out of bombs.");
        }

        scanner.close();
    }

    private static void printVisibleMap() {
        System.out.println("\nCurrent Map:");

        System.out.print("   ");
        for (int j = 0; j < MAP_SIZE; j++) {
            System.out.print(j + 1 + " ");
        }
        System.out.println();

        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print(i + 1 + " ");
            if (i < 10) System.out.print(" ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(visibleMap[i][j] + " ");
            }
            System.out.println();
        }

//        System.out.println("\nHidden Map:");
//        for (int i = 0; i < MAP_SIZE; i++) {
//            for (int j = 0; j < MAP_SIZE; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static void main(String[] args) {
        ShipBattleGame.initializeMap();
        ShipBattleGame.placeShips();
        ShipBattleGame.play();
    }
}

