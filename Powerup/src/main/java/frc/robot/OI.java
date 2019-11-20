/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    public Joystick stickL = new Joystick(Constants.LEFT_JOY);
    public Joystick stickR = new Joystick(Constants.RIGHT_JOY);
    
    public static void init(){
        JoystickButton intake = new JoystickButton(stickR, Constants.INTAKE_BUTTON);
        JoystickButton outake = new JoystickButton(stickR, Constants.OUTAKE_BUTTON);
                                         
                      
    }

    public double getL(){
        return stickL.getY();
    }
    public double getR(){
        return stickR.getY();
    }
}
