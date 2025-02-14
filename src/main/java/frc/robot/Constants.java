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
public final class Constants
{
    public static final class DriveConstants {
        public static final int LEFT_MOTOR_ONE_ID = 10;
        public static final int LEFT_MOTOR_TWO_ID = 11;
        public static final int RIGHT_MOTOR_ONE_ID = 12;
        public static final int RIGHT_MOTOR_TWO_ID = 13;

        public static final double ARCADE_DRIVE_Y_SPEED = 0.7;
        public static final double ARCADE_DRIVE_X_SPEED = 0.7;
    }

    public static final class CoralConstants {
        public static final int CORAL_MOTOR_ID = 14;

        public static final double CORAL_MOTOR_SPEED = 0.6;
        public static final double CORAL_MOTOR_VOLTAGE = 1;
    }

    public static final class AlgConstants {
        public static final int ALG_MOTOR_ID = 15;

        public static final double ALG_INTAKE_SPEED = 0.8;
        public static final double ALG_INTAKE_VOLTAGE = 1;

        public static final double ALG_OUTTAKE_SPEED = 0.4;
        public static final double ALG_OUTTAKE_VOLTAGE = 1;
    }

    public static final class ControllerConstants {
        public static final int DRIVER_CONTROLLER_PORT = 0;
        public static final int SHOOTER_CONTROLLER_PORT = 1;
    }
}
