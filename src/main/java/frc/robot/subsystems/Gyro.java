// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Gyro là cái xoay mòng mòng nhma ko bị đổ :))
// Vendor : https://www.kauailabs.com/dist/frc/2022/navx_frc.json

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Gyro extends SubsystemBase {
  /** Creates a new Gyro. */
  public AHRS ahrs;
  // AHRS là ciểu ba cái trục xoay xoay xoay rùi nó đi chiều khác-
  
  public Gyro() {
  // Cái hàm này lúc kích hoạt thì nó sẽ tạo một biến mới giống AHRS nhma output kcj cả :>
    ahrs = new AHRS();
      }
  private static Gyro gyro = null;
  // Khởi tạo biến gyro rỗng

  public static Gyro getInstance() {
  // Tạo hàm th :> Output sẽ là một hàm gyro mới

    if (gyro == null)
    // Khởi tạo lại biến bằng null (rống) :>
      gyro = new Gyro();
    return gyro;
  }
  public void reset() {
    ahrs.reset();
  }
  public double getYaw() {
    return ahrs.getYaw();
  }


  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("x", ahrs.getDisplacementX());
    SmartDashboard.putNumber("y", ahrs.getDisplacementX());
  }
}


