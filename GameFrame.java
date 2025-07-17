import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Whac-a-Mole");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GameLogic gameLogic = new GameLogic();
        GamePanel gamePanel = new GamePanel(gameLogic);
        add(gamePanel);

        gameLogic.startGame();

        setVisible(true);

    }
}