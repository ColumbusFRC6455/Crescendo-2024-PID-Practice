package frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;

public class ShooterSubsystem extends SubsystemBase {

  double speed;
  Timer time = new Timer();

  /** Creates a new ExampleSubsystem. */
  public ShooterSubsystem() {

    
    
  }

  public void ShootDatNote(double speed) {
    time.restart();
    if (time.get() > 2) {
      RobotContainer.intakeBelt1.set(speed);
      RobotContainer.intakeBelt2.set(-speed);
      RobotContainer.shooter1.set(speed);
      RobotContainer.shooter2.set(-speed);
    } else {
      speed = 0;
    }

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