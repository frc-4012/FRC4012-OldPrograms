/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  WPI_TalonSRX d1 = new WPI_TalonSRX(Robot.map.d1);
  WPI_TalonSRX d2 = new WPI_TalonSRX(Robot.map.d2);
  WPI_TalonSRX d3 = new WPI_TalonSRX(Robot.map.d3);
  WPI_TalonSRX d4 = new WPI_TalonSRX(Robot.map.d4);
  SpeedControllerGroup dL = new SpeedControllerGroup(d1, d2);
  SpeedControllerGroup dR = new SpeedControllerGroup(d3, d4);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setRaw(double leftVal, double rightVal){
    dL.set(leftVal);
    dR.set(rightVal);
  }
}
