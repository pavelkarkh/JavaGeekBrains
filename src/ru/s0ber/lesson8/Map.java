package ru.s0ber.lesson8;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int PLAYER = 1;
    public static final int AI_PLAYER = 2;
    public static final int EMPTY_CELL = 0;
    private final int PANEL_SIZE = 500;
    private int[][] field;
    private int dimension;
    private int cellSize;

    public int getCellSize() {
        return cellSize;
    }

    public int[][] getField() {
        return field;
    }

    public boolean setCellValue(int x, int y, int value) {
        if (isCellValid(x, y)) {
            this.field[x][y] = value;
            return true;
        } else {
            return false;
        }
    }

    public Map(int dimension) {
        this.dimension = dimension;
        this.cellSize = PANEL_SIZE / dimension;
        this.field = new int[dimension][dimension];
        setBackground(Color.white);
    }

    public void init() {
        field = new int[dimension][dimension];
        repaint();
    }

    public boolean isCellValid(int x, int y){
        if (x < 0 || y < 0 || x >= dimension || y >= dimension) {
            return false;
        } else {
            return field[x][y] == 0;
        }
    }

    public boolean checkLine(int x, int y, int vx, int vy, int chipToWin, int player) {
        for (int i = 0; i < chipToWin; i++) {
            if (field[x + i * vx][y + i * vy] != player){
                return false;
            }
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < dimension; i++) {
            g.drawLine(0, i*cellSize, PANEL_SIZE, i*cellSize);
            g.drawLine(i*cellSize, 0, i*cellSize, PANEL_SIZE);
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if(field[i][j]!=0){
                    if(field[i][j]==PLAYER){
                        g.setColor(Color.red);
                    }
                    if(field[i][j]==AI_PLAYER){
                        g.setColor(Color.blue);
                    }
                    g.fillOval(i*cellSize+3,j*cellSize+3,cellSize-6,cellSize-6);
                }
            }
        }

    }
}
