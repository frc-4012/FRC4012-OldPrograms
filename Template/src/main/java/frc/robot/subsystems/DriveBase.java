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


package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import frc.robot.Ports;
import frc.robot.commands.TankDrive;

public class DriveBase extends Subsystem {
  WPI_TalonSRX d1 = new WPI_TalonSRX(Ports.FRONT_LEFT);
  WPI_TalonSRX d2 = new WPI_TalonSRX(Ports.FRONT_RIGHT);
  WPI_TalonSRX d3 = new WPI_TalonSRX(Ports.BACK_LEFT);
  WPI_TalonSRX d4 = new WPI_TalonSRX(Ports.BACK_RIGHT);

  SpeedControllerGroup dL = new SpeedControllerGroup(d1, d2);
  SpeedControllerGroup dR = new SpeedControllerGroup(d3, d4);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new TankDrive());
  }

  public void setRaw(double speedL, double speedR){
    dL.set(speedL);
    dR.set(speedR);
  }
}
