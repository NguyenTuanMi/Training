// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.MOTOR_ID.*;
public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public WPI_TalonSRX intake = new WPI_TalonSRX(INTAKE);
  public Intake() {}

  public void eat(double velocity){
    intake.set(velocity);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
