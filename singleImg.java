package ImagePractise;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class singleImg {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Image Click Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 900);
        frame.setLocationRelativeTo(null);

        // Load the image
        ImageIcon moleIcon = new ImageIcon("mole.png"); // Adjust path if needed
        BufferedImage moleImage = new BufferedImage(moleIcon.getIconWidth(), moleIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = moleImage.createGraphics();
        g2.drawImage(moleIcon.getImage(), 0, 0, null);
        g2.dispose();

        // Create a JLabel to display the image
        JLabel imageLabel = new JLabel(moleIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        // Add MouseListener to detect clicks on the image
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                int x = point.x;
                int y = point.y;
                int iconX = (imageLabel.getWidth() - moleImage.getWidth()) / 2;
                int iconY = (imageLabel.getHeight() - moleImage.getHeight()) / 2;
                int imgX = x - iconX;
                int imgY = y - iconY;

                if (imgX >= 0 && imgX < moleImage.getWidth() && imgY >= 0 && imgY < moleImage.getHeight()) {
                    int pixel = moleImage.getRGB(imgX, imgY);
                    int alpha = (pixel >> 24) & 0xff;
                    if (alpha > 0) {
                        JOptionPane.showMessageDialog(frame, "Clicked!");
                    }
                }
            }
        });

        // Add the label to the frame
        frame.add(imageLabel);
        frame.setVisible(true);
    }
}