
import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.BLACK;



public class GameLogic {
    private int score;
    private boolean gameOver;
    private Hole[] holes;
    private static final int HOLES = 9;
    private Random random;

    public GameLogic() {
        score = 0;
        gameOver = false;
        holes = new Hole[HOLES];
        for (int i = 0; i < HOLES; i++) {
            holes[i] = new Hole();
        }
        random = new Random();
    }

    public void startGame() {
        Timer gameTimer = new Timer(750, e -> updateGame());
        gameTimer.start();
    }

    private void updateGame() {
        if (gameOver) return;
        // Randomly activate up to 3 holes simultaneously
        for (Hole hole : holes) {
            if (random.nextDouble() < 0.3) { // 30% chance per hole
                hole.activate();
            } else {
                hole.deactivate();
            }
        }
    }

    public void handleClick(int holeIndex) {
        if (gameOver) return;
        Hole hole = holes[holeIndex];
        if (hole.isActive()) {
            switch (hole.getType()) {
                case "GREEN":
                    score += 10;
                    hole.deactivate();
                    break;
                case "RED":
                    gameOver = true;
                    break;
                case "BROWN":
                    score -= 5;
                    hole.deactivate();
                    break;
            }
        }
    }

    public Hole[] getHoles() {
        return holes;
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}