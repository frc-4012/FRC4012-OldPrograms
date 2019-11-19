/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Constants;
import frc.robot.commands.TankDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands
  public static WPI_TalonSRX driveLeftMaster = new WPI_TalonSRX(Constants.LEFT_FRONT_TALON);
  public static WPI_TalonSRX driveLeftSlave = new WPI_TalonSRX(Constants.LEFT_BACK_TALON);
  public static WPI_TalonSRX driveRightMaster = new WPI_TalonSRX(Constants.RIGHT_FRONT_TALON);
  public static WPI_TalonSRX driveRightSlave = new WPI_TalonSRX(Constants.RIGHT_BACK_TALON);
  
  public DriveTrain(){
    driveLeftSlave.follow(driveLeftMaster);
    driveRightSlave.follow(driveRightMaster);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand()););
    setDefaultCommand(new TankDrive());
  }

  public void setRaw(double leftval, double rightval){
    driveLeftMaster.set(leftval);
    driveRightMaster.set(rightVal);
  }
}
