package com.team4012.frc2020;

public enum Config {
    //Motor Mapping
    FRONT_LEFT(0),
    FRONT_RIGHT(1),
    BACK_LEFT(2),
    BACK_RIGHT(3),
    //Input Mapping
    LEFT_JOY(0),
    RIGHT_JOY(1),
    BUTTON_PANEL(3);

    public final int val;

    Config(int val){
        this.val = val;
    }
}