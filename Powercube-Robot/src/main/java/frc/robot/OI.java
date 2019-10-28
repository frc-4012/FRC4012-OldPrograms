/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

import frc.robot.commands.LockPanel;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
public class OI {
  Joystick stickL = new Joystick(0);
  Joystick stickR = new Joystick(1);
  Button armButton = new JoystickButton(stickR, 2);


  public OI(){
    armButton.whileHeld(new LockPanel());
  }

  public double getL(){
    return stickL.getY();
  }

  public double getR(){
    return stickR.getY();
  }
}
