<<<<<<< HEAD
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public DifferentialDrive myRobot;
  public Joystick stickL, stickR;
  public Victor d1, d2, d3, d4, spinner;
  public SpeedControllerGroup dL, dR;
  public Boolean gear = true;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    stickR = new Joystick(0);
    stickL = new Joystick(1);
    d1 = new Victor(0);
    d2 = new Victor(1);
    d3 = new Victor(2);
    d4 = new Victor(3);
    spinner = new Victor(9);
    
    dL = new SpeedControllerGroup(d1, d2);
    dR = new SpeedControllerGroup(d3, d4);
    myRobot = new DifferentialDrive(dL, dR);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    
  }

  /**
   * This autonomous (along with the chooser code above) shows how hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhstrings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   * CONNECT VIA USB
   */  
  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

  }

  /**
   * This function is called periodically during  ,operator control.
   */
  @Override
  public void teleopPeriodic() {
    myRobot.tankDrive(stickL.getY(), stickR.getY());
    if(stickR.getRawButton(2)){
      spinner.set(1);
    } else {
      spinner.set(0);
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    
  }
=======
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
    public DifferentialDrive myRobot;
    public PWMTalonSRX d1, d2, d3, d4, deathSpinner;
    public SpeedControllerGroup dL, dR;
    public XboxController myCont;

    public boolean isSpinnerOn;

    @Override
    public void robotInit(){

        d1 = new PWMTalonSRX(0);
        d2 = new PWMTalonSRX(1);
        d3 = new PWMTalonSRX(2);
        d4 = new PWMTalonSRX(3);
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



>>>>>>> 8b603dfb73137017c4d51146db64db2baef4b5ec
}
