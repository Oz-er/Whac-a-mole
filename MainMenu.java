package View;

import javax.swing.*;

public class MainMenu {
    public MainMenu() {
        JFrame frame = new JFrame("Whac-A-Mole");
        ImageIcon image = new ImageIcon("D:/WhacAMole/src/View/MenuPanel.png");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setContentPane(new MainMenuPanel());
        frame.setResizable(false);

        frame.setVisible(true);
    }
}
