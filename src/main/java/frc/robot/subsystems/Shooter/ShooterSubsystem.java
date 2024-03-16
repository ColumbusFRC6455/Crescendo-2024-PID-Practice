package frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;

public class ShooterSubsystem extends SubsystemBase {

  Timer time = new Timer();

  /** Creates a new ExampleSubsystem. */
  public ShooterSubsystem() {

    
    
  }
  public void miniSuck(){
    RobotContainer.intakeBelt1.set(Constants.SHOOTER.revBeltSpeed);
      RobotContainer.intakeBelt2.set(-Constants.SHOOTER.revBeltSpeed);
  }

  public void ShootDatNote() {
      RobotContainer.shooter1.set(Constants.SHOOTER.speakShootSpeed1);
      RobotContainer.shooter2.follow(RobotContainer.shooter1, true);
      }
  public void ShootDatNote2(){
    RobotContainer.intakeBelt1.set(-Constants.SHOOTER.revBeltSpeed);
      RobotContainer.intakeBelt2.set(Constants.SHOOTER.revBeltSpeed);
  }
  public void ShootDatNote3(){
    RobotContainer.shooter1.set(Constants.SHOOTER.ampShootSpeed1);
      RobotContainer.shooter2.follow(RobotContainer.shooter1, true);
  }
  public void StopShooting(){
    RobotContainer.intakeBelt1.set(0);
      RobotContainer.intakeBelt2.set(0);
      RobotContainer.shooter1.set(0);
      RobotContainer.shooter2.set(0);
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