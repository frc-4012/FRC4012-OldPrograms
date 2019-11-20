package frc.robot.subsystems;

public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSPX m_intakeLeft = new WPI_VictorSPX

  public DriveTrain(){
    super("Elevator");
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }  
}
