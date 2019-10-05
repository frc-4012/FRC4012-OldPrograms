/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.RobotDrive;
import frc.robot.commands.MeccanumDrive;

/**
 * Add your docs here.
 */
public class DriveBase extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_TalonSRX d1 = new WPI_TalonSRX(0);
  private WPI_TalonSRX d2 = new WPI_TalonSRX(1);
  private WPI_TalonSRX d3 = new WPI_TalonSRX(2);
  private WPI_TalonSRX d4 = new WPI_TalonSRX(3);
  private SpeedControllerGroup dL = new SpeedControllerGroup(d1, d2);
  private SpeedControllerGroup dR = new SpeedControllerGroup(d3, d4);
  private RobotDrive myRobot = new RobotDrive(d1, d2, d3, d4);
  private DifferentialDrive robot = new DifferentialDrive(dL, dR);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new MeccanumDrive());
  }

  public void setRaw(double x, double y, double z){
    myRobot.mecanumDrive_Polar(x, y, z);
  }
}
