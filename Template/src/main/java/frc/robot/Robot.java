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

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Piston;
import edu.wpi.first.wpilibj.Compressor;

public class Robot extends TimedRobot {
  public static DriveBase drive;
  public static Piston piston;
  public static Compressor comp;
  public static OI oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    drive = new DriveBase();
    piston = new Piston();
    comp  = new Compressor(0);
    oi = new OI();

    SmartDashboard.putData("Auto mode", m_chooser);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
