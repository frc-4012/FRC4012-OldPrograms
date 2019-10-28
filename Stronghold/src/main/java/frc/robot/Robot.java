/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.cscore.UsbCamera;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {
  public Joystick stickL, stickR, shooterStick;
  public WPI_TalonSRX d1, d2, d3, d4, shooter, shovel;
  public DifferentialDrive myRobot;
  public SpeedControllerGroup dL, dR;
  public UsbCamera cam1;

  public boolean tFlipShoot;
  public boolean gear;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    d1 = new WPI_TalonSRX(1);
    d2 = new WPI_TalonSRX(2);
    d3 = new WPI_TalonSRX(3);
    d4 = new WPI_TalonSRX(4);

    shooter = new WPI_TalonSRX(6);
    shovel = new WPI_TalonSRX(5);

    stickL = new Joystick(0);
    stickR = new Joystick(1);
    shooterStick = new Joystick(2);

    

    dL = new SpeedControllerGroup(d1, d2);
    dR = new SpeedControllerGroup(d3, d4);
    myRobot = new DifferentialDrive(dL, dR);
    cam1 = CameraServer.getInstance().startAutomaticCapture(0);
    myRobot.setSafetyEnabled(false);
    shooter.setSafetyEnabled(false);
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
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
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
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    myRobot.tankDrive(-stickL.getY(), -stickR.getY());
    shovel();
  }

  public void shooter(){
    if(stickR.getRawButton(2) && !tFlipShoot) {
      shooter.set(-1);
      tFlipShoot = true;
    } else if(stickR.getRawButton(2) && tFlipShoot) {
      shooter.set(0);
      tFlipShoot = false;
    }
  }
  
  public void shovel(){
    if(stickR.getRawButton(5)){
      shovel.set(-1);
      Timer.delay(0.3);
      shovel.set(0);
    } else if(stickR.getRawButton(3)){
      shovel.set(1);
      Timer.delay(0.3);
      shovel.set(0);
    } else {
      shovel.set(0);
    }

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
