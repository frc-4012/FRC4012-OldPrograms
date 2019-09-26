/*-------------------------------------------------------------------------------*/
/*   44444   44444       0000000000         11111            222222222222222     */
/*   4:::4   4:::4      0::000000::0       1:::::1          2:::::::::::::::22   */
/*   4:::4   4:::4      0::0    0::0      1::::::1          2::::::222222:::::2  */
/*   4:::4   4:::4      0::0    0::0     1:::::::1          2222222     2:::::2  */
/*   4:::4   4:::4      0::0    0::0     111:::::1                      2:::::2  */
/*   4:::4   4:::4      0::0    0::0        1::::1                      2:::::2  */
/*   4:::4   4:::4      0::0    0::0        1::::1                      2:::::2  */
/*   4:::44444:::4      0::0    0::0        1::::1                  2222:::::2   */
/*   4:::::::::::4      0::0    0::0        1::::1             22222::::::22     */
/*   4:::::::::::4      0::0    0::0        1::::1           22::::::::222       */
/*   4:::::::::::4      0::0    0::0        1::::1          2:::::22222          */
/*   44444444::::4      0::0    0::0        1::::1         2:::::2               */
/*          4::::4      0::0    0::0        1::::1         2:::::2               */
/*          4::::4      0::0    0::0     111::::::111      2:::::2      222222   */
/*          4::::4      0::000000::0     1::::::::::1      2::::::2222222:::::2  */
/*          4::::4      0::::::::::0     1::::::::::1      2::::::::::::::::::2  */
/*          444444       0000000000      111111111111      22222222222222222222  */    
/*                                                                               */
/*                                                                             © */
/*-------------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.OI;

public class TankDrive extends Command {
  public TankDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drive.setRaw(Robot.oi.getLY(), Robot.oi.getRY());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
