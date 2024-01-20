package frc.robot.subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;

public class ShooterSubsystem extends SubsystemBase {

  double speed;
  Timer time = new Timer();

  /** Creates a new ExampleSubsystem. */
  public ShooterSubsystem() {

    Robot.initTalon(RobotContainer.shooter1);
    Robot.initTalon(RobotContainer.shooter2);
    time.restart();
  }

  public void ShootDatNote(double speed) {
    ControlMode mode = ControlMode.PercentOutput;
    if (time.get() > 2) {
      RobotContainer.intakeBelt1.set(mode, speed);
      RobotContainer.intakeBelt2.set(mode, -speed);
      RobotContainer.shooter1.set(mode, speed);
      RobotContainer.shooter2.set(mode, -speed);
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