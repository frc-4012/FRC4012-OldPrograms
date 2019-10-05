/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.TankDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX d1 = new WPI_TalonSRX(0);
  public WPI_TalonSRX d2 = new WPI_TalonSRX(3);
  public WPI_TalonSRX d3 = new WPI_TalonSRX(1);
  public WPI_TalonSRX d4 = new WPI_TalonSRX(2);
  public SpeedControllerGroup dL = new SpeedControllerGroup(d1, d2);
  public SpeedControllerGroup dR = new SpeedControllerGroup(d3, d4);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand()););
    setDefaultCommand(new TankDrive());
  }

  public void setRaw(double leftval, double rightval){
    dL.set(leftval);
    dR.set(rightval);
  }
}
