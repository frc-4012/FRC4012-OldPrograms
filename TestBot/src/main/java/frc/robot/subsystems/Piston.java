package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;
import edu.wpi.first.wpilibj.Compressor;

/**
 * Add your docs here.
 */
public class Piston extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public DoubleSolenoid sol1 = new DoubleSolenoid(0,1);
  public Compressor comp = new Compressor(0);
  
  public Piston(){
    sol1.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  public void turnOff(){
    sol1.set(DoubleSolenoid.Value.kOff);
  }
  
  public void extend(){
    sol1.set(DoubleSolenoid.Value.kForward);
  }
  
  public void retract(){
    sol1.set(DoubleSolenoid.Value.kReverse);
  }

  public void compOn(){
    comp.start();
  }
}