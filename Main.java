// src/Main.java
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameFrame(); // Create and show the game window
        });
    }
}
