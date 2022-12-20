// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.PiAiDi.*;

public class TurnController extends SubsystemBase {
  /** Creates a new TurnController. */
  private PIDController turnController;
  public TurnController() {
    turnController = new PIDController(kP, kI, kD);
  }

  private static TurnController tController = null;
  private static TurnController getInstance() {
    if (tController == null) {
      tController = new TurnController();
    }
    return tController;
  }

  
// Set setPoint for PID Controller. For eg, u wanna rotate 30o, this 
// will set the setPoint to 30o
  public void setSetPoint(double x){
    turnController.setSetpoint(x);
  }
//Reset the PID Controller to 0
  public void reset() {
    turnController.reset();
  }
//a, b are angle. This function will make the robot set between a and b 
  public void enableContinuousInput(double a, double b) {
    turnController.enableContinuousInput(a, b);
  }

  public void setIntegratorRange(double m, double n) {
    turnController.setIntegratorRange(m, n);
  }
//Set error that could be accepted
  public void setTolerance() {
    turnController.setTolerance(kToleranceDegree, kAngularVelocity);
  }
//Return the output  of PID
  public double calculate(double c) {
    return turnController.calculate(c);
  }
//Return true if measurement error is in Tolerance
  public boolean atSetpoint() {
    return turnController.atSetpoint();
  }
  
  public void enable() {
    
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
