package frc.robot.commands;

import edu.wpi.first.wpilib.Command;
import frc.robot.Robot; 

public class PistExtend extends Command {
  public PistExtend(){
    requires(Robot.piston);
  }
  
  @Override
  protected void execute(){
    Robot.piston.extend();
  }
  
  protected void end(){
    end();
  }
}
