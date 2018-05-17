package com.unisys.model;

import com.unisys.controller.FairyLightImplementor;

public class FairyLight {

    private Color color;
    private boolean on;
    private int number;

    public FairyLight(Color color, boolean on, int number) {
        this.color = color;
        this.on = on;
        this.number = number;
    }

    @Override
    public String toString() {

        return "Light "+
                number+" "+
                color.toString()+" "+
                (on ? "on":"off");
    }
}
