package frc.robot.subsystems.Auto;
import frc.robot.Robot;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.hardware.CANcoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.Odometry;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Auto extends SubsystemBase {
  public PIDController encRightController;
  public PIDController encLeftController;
  TalonSRX right;
  TalonSRX left;

  static Encoder EncLeft;
  static Encoder EncRight;
  

    double RightkP;
    double RightkI;
    double RightkD;

    double LeftkP;
    double LeftkI;
    double LeftkD;

    double rightTravelled;
    double leftTravelled;

    public Auto() {
      EncLeft = RobotContainer.EncLeft;
      EncRight = RobotContainer.EncRight;

      EncLeft.setDistancePerPulse(0.002);
      EncRight.setDistancePerPulse(0.002);

        TalonSRX right = RobotContainer.rightMotor0;
        TalonSRX left = RobotContainer.leftMotor0;
        
        encRightController = new PIDController(RightkP, RightkI, RightkD);
        encLeftController = new PIDController(LeftkP, LeftkI, LeftkD); // reasonable first guess would be .01 assuming input in degree,
                                                       // output is in percent

        encLeftController.setIntegratorRange(-180.0f, 180.0f);
        encLeftController.setTolerance(2.0f);
        encRightController.setIntegratorRange(-180.0f, 180.0f);
        encRightController.setTolerance(2.0f);
        // armController.enableContinuousInput(kI, kD);

        Robot.initAutoTalon(right);
        Robot.initAutoTalon(left);
    }

    public void driveStraight(){
      
    }

    public static void resetEncoders() {
      EncLeft.reset();
      EncRight.reset();
    }


  public Command exampleMethodCommand() {
    
    return runOnce(
        () -> {
       
        });
  }

  
  public boolean exampleCondition() {
   
    return false;
  }

  @Override
  public void periodic() {
   
  }

  @Override
  public void simulationPeriodic() {
    
  }
}
