package com.unisys.model;

public class FairyLight{

    private Color color;
    private boolean on;
    private int number;

    public FairyLight(Color color, boolean on, int number) {
        this.color = color;
        this.on = on;
        this.number = number;
    }

    public void setOn(boolean on) {
        this.on = on;
        System.out.println(this);
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {

        return "Light "+
                number+" "+
                color.toString()+" "+
                (on ? "on":"off");
    }
}
