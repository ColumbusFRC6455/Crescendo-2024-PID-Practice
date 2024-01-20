package frc.robot.subsystems.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class IntakeSubsystem extends SubsystemBase {

  double speed;

  /** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {
    Robot.initTalon(RobotContainer.intakeBelt1);
    Robot.initTalon(RobotContainer.intakeBelt2);
    Robot.initTalon(RobotContainer.intakeWheels);

  }

  public void IntakeSuck(double speed) {
    ControlMode mode = ControlMode.PercentOutput;
    RobotContainer.colorSense.getRangeInches();
    RobotContainer.intakeBelt1.set(mode, speed);
    RobotContainer.intakeBelt2.set(mode, -speed);
    RobotContainer.intakeWheels.set(mode, -speed);

    if (RobotContainer.colorSense.getRangeInches() < 4) {
      speed = 0;
    }
  }

  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}