package ru.s0ber.lesson8;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Game {
    public static final int SIZE = 3;
    public static final int CHIP_TO_WIN = 3;
    private Frame frame;
    private Map map;
    private boolean isFirstPlayerTurn;
    private Random random;

    public Game() {
        map = new Map(SIZE);
        map.init();
        isFirstPlayerTurn = true;
        random = new Random();
        frame = new Frame(map, this);
        map.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isFirstPlayerTurn) {
                    if (map.setCellValue(e.getX()/map.getCellSize(), e.getY()/map.getCellSize(), Map.PLAYER)) {
                        map.repaint();
                        isFirstPlayerTurn = false;
                    }
                }
            }
        });
    }

    public void setFirstPlayerTurn(boolean firstPlayerTurn) {
        isFirstPlayerTurn = firstPlayerTurn;
    }

    // старт игры
    public void start() {

        do {
            humanTurn();
            if (checkWin(Map.PLAYER)){
                //вывести окно о победе
                //System.out.println("WIN");
                frame.gameEndWindow("Вы победили!");
                //break;
            }
            if (checkDraw()){
                //вывести окно о ничьей
                //System.out.println("DRAW");
                frame.gameEndWindow("Ничья.");
                //break;
            }
            aiTurn();
            if (checkWin(Map.AI_PLAYER)){
                //вывести окно о победе
                //System.out.println("Вы проиграли");
                frame.gameEndWindow("Вы проиграли. Увы.");
                //break;
            }
            if (checkDraw()){
                //вывести окно о ничьей
                //System.out.println("DRAW");
                frame.gameEndWindow("Ничья.");
                //break;
            }
        } while (true);

    }

    // метод ход компьютера
    private synchronized void aiTurn() {
        if (!isFirstPlayerTurn) {

            int x = -1, y = -1;

            int[][] field = map.getField();

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (field[i][j] == Map.EMPTY_CELL) {
                        field[i][j] = Map.AI_PLAYER;
                        if (checkWin(Map.AI_PLAYER)){
                            x = i;
                            y = j;
                        }
                        field[i][j] = Map.EMPTY_CELL;
                        break;
                    }
                }
            }

            if (x == -1 && y == -1) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (field[i][j] == Map.EMPTY_CELL) {
                            field[i][j] = Map.PLAYER;
                            if (checkWin(Map.PLAYER)){
                                x = i;
                                y = j;
                            }
                            field[i][j] = Map.EMPTY_CELL;
                            break;
                        }
                    }
                }
            }

            if (x == -1 && y == -1) {
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                } while(!map.isCellValid(x, y));
            }

            field[x][y] = Map.AI_PLAYER;

            //System.out.println("ход компьютера");
            map.repaint();
            isFirstPlayerTurn = true;
        }
    }

    // метод ход человека
    private void humanTurn() {
        // заглушка
    }

    // проверка победы
    private boolean checkWin(int player) {
        if (SIZE > CHIP_TO_WIN) {
            for (int i = 0; i <= SIZE - CHIP_TO_WIN ; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map.checkLine(j, i, 0, 1, CHIP_TO_WIN, player)) {
                        return true;
                    }
                    if (map.checkLine(i, j, 1, 0, CHIP_TO_WIN, player)) {
                        return true;
                    }
                }

                if (map.checkLine(i,i,1,1, CHIP_TO_WIN, player)){
                    return true;
                }

                if (map.checkLine(i,SIZE - (1 + i),1,-1, CHIP_TO_WIN, player)){
                    return true;
                }

            }
        } else {
            for (int i = 0; i < SIZE; i++) {
                if (map.checkLine(i, 0, 0, 1, CHIP_TO_WIN, player)) {
                    return true;
                }
                if (map.checkLine(0, i, 1, 0, CHIP_TO_WIN, player)) {
                    return true;
                }
            }

            if (map.checkLine(0,0,1,1, CHIP_TO_WIN, player)){
                return true;
            }
            if (map.checkLine(0,SIZE - 1,1,-1, CHIP_TO_WIN, player)){
                return true;
            }
        }
        return false;
    }

    private boolean checkDraw() {
        int[][] field = map.getField();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
