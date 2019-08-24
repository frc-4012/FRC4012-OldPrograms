package com.team4012.frc2020.functions;

import com.team4012.frc2020.Robot;

public class EncoderOut {
    double diameter;

    Robot robot = new Robot();

    public EncoderOut(double diameter){
        this.diameter = diameter / 12;
    }

    public double getSpeedL(){
        double rpmL = robot.encoderL.getRate();
        double constantL = rpmL * 3.14;
        double speedL = constantL * diameter;
        double speedLOut = speedL * 60;
        return speedLOut;
    }

    public double getSpeedR(){
        double rpmR = robot.encoderR.getRate();
        double constantR = rpmR * 3.14;
        double speedR = constantR * diameter;
        double speedROut = speedR * 60;
        return speedROut;
    }
}