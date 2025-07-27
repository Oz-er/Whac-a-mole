package View;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Whac-A-Mole");
        ImageIcon image = new ImageIcon("D:/WhacAMole/src/View/MenuPanel.png");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);

        CardLayout cardLayout = new CardLayout();
        JPanel panel = new JPanel(cardLayout);
        panel.add(new MainMenuPanel(panel,cardLayout),"MainMenuPanel");
        panel.add(new MusicSettingPanel(panel, cardLayout),"MusicSettingPanel");
        frame.add(panel);

        frame.setContentPane(panel);


        frame.setVisible(true);
    }
}
