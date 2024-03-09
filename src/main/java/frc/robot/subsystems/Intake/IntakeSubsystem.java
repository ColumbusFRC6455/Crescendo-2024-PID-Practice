package frc.robot.subsystems.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {

    Robot.initTalon(RobotContainer.intakeWheel1);
    Robot.initTalon(RobotContainer.intakeWheel2);

  }

  public void IntakeSuck() {
    RobotContainer.intakeBelt1.set(Constants.INTAKE.beltSpeed);
    RobotContainer.intakeBelt2.set(Constants.INTAKE.beltSpeed);
    RobotContainer.intakeWheel1.set(ControlMode.PercentOutput, Constants.INTAKE.wheelsSpeed);
    RobotContainer.intakeWheel2.set(ControlMode.PercentOutput, Constants.INTAKE.wheelsSpeed);
  }

  public void IntakeStop(){
    RobotContainer.intakeBelt1.set(0);
    RobotContainer.intakeBelt2.set(0);
    RobotContainer.intakeWheel1.set(ControlMode.PercentOutput, 0);
    RobotContainer.intakeWheel2.set(ControlMode.PercentOutput, 0);
  }

  


  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}