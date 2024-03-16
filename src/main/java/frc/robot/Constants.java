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
      public static final double speakShootSpeed1 = 1;

      public static final double ampShootSpeed1 = .45;
      public static final double ampShootSpeed2 = .5;
      public static final double beltSpeed = .5;
      public static final double revBeltSpeed = 0.2;
    }

    public static class Encoder{
      public static final int EncRightA = 2;
      public static final int EncRightB = 3;
      public static final int EncLeftA = 0;
      public static final int EncLeftB = 1;
    }
    public static class PIDDRIVE {
    public static final double RightkP = 5;
    public static final double RightkI = 0;
    public static final double RightkD = 0;

    public static final double LeftkP = 5; 
   public static final  double LeftkI = 0;
    public static final double LeftkD = 0;

    }



}
