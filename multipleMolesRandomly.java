package ImagePractise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class multipleMolesRandomly {
    static final int CELL_SIZE = 150;
    static final int GRID_SIZE = 3;
    static final int TOTAL_CELLS = GRID_SIZE * GRID_SIZE;

    static int score = 0;
    static JLabel scoreLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Whac A Mole");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // --------------------- TOP: SCORE PANEL ---------------------
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 30));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setOpaque(true);
        scoreLabel.setBackground(Color.LIGHT_GRAY);
        frame.add(scoreLabel, BorderLayout.NORTH);

        // --------------------- CENTER: GAME GRID ---------------------
        JPanel gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE, 5, 5));
        frame.add(gridPanel, BorderLayout.CENTER);

        // Load and scale mole image
        ImageIcon originalIcon = new ImageIcon("mole.png");
        if (originalIcon.getIconWidth() <= 0) {
            JOptionPane.showMessageDialog(null, "Image not found!");
            return;
        }
        Image scaledImg = originalIcon.getImage().getScaledInstance(CELL_SIZE, CELL_SIZE, Image.SCALE_SMOOTH);
        ImageIcon moleIcon = new ImageIcon(scaledImg);

        // BufferedImage for pixel-perfect click
        BufferedImage moleImage = new BufferedImage(CELL_SIZE, CELL_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = moleImage.createGraphics();
        g2.drawImage(scaledImg, 0, 0, null);
        g2.dispose();

        JLabel[] cells = new JLabel[TOTAL_CELLS];
        boolean[] moleVisible = new boolean[TOTAL_CELLS]; // Track visibility

        for (int i = 0; i < TOTAL_CELLS; i++) {
            JLabel label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));

            final int index = i;

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!moleVisible[index]) return;

                    Point point = e.getPoint();
                    int iconX = (label.getWidth() - moleImage.getWidth()) / 2;
                    int iconY = (label.getHeight() - moleImage.getHeight()) / 2;
                    int imgX = point.x - iconX;
                    int imgY = point.y - iconY;

                    if (imgX >= 0 && imgX < moleImage.getWidth() && imgY >= 0 && imgY < moleImage.getHeight()) {
                        int pixel = moleImage.getRGB(imgX, imgY);
                        int alpha = (pixel >> 24) & 0xff;
                        if (alpha > 0) {
                            score++;
                            scoreLabel.setText("Score: " + score);

                            //make it disappear after clicking
                            label.setIcon(null);
                            moleVisible[index] = false;

                        }
                    }
                }
            });

            cells[i] = label;
            gridPanel.add(label);
        }

        // Random mole appearance every second
        Timer timer = new Timer();
        Random rand = new Random();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    for (int i = 0; i < TOTAL_CELLS; i++) {
                        boolean show = rand.nextBoolean(); // random on/off
                        if (show) {
                            cells[i].setIcon(moleIcon);
                            moleVisible[i] = true;
                        } else {
                            cells[i].setIcon(null);
                            moleVisible[i] = false;
                        }
                    }
                });
            }
        }, 0, 500); // every 1 second

        frame.setVisible(true);
    }
}
