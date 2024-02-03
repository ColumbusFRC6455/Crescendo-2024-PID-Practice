package frc.robot.subsystems.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class IntakeSubsystem extends SubsystemBase {
double speed;
  /** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {

    Robot.initTalon(RobotContainer.intakeWheel1);
    Robot.initTalon(RobotContainer.intakeWheel2);

  }

  public void IntakeSuck() {
    RobotContainer.intakeBelt1.set(speed);
    RobotContainer.intakeBelt2.set(-speed);
    RobotContainer.intakeWheel1.set(mode, -speed);
    RobotContainer.intakeWheel2.set(mode, -speed);
  }

  public void IntakeStop(){
    RobotContainer.intakeBelt1.set(0);
    RobotContainer.intakeBelt2.set(0);
    RobotContainer.intakeWheel1.set(mode, 0);
    RobotContainer.intakeWheel2.set(mode, 0);
  }

  public double getRange(){
    
  }
  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}