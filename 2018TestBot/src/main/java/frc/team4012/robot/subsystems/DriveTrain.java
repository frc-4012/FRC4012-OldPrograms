/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4012.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import frc.team4012.robot.Map;

public class DriveTrain extends Subsystem {

  WPI_TalonSRX d1 = new WPI_TalonSRX(Map.d1);
  WPI_TalonSRX d2 = new WPI_TalonSRX(Map.d2);
  WPI_TalonSRX d3 = new WPI_TalonSRX(Map.d3);
  WPI_TalonSRX d4 = new WPI_TalonSRX(Map.d4);
  SpeedControllerGroup dL = new SpeedControllerGroup(d1, d2);
  SpeedControllerGroup dR = new SpeedControllerGroup(d3, d4);

  @Override

  public void initDefaultCommand() {

  }

  public void setRaw(double leftval, double rightval){
    dL.set(leftval);
    dR.set(rightval);
  }
}
