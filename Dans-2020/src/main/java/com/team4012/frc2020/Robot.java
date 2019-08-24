/**
 * 4012 Repo for the 2020 season
 * 
 * I use aspects of command based as well as what we are used to, some you may not
 * understand, anything you would like to me explain, ask me.
 * 
 * ++Pin Layout++
 * Drive- Can Bus 1-4 P.S. Config in phoenix tuner
 * 
 * Encoder1- DIO 0 and 1
 * Encoder2- DIO 2 and 3
 */

package com.team4012.frc2020;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Encoder;

import com.team4012.frc2020.Config;
import com.team4012.frc2020.functions.DriveDist;
import com.team4012.frc2020.functions.EncoderOut;

import com.team4012.frc2020.commands.KillSwitch;


public class Robot extends TimedRobot {
    //Initial Call of Robot
    public static DifferentialDrive myRobot;

    //Motor Controllers
    public static WPI_TalonSRX d1, d2, d3, d4;
    public static SpeedControllerGroup dL, dR;
    //Inputs   
    public static Joystick stickL, stickR;
    public static JoystickButton killButton;

    //Sensors
    public Encoder encoderL, encoderR;

    //Commands
    public DriveDist driveDist;
    public EncoderOut encoderOut;

    //Val
    private double JOY_DEADZONE = 0.3;
    public double robotSpeedL, robotSpeedR, avgSpeed;

    @Override
    //Initialization Class, constructor
    public void robotInit(){
        //Motor Controllers
        d1 = new WPI_TalonSRX(Config.FRONT_LEFT.val);
        d2 = new WPI_TalonSRX(Config.FRONT_RIGHT.val);
        d3 = new WPI_TalonSRX(Config.BACK_LEFT.val);
        d4 = new WPI_TalonSRX(Config.BACK_RIGHT.val);

        dL = new SpeedControllerGroup(d1, d2);
        dR = new SpeedControllerGroup(d3, d4);

        //Inputs
        stickL = new Joystick(Config.LEFT_JOY.val);
        stickR = new Joystick(Config.RIGHT_JOY.val);

        //Button Commands
        killButton = new JoystickButton(stickR, 0);

        //Sensors
        encoderR = new Encoder(0, 1);
        encoderR = new Encoder(2, 3);

        encoderOut = new EncoderOut(6);
        robotSpeedL = encoderOut.getSpeedL();
        robotSpeedR = encoderOut.getSpeedR();
        avgSpeed = (robotSpeedL + robotSpeedR) / 2;

        myRobot = new DifferentialDrive(dL, dR);
        
    }

    @Override
    //Where autonomous code goes
    public void autonomousInit(){

    }

    @Override
    //DO NOT FLOOD WITH CODE!!
    public void teleopPeriodic(){
        myRobot.tankDrive(getLeftJoyY(), getRightJoyY());
        functions();
    }

    public void functions(){
        //Call all functions in here
        commands();
    }

    public void commands(){
        killButton.toggleWhenPressed(new KillSwitch());
    }

    public double getLeftJoyY(){
        double raw = stickL.getY();
        //Dont ask... Deadzone check
        return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
    }

    public double getRightJoyY(){
        double raw = stickR.getY();
        //Dont ask... Deadzone checker
        return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
    }

}