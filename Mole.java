package Model;

public abstract class Mole {

    protected boolean isVisible;
    protected int point;
    protected int visibleTime;

    public Mole(int point, int visibleTime){
        this.point = point;
        this.visibleTime = visibleTime;
        this.isVisible = false;
    }

    public void showMole(){
        this.isVisible = true;
    }

    public boolean isVisible(){
        return this.isVisible;
    }

    public void hideMole(){
        this.isVisible = false;
    }

    abstract int getPoint();
    
}
