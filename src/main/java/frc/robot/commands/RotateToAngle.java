// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.TurnController;
import frc.robot.subsystems.Gyro;
import static frc.robot.Constants.PiAiDi.*;

public class RotateToAngle extends CommandBase {
  /** Creates a new RotateToAngle. */
  private final Drivebase db;
  private final Gyro gyro;
  PIDController turnController;

  public RotateToAngle(Drivebase m_drivetrain, double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    db = m_drivetrain;
    gyro = Gyro.getInstance();
    turnController = new PIDController(kP, kI, kD);
    turnController.setSetpoint(angle);
    turnController.enableContinuousInput(-180, 180);
    turnController.setTolerance(kToleranceDegree, kAngularVelocity);
    
    addRequirements(db);
    addRequirements(gyro);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    turnController.reset();
    gyro.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("start", true);
    SmartDashboard.putNumber("angle", gyro.getYaw());
    double speed = turnController.calculate(gyro.getYaw());
    speed += Math.signum(speed) * 0.1;
    speed = Math.min(0.6, Math.max(-0.6, speed));
    db.drive(-speed, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    db.drive(0, 0);
    SmartDashboard.putBoolean("start", false);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return turnController.atSetpoint();
  }
}

