package frc.robot;

public class Constants {
    //Motor Controllers
    public static final int FRONT_LEFT = 0;
    public static final int FRONT_RIGHT = 1;
    public static final int BACK_LEFT = 2;
    public static final int BACK_RIGHT = 3;
    public static final int INTAKE_LEFT = 4;
    public static final int INTAKE_RIGHT = 5;
    
    //Inputs
    public static final int LEFT_JOY = 0;
    public static final int RIGHT_JOY = 1;
    
    //Sensors
    public static final int INTAKE_ULTRA1 = 0;
    public static final int INTAKE_ULTRA2 = 1;
    
    //Buttons
    public static final int INTAKE_BUTTON = 3;
    public static final int OUTAKE_BUTTON = 5;
    public static final int ELEVATOR_LIFT = 4;
    public static final int ELEVATOR_RETRACT = 6;

    //PIDS
    public static final double elevator_kP = 1;
    public static final double elevator_kI = 0.001;
    public static final double elevator_kD = 0;
}