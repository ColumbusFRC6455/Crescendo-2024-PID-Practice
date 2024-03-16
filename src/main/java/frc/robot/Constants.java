// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class DRIVE_MOTORS {
    public static final int leftMotor0 = 0;
    public static final int leftMotor1 = 2;
    public static final int rightMotor0 = 1;
    public static final int rightMotor1 = 3;
  }

  public static class INTAKE_MOTORS {
    public static final int intakeBelt0 = 4;
    public static final int intakeBelt1 = 5;
    public static final int intakeWheel0 = 6;
    public static final int intakeWheel1 = 7;
  }

  public static class SHOOTER_MOTORS {
    public static final int shooter0 = 8;
    public static final int shooter1 = 9;
  }

  public static class ARM_MOTORS {
    public static final int arm = 10;
  }

  public static class JOYSTICKS {
    public static final int joy1 = 0;
    public static final int joy2 = 1;
  }



    public static class INTAKE{
      public static final double wheelsSpeed = .8;
      public static final double beltSpeed = .8;
    }

    public static class SHOOTER{
      public static final double shootSpeed1 = 2;
      public static final double shootSpeed2 = .5;
      public static final double beltSpeed = .8;
      public static final double revBeltSpeed = 0.2;
    }

    public static class Encoder{
      public static final int EncRightA = 0;
      public static final int EncRightB = 1;
      public static final int EncLeftA = 2;
      public static final int EncLeftB = 3;
    }

    public static class ARM {
    public static final int Arm_0_Ang = 0;
    public static final int Arm_90_Ang = 0;
    public static final int Arm_Max_Ang = 0;
    public static final int Arm_Min_Ang = 0;
    public static final int Arm_Test_Ang = 0;

    // Once found real angle subract or add to make 90, 180 or 0
  }

}
