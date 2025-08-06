package View;

import javax.swing.*;
import java.awt.*;

public class AboutPanel extends JPanel {

    Image background;
    Image button;

    public AboutPanel(JPanel panel, CardLayout cardLayout) {

        background = new ImageIcon("C:/Users/asmon/Downloads/AboutPanelImage.png").getImage();
        button = new ImageIcon("D:/WhacAMole/src/View/button.png").getImage();
        setLayout(null);

        JLabel title = new JLabel();
        title.setBounds(250,100,300,100);
        title.setText("ABOUT US");
        title.setFont(new Font("Tahoma", Font.BOLD, 50));
        title.setOpaque(false);
        title.setVisible(true);
        add(title);

        JTextArea aboutOmer = new JTextArea();
        aboutOmer.setEditable(false);
        aboutOmer.setBackground(Color.WHITE);
        aboutOmer.setBounds(20,250,350,150);
        aboutOmer.setFont(new Font("Tahoma", Font.PLAIN, 25));
        aboutOmer.setText("""
                Name: Omer Labib
                Email: bsse1655@iit.du.ac.bd
                Worked as: Backend Developer
                Organization: IITDU-16
                """);
        aboutOmer.setOpaque(false);
        add(aboutOmer);


          JTextArea aboutMonika = new JTextArea();
          aboutMonika.setEditable(false);
          aboutMonika.setBackground(Color.WHITE);
          aboutMonika.setBounds(400,250,350,150);
          aboutMonika.setFont(new Font("Tahoma", Font.PLAIN, 25));
          aboutMonika.setText("""
                  Name: Asshifa Sultana
                  Email: bsse1632@iit.du.ac.bd
                  Worked as: Frontend Developer
                  Organization: IITDU-16
                  """);
          aboutMonika.setOpaque(false);
          add(aboutMonika);

        JButton back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD + Font.ITALIC, 15));
        back.setBackground(new Color(150,75,0));
        back.setForeground(Color.BLACK);
        back.setBounds(5,600,100,30);
        back.setOpaque(false);
        back.setFocusable(false);
        back.setBorderPainted(false);
        setVisible(true);
        back.addActionListener(e -> cardLayout.show(panel,"MainMenuPanel"));
        add(back);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(button,10,590,100,50,this);
    }
}
