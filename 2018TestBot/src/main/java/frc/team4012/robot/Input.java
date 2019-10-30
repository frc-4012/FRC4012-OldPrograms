package frc.team4012.robot;

import frc.team4012.robot.Map;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;

public class Input {
    public Joystick stickL = new Joystick(Map.joyL);
    public Joystick stickR = new Joystick(Map.joyR);

    Button elevatorUpB = new JoystickButton(stickR, 5);
    Button elevatorDownB = new JoystickButton(stickR, 3);
    Button intakeB = new JoystickButton(stickR, 1);
    Button outakeB = new JoystickButton(stickR, 2);

    public double getLY(){
        return stickL.getY();
    }

    public double getRY(){
        return stickR.getY();
    }
}