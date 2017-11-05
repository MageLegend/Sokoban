package be.kdg.sokoban.model;

/**
 * Created by Massi on 12/03/2017.
 */
public abstract class FieldObject {
    protected int x;
    protected int y;

    public FieldObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
