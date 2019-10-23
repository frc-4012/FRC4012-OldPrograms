package com.team4012.frc2020.functions;

import edu.wpi.first.wpilibj.Ultrasonic;
public class Ultra {
  private Ultrasonic ultra = new Ultrasonic(1,2,3);
  
  public void getDist(){
    return ultra.getDistance();
  }
}
