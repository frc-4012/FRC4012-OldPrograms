package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
    public DifferentialDrive myRobot;
    public WPI_TalonSRX d1, d2, d3, d4, deathSpinner;
    public SpeedControllerGroup dL, dR;
    public XboxController myCont;

    public boolean isSpinnerOn;

    @Override
    public void robotInit(){

        d1 = new WPI_TalonSRX(0);
        d2 = new WPI_TalonSRX(1);
        d3 = new WPI_TalonSRX(2);
        d4 = new WPI_TalonSRX(3);
        dL = new SpeedControllerGroup(d1, d2);
        dR = new SpeedControllerGroup(d3, d4);
        deathSpinner = new WPI_TalonSRX(4);
        
        myRobot = new DifferentialDrive(dL, dR);
        myCont = new XboxController(0);
    }

    @Override
    public void teleopPeriodic(){
        myRobot.arcadeDrive(myCont.getTriggerAxis(Hand.kRight), myCont.getX(Hand.kLeft));
        spinnyThing();
    }

    public void spinnyThing(){
        if(myCont.getAButton() && !isSpinnerOn){
            deathSpinner.set(1);
        } else if(myCont.getAButton() && isSpinnerOn){
            deathSpinner.set(0);
        }
    }
}