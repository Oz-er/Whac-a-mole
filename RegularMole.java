package Model;

import javax.swing.*;

public class RegularMole extends Mole{

    protected ImageIcon moleIcon;

    public RegularMole(int point, int visibleTime) {
        super(point, visibleTime);
        moleIcon = new ImageIcon("mole.png");
    }

    public int getPoint(){
        return point;
    }
}
