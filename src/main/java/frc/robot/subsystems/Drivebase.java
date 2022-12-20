// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import static frc.robot.Constants.MOTOR_ID.*;

public class Drivebase extends SubsystemBase {
  /** Creates a new Drivebase. */
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RIGHTMASTER);
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(LEFTMASTER);
  public WPI_TalonSRX rightFollow = new WPI_TalonSRX(RIGHTFOLLOW);
  public WPI_TalonSRX leftFollow = new WPI_TalonSRX(LEFTFOLLOW);

  public Joystick ps4  = new Joystick(1);
  public Drivebase() {
    rightFollow.follow(rightMaster);
    leftFollow.follow(leftMaster);

    leftFollow.setInverted(true);

  }
public void drive(double leftDrive, double rightDrive){
  leftMaster.set(leftDrive);
  rightMaster.set(rightDrive);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double multiple = ps4.getRawButton(1)? 0.8 : 0.4;
    drive(multiple*ps4.getRawAxis(1), multiple*ps4.getRawAxis(2));
  }
}
