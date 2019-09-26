/*-------------------------------------------------------------------------------*/
/*                                                                               */
/*                                                                               */
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

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;

public class Piston extends Subsystem {
  DoubleSolenoid sol = new DoubleSolenoid(0, 1);
  Compressor comp = new Compressor(0);

  public Piston() {
    sol.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void initDefaultCommand() {

  }

  public void off(){
    sol.set(DoubleSolenoid.Value.kOff);
  }

  public void extend(){
    sol.set(DoubleSolenoid.Value.kForward);
  }

  public void retract(){
    sol.set(DoubleSolenoid.Value.kReverse);
  }

  public void compressorOn(){
    comp.setClosedLoopControl(true);
    comp.start();
  }
}
