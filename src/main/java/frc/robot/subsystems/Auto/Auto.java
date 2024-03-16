package frc.robot.subsystems.Auto;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Auto extends SubsystemBase {
  public static PIDController encRightController;
  public static PIDController encLeftController;
  TalonSRX right;
  TalonSRX left;

  static Encoder EncLeft;
  static Encoder EncRight;
  

    
    double rightTravelled;
    double leftTravelled;

    public Auto() {
      EncLeft = RobotContainer.EncLeft;
      EncRight = RobotContainer.EncRight;

      EncLeft.setDistancePerPulse(0.009);
      EncRight.setDistancePerPulse(0.009);

      right = RobotContainer.rightMotor0;
      left = RobotContainer.leftMotor0;
        
        encRightController = new PIDController(Constants.PIDDRIVE.RightkP, Constants.PIDDRIVE.RightkI, Constants.PIDDRIVE.RightkD);
        encLeftController = new PIDController(Constants.PIDDRIVE.LeftkP, Constants.PIDDRIVE.LeftkI, Constants.PIDDRIVE.LeftkD); // reasonable first guess would be .01 assuming input in degree,
                                                       // output is in percent

        encLeftController.setIntegratorRange(-180.0f, 180.0f);
        encLeftController.setTolerance(2.0f);
        encRightController.setIntegratorRange(-180.0f, 180.0f);
        encRightController.setTolerance(2.0f);
        // armController.enableContinuousInput(kI, kD);

        Robot.initAutoTalon(right);
        Robot.initAutoTalon(left);
    }


    
    public void mySetSetpoint(double setpoint){
      resetEncoders();
      encLeftController.setSetpoint(-setpoint);
      encRightController.setSetpoint(setpoint);
    }

    public static void resetEncoders() {
      encLeftController.reset();
      encRightController.reset();
    }


  @Override
  public void periodic() {
   right.set(ControlMode.PercentOutput, 
        encRightController.calculate(EncRight.getDistance()));
    left.set(ControlMode.PercentOutput, 
        encLeftController.calculate(EncLeft.getDistance()));
  }

  @Override
  public void simulationPeriodic() {
  }
  }

