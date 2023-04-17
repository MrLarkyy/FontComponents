package xyz.larkyy.fontcomponents.fontcomponents.components;

public class HolderWidth {

    private int width = 0;

    public void add(int width) {
        this.width+=width;
    }

    public void take(int width) {
        this.width-=width;
    }

    public int getWidth() {
        return width;
    }
}
