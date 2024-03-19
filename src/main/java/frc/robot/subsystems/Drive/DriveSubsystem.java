package frc.robot.subsystems.Drive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private double time = Timer.getFPGATimestamp();
  public DriveSubsystem() {
  
    Robot.initTalon(RobotContainer.leftMotor0);
    Robot.initTalon(RobotContainer.leftMotor1);
    Robot.initTalon(RobotContainer.rightMotor0);
    Robot.initTalon(RobotContainer.rightMotor1);

    //RobotContainer.leftMotor0.follow(RobotContainer.leftMotor1);
   // RobotContainer.rightMotor0.follow(RobotContainer.rightMotor1);
  }

  public static void arcadeDrive(ControlMode mode, double y, double x) {
    RobotContainer.drive.arcadeDrive(x, -y);
  }

  public void driveBackSec() {
    RobotContainer.leftMotor1.set(.25);
    RobotContainer.rightMotor1.set(.25);
  
  }

  public void driveBackStop() {
    RobotContainer.leftMotor1.set(0);
    RobotContainer.rightMotor1.set(0);
    
  }

public void printTime() {
    SmartDashboard.putNumber("time", time);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
