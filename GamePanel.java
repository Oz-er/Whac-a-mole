

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private GameLogic gameLogic;
    private JButton[] buttons;
    private JLabel scoreLabel;
    private static final int HOLES = 9;

    public GamePanel(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        setLayout(new BorderLayout());

        // Score display
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(scoreLabel, BorderLayout.NORTH);

        // 3x3 button grid
        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        buttons = new JButton[HOLES];
        for (int i = 0; i < HOLES; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.GRAY);
            int holeIndex = i;
            buttons[i].addActionListener(e -> handleClick(holeIndex));
            buttonPanel.add(buttons[i]);
        }
        add(buttonPanel, BorderLayout.CENTER);

        // Timer to update button colors
        Timer updateTimer = new Timer(100, e -> updateButtons());
        updateTimer.start();
    }

    private void updateButtons() {
        Hole[] holes = gameLogic.getHoles();
        for (int i = 0; i < HOLES; i++) {
            buttons[i].setBackground(holes[i].getColor());
            buttons[i].setEnabled(!gameLogic.isGameOver());
        }
        scoreLabel.setText("Score: " + gameLogic.getScore());
        if (gameLogic.isGameOver()) {
            JOptionPane.showMessageDialog(this, "Game Over! Final Score: " + gameLogic.getScore());
            System.exit(0);
        }
    }

    private void handleClick(int holeIndex) {
        gameLogic.handleClick(holeIndex);
        updateButtons();
    }
}