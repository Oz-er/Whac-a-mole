
import java.awt.*;
import java.util.Random;

public class Hole {
    private boolean isActive;
    private Color color;
    private String type;
    private Random random;

    public Hole() {
        isActive = false;
        color = Color.GRAY;
        type = "NONE";
        random = new Random();
    }

    public void activate() {
        isActive = true;
        // Randomly choose green (50%), red (25%), or brown (25%)
        double rand = random.nextDouble();
        if (rand < 0.5) {
            color = Color.GREEN;
            type = "GREEN";
        } else if (rand < 0.75) {
            color = Color.RED;
            type = "RED";
        } else {
            color = new Color(139, 69, 19); // Brown
            type = "BROWN";
        }
    }

    public void deactivate() {
        isActive = false;
        color = Color.GRAY;
        type = "NONE";
    }

    public boolean isActive() {
        return isActive;
    }

    public Color getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
}