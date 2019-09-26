package frc.robot.commands;

import edu.wpi.first.wpilib.Command;
import frc.robot.Robot; 

public class PistRetract extends Command {
  public PistRetract(){
    requires(Robot.piston);
  }
  
  @Override
  protected void execute(){
    Robot.piston.rectract();
  }
  
  protected void end(){
    end();
  }
}
