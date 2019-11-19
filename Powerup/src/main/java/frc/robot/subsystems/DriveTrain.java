/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.TankDrive;

/**
 * Add your docs here.
 */
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX dFrontMaster = new WPI_TalonSRX(Constants.FRONT_LEFT);
  WPI_TalonSRX dFrontSlave = new WPI_TalonSRX(Constants.FRONT_RIGHT);
  WPI_TalonSRX dBackMaster = new WPI_TalonSRX(Constants.BACK_LEFT);
  WPI_TalonSRX dBackSlave = new WPI_TalonSRX(Constants.BACK_RIGHT);

  public DriveTrain(){
    dFrontSlave.follow(dFrontMaster);
    dBackSlave.follow(dBackMaster);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new TankDrive());
  }

  public void setRaw(double leftVal, double rightVal){
    dFrontMaster.set(leftVal);
    dBackMaster.set(rightVal);
  }
}
