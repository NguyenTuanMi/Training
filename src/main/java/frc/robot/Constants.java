// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class MOTOR_ID{
        public static final int RIGHTMASTER = 1;
        public static final int LEFTMASTER = 2;
        public static final int RIGHTFOLLOW = 3;
        public static final int LEFTFOLLOW = 4;

        public static final int INTAKE = 5;

    }
    public final class PiAiDi{
        public static final int kP = 1;
        public static final int kI = 1;
        public static final int kD = 1;
        
        public static final int kPL = 1;
        public static final int kIL = 1;
        public static final int kDL = 1;

        public static final int kPR = 1;
        public static final int kIR = 1;
        public static final int kDR = 1;

        public static final int kToleranceDegree = 1;
        public static final int kAngularVelocity = 1;
    }
}
