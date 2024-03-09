package frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;

public class ShooterSubsystem extends SubsystemBase {
double speed;
  Timer time = new Timer();

  /** Creates a new ExampleSubsystem. */
  public ShooterSubsystem() {

    
    
  }
  public void miniSuck(){
    RobotContainer.intakeBelt1.set(Constants.SHOOTER.revBeltSpeed);
      RobotContainer.intakeBelt2.set(-Constants.SHOOTER.revBeltSpeed);
  }

  public void ShootDatNote() {
      RobotContainer.shooter1.set(speed);
      RobotContainer.shooter2.set(-speed);
  }
  public void ShootDatNote2(){
    RobotContainer.intakeBelt1.set(Constants.SHOOTER.beltSpeed);
      RobotContainer.intakeBelt2.set(-Constants.SHOOTER.beltSpeed);
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