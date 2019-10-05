package frc.robot.commands;

import edu.wpi.first.wpilib.Command;
import frc.robot.Robot; 

public class PistOff extends Command {
  public PistOff(){
    requires(Robot.piston);
  }
  
  @Override
  protected void execute(){
    Robot.piston.off();
  }
  
  protected void end(){
    end();
  }
}
