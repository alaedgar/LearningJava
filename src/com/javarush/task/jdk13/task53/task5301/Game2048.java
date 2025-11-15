package com.javarush.task.jdk13.task53.task5301;

import com.javarush.engine.cell.*;

import java.security.cert.Certificate;
import java.util.Arrays;

public class Game2048 extends Game {

    private static final int SIDE = 4;
    private static final int MAX_NUMBER = 2048;
    private boolean isGameStopped = false;
    private int [][] gameField = new int[SIDE][SIDE];
    private int score = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
        setTurnTimer(5);
    }

    private void createGame() {
        gameField = new int [SIDE][SIDE];
        score = 0;
        setScore(score);
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                setCellColoredNumber(j, i, gameField[i][j]);
            }
        }
    }

    private int getMaxTileValue() {
        int max = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] > max) {
                    max = gameField[i][j];
                }
            }
        }
        return max;
    }

    private boolean canUserMove() {

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] == 0) {
                    return true;
                }
            }
        }

        for (int i = 0; i < SIDE; i++) {
            for (int j = 1; j < SIDE; j++) {
                if (gameField[i][j-1] == gameField[i][j]) {
                    return true;
                }
            }
        }

        for (int j = 0; j < SIDE; j++) {
            for (int i = 1; i < SIDE; i++) {
                if (gameField[i-1][j] == gameField[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.GOLD, "Game Over!", Color.BLACK, 20);
    }
    private void createNewNumber() {

        if (getMaxTileValue() == MAX_NUMBER) {
            win();
            return;
        }

        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);

        while (true) {
            if (gameField[x][y] == 0) {
                break;
            }
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }

        int randomNumber = getRandomNumber(10);
        if (randomNumber == 9) {
            gameField[x][y] = 4;
        } else {
            gameField[x][y] = 2;
        }
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color color = getColorByValue(value);
        String str = value > 0 ? "" + value : "";
        setCellValueEx(x, y, color, str);

    }

    private Color getColorByValue(int value) {
        if (value == 0) {
            return Color.GOLD;
        } else if (value == 2) {
            return Color.BLUE;
        } else if (value == 4) {
            return Color.DARKSEAGREEN;
        } else if (value == 8) {
            return Color.AQUA;
        } else if (value == 16) {
            return Color.ALICEBLUE;
        } else if (value == 32) {
            return Color.BEIGE;
        } else if (value == 64) {
            return Color.BISQUE;
        } else if (value == 128) {
            return Color.BLANCHEDALMOND;
        } else if (value == 256) {
            return Color.BLUEVIOLET;
        } else if (value == 512) {
            return Color.YELLOW;
        } else if (value == 1024) {
            return Color.WHITE;
        } else if (value == 2048) {
            return Color.TOMATO;
        } else {
            return Color.GOLD;
        }
    }

    private boolean compressRow(int[] row) {
        int [] temp = new int [row.length];
        int j = 0;
        boolean isMoved = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                temp[j] = row[i];
                j++;
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i] != temp[i]) {
                isMoved = true;
                break;
            }
        }

        if (isMoved) {
            for (int i = 0; i < row.length; i++) {
                row[i] = temp[i];
            }
        }

        return isMoved;
    }

    private boolean mergeRow(int[] row) {
        boolean isMerged = false;
        for (int i = 1; i < row.length; i++) {
            if ((row[i-1] == row[i]) && (row[i-1] != 0)) {
                row[i-1] *= 2;
                score += row[i-1];
                setScore( score);
                row[i] = 0;
                isMerged = true;
            }
        }

        return isMerged;
    }

    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                createGame();
                drawScene();
            } else {
                return;
            }
        }

        if (!canUserMove()) {
            gameOver();
            return;
        }

        if (key == Key.LEFT) {
            moveLeft();
        } else if (key == Key.RIGHT) {
            moveRight();
        } else if (key == Key.UP) {
            moveUp();
        } else if (key == Key.DOWN) {
            moveDown();
        } else {
            return;
        }
        drawScene();
    }

    private void moveLeft() {
        boolean isMovedOrIsMerged = false;
        for (int i = 0; i < gameField.length; i++) {
            if (compressRow(gameField[i]) | mergeRow(gameField[i]) ) {
                compressRow(gameField[i]);
                isMovedOrIsMerged = true;
            }
        }
        if (isMovedOrIsMerged) {
            createNewNumber();
        }
    }

    private void win() {
        showMessageDialog(Color.GOLD, "You Win !", Color.BLACK, 20);
        isGameStopped = true;
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }
    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }
    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int temp[][] = new int[SIDE][SIDE];
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                temp[i][j] = gameField[SIDE-j-1][i];
            }
        }
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                gameField[i][j] = temp[i][j];
            }
        }
    }
}
