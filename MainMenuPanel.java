package View;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    Image background;
    public MainMenuPanel() {
         background = new ImageIcon("D:/WhacAMole/src/View/MenuPanel.png").getImage();
         setLayout(null);

        JButton startButton = new JButton("Start Game");
        startButton.setBackground(new Color(150,75,0));
        startButton.setSize(150,30);
        startButton.setLocation(100,200);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        startButton.setFocusable(false);
        startButton.setVisible(true);
        add(startButton);

        JButton musicButton = new JButton("Music");
        musicButton.setBackground(new Color(150,75,0));
        musicButton.setSize(150,30);
        musicButton.setLocation(100,240);
        musicButton.setFocusable(false);
        musicButton.setVisible(true);
        add(musicButton);

        JButton aboutButton = new JButton("About");
        aboutButton.setBackground(new Color(150,75,0));
        aboutButton.setSize(150,30);
        aboutButton.setLocation(100,280);
        aboutButton.setFocusable(false);
        aboutButton.setVisible(true);
        add(aboutButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(new Color(150,75,0));
        exitButton.setSize(150,30);
        exitButton.setLocation(100,320);
        exitButton.setFocusable(false);
        exitButton.setVisible(true);
        add(exitButton);
        }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
}

