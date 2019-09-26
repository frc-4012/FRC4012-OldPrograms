package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonS

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;


/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  RobotMap map = new RobotMap();
  public WPI_TalonSRX d1 = new WPI_TalonSRX(map.FRONT_LEFT);
  public WPI_TalonSRX d2 = new WPI_TalonSRX(map.FRONT_RIGHT);
  public WPI_TalonSRX d3 = new WPI_TalonSRX(map.BACK_LEFT);
  public WPI_TalonSRX d4 = new WPI_TalonSRX(map.BACK_RIGHT);

  public SpeedControllerGroup dL = new SpeedControllerGroup(d1, d2);
  public SpeedControllerGroup dR = new SpeedControllerGroup(d3, d4);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new TankDrive());
  }

  public void setRaw(double leftval, double rightval){
    dL.set(leftval);
    dR.set(rightval);
  }
}
