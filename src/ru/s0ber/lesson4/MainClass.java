package ru.s0ber.lesson4;

import java.util.Random;
import java.util.Scanner;

public class MainClass {
    static final char EMPTY_CELL = '*';
    static final int MAP_SIZE = 5;
    static final int DOTS_TO_WIN = 4;
    static final char HUMAN_DOT = 'X';
    static final char AI_DOT = 'O';

    static char[][] map;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("Победа!");
                break;
            }
            if (isMapFull()){
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            System.out.println("Computer сделал свой ход");
            printMap();
            if (checkWin(AI_DOT)) {
                System.out.println("Поражение!");
            }
            if (isMapFull()){
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Игра окончена");
    }

    public static boolean checkWin(char dot) {
        if (MAP_SIZE > DOTS_TO_WIN) {
            for (int i = 0; i <= MAP_SIZE - DOTS_TO_WIN ; i++) {
                for (int j = 0; j < MAP_SIZE; j++) {
                    if (checkLine(j, i, 0, 1, DOTS_TO_WIN, dot)) {
                        return true;
                    }
                    if (checkLine(i, j, 1, 0, DOTS_TO_WIN, dot)) {
                        return true;
                    }
                }

                if (checkLine(i,i,1,1, DOTS_TO_WIN, dot)){
                    return true;
                }

                if (checkLine(i,MAP_SIZE - (1 + i),1,-1, DOTS_TO_WIN, dot)){
                    return true;
                }

            }
        } else {
            for (int i = 0; i < MAP_SIZE; i++) {
                if (checkLine(i, 0, 0, 1, DOTS_TO_WIN, dot)) {
                    return true;
                }
                if (checkLine(0, i, 1, 0, DOTS_TO_WIN, dot)) {
                    return true;
                }
            }

            if (checkLine(0,0,1,1, DOTS_TO_WIN, dot)){
                return true;
            }
            if (checkLine(0,MAP_SIZE - 1,1,-1, DOTS_TO_WIN, dot)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkLine(int cx, int cy, int vx, int vy, int l, char c) {
        for (int i = 0; i < l; i++) {
            if (map[cy + i * vy][cx + i * vx] != c){
                return false;
            }
        }
        return true;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x = -1, y = -1;

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == EMPTY_CELL) {
                    map[i][j] = AI_DOT;
                    if (checkWin(AI_DOT)){
                        x = j;
                        y = i;
                    }
                    map[i][j] = EMPTY_CELL;
                    break;
                }
            }
        }

        if (x == -1 && y == -1) {
            for (int i = 0; i < MAP_SIZE; i++) {
                for (int j = 0; j < MAP_SIZE; j++) {
                    if (map[i][j] == EMPTY_CELL) {
                        map[i][j] = HUMAN_DOT;
                        if (checkWin(HUMAN_DOT)){
                            x = j;
                            y = i;
                        }
                        map[i][j] = EMPTY_CELL;
                        break;
                    }
                }
            }
        }

        if (x == -1 && y == -1) {
            do {
                x = random.nextInt(MAP_SIZE);
                y = random.nextInt(MAP_SIZE);
            } while(!isCellValid(x, y));
        }

        map[y][x] = AI_DOT;
    }

    public  static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE) {
            return false;
        }
        if (map[y][x] == EMPTY_CELL) {
            return true;
        } else {
            return false;
        }
    }

    public static void humanTurn() {
        int x, y;

        do {
            System.out.println("Ваш ход! Введите коорзинаты клетки x y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[y][x] = HUMAN_DOT;

    }

    public static void printMap(){
        System.out.print("  ");
        for (int i = 1; i <= MAP_SIZE; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initMap(){
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY_CELL;
            }
        }
    }
}
