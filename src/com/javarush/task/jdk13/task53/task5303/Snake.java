package com.javarush.task.jdk13.task53.task5303;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();
    public int x;
    public int y;
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public void setDirection(Direction direction) {
        if (direction == Direction.UP && this.direction == Direction.DOWN) {
            return;
        } else if (direction == Direction.LEFT && this.direction == Direction.RIGHT) {
            return;
        } else if (direction == Direction.RIGHT && this.direction == Direction.LEFT) {
            return;
        } else if (direction == Direction.DOWN && this.direction == Direction.UP) {
            return;
        }
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        snakeParts.add(new GameObject(x,y));
        snakeParts.add(new GameObject(x+1,y));
        snakeParts.add(new GameObject(x+2,y));
    }

    public void draw(Game game) {
        Color color = isAlive ? Color.BLACK : Color.RED;
        game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, color, 75);
        for (int i = 1; i < snakeParts.size(); i++) {
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, color, 75);
        }
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();
        if (checkCollision(newHead)) {
            isAlive = false;
        } else if (    newHead.x > SnakeGame.HEIGHT - 1 ||
                newHead.x > SnakeGame.WIDTH - 1 ||
                newHead.y > SnakeGame.HEIGHT - 1 ||
                newHead.y > SnakeGame.WIDTH - 1 ||
                newHead.x < 0 ||
                newHead.x < 0 ||
                newHead.y < 0 ||
                newHead.y < 0) {
            isAlive = false;
        } else if (apple.x == newHead.x && apple.y == newHead.y) {
            apple.isAlive = false;
            snakeParts.add(0, newHead);
        } else {
            snakeParts.add(0, newHead);
            removeTail();
        }
    }

    public GameObject createNewHead() {
        GameObject gameObject = switch (direction) {
            case UP     -> new GameObject(snakeParts.get(0).x, snakeParts.get(0).y - 1);
            case DOWN   -> new GameObject(snakeParts.get(0).x, snakeParts.get(0).y + 1);
            case LEFT   -> new GameObject(snakeParts.get(0).x - 1, snakeParts.get(0).y);
            case RIGHT  -> new GameObject(snakeParts.get(0).x + 1, snakeParts.get(0).y);
        };
        return gameObject;
    }
    public void removeTail() {
        snakeParts.remove(snakeParts.size()-1);
    }

    public boolean checkCollision(GameObject gameObject) {
        for (int i = 0; i < snakeParts.size(); i++) {
            if (gameObject.x == snakeParts.get(i).x && gameObject.y == snakeParts.get(i).y) {
                return true;
            }
        }
        return false;
    }
}