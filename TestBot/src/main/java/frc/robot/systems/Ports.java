package frc.robot.systems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

/**
*@author Daniel Pearson
*@version 11/19/19
*/

public class Ports {
  private static WPI_TalonSRX rightDriveTrainFront;
  private static WPI_TalonSRX rightDriveTrainBack;
  
  private static WPI_TalonSRX leftDriveTrainFront;
  private static WPI_TalonSRX leftDriveTrainBack;
  
  public static void init(){
    rightDriveTrainFront = new WPI_TalonSRX(Constants.RIGHT_FRONT_TALON);
    rightDriveTrainBack = new WPI_TalonSRX(Constants.RIGHT_BACK_TALON);
    leftDriveTrainFront = new WPI_TalonSRX(Constants.LEFT_FRONT_TALON);
    leftDriveTrainBack = new WPI_TalonSRX(Constants.LEFT_BACK_TALON);
    
    
  }
  
  /**
  *@return the left master talon
  */
  
  public static WPI_TalonSRX getLeftFront(){
    return leftDriveTrainFront;
  }
  
  /**
  *@return the left slave talon
  */
  
  public static WPI_TalonSRX getLeftBack(){
    return leftDriveTrainBack;
  }
  
  /**
  *@return the right master talon
  */
  
  public static WPI_TalonSRX getRightFront(){
    return rightDriveTrainFront;
  }
  
  /**
  *@return the right slave talon
  */
  
  public static WPI_TalonSRX getRightBack(){
    return rightDriveTrainBack;
  }
}
