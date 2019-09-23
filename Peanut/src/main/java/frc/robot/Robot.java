package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.PWMTalonSRX;

public class Robot extends TimedRobot {
    private PWMTalonSRX dL, dR;
    private XboxController cont;
    private DifferentialDrive myRobot;

    @Override
    public void robotInit(){
        dL = new PWMTalonSRX(0);
        dR = new PWMTalonSRX(1);
        cont = new XboxController(0);
        myRobot = new DifferentialDrive(dL, dR);
    }

    @Override 
    public void autonomousInit(){

    }

    @Override
    public void teleopPeriodic(){
        myRobot.arcadeDrive(-cont.getTriggerAxis(Hand.kRight), cont.getX(Hand.kLeft));
    }
}