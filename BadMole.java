package Model;

public class BadMole extends Mole {

    public BadMole(int point, int visibleTime) {
        super(point, visibleTime);
        badMole = new ImageIcon("BadMole.png");
    }

    public int getPoint() {
        return point;
    }
}
