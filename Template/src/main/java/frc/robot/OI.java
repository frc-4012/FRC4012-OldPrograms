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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;

import frc.robot.commands.PistExtend;
import frc.robot.commands.PistRetract;
import frc.robot.commands.Comp;


public class OI {
  Joystick stickL = new Joystick(0);
    Button pistE = new JoystickButton(stickL, 4);
    Button pistR = new JoystickButton(stickL, 5);
    Button compB = new JoystickButton(stickL, 3);
  Joystick stickR = new Joystick(1);

  public OI() {
    pistE.whenPressed(new PistExtend());
    pistR.whenPressed(new PistRetract());
    compB.whenPressed(new Comp());
  }


  public double getLY(){
    return stickL.getY();
  }

  public double getRY(){
    return stickR.getY();
  }
}