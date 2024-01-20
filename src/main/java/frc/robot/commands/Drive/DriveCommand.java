package frc.robot.commands.Drive;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive.DriveSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.Command;

public class DriveCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_subsystem;

  public DriveCommand(DriveSubsystem subsystem) {
    m_subsystem = subsystem;
    addRequirements(subsystem);
  }

  
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double throttle = (1.0 - RobotContainer.joy1.getThrottle())/ -2.0;

    DriveSubsystem.arcadeDrive(ControlMode.PercentOutput, RobotContainer.joy1.getY() * throttle, RobotContainer.joy1.getX() * throttle );
  }


  @Override
  public void end(boolean interrupted) {}


  @Override
  public boolean isFinished() {
    return false;
  }
}
