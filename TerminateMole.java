package Model;

import javax.swing.*;

public class TerminateMole extends Mole {

    protected ImageIcon bombMole;
    public TerminateMole(int point, int visibleTime) {
        super(point, visibleTime);
        bombMole = new ImageIcon("bomb.png");
    }

    public int getPoint() {
        return point;
    }
}
