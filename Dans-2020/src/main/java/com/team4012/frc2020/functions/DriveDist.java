package com.team4012.frc2020.functions;

import edu.wpi.first.wpilibj.Timer;
import com.team4012.frc2020.Robot;

public class DriveDist {
    double speed;
    Timer timer = new Timer();

    Robot robot = new Robot();

    public DriveDist(double speed){
        this.speed = speed;
    }

    public void forward(int distance){
        double time = distance / speed;
        robot.myRobot.tankDrive(1,1);
        Timer.delay(time);
        robot.myRobot.tankDrive(0,0);
    }

    public void reverse(int distance){
        double time = distance / speed;
        robot.myRobot.tankDrive(-1, -1);
        Timer.delay(time);
        robot.myRobot.tankDrive(0,0);
    }
}