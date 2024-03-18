package frc.robot.commands.Drive;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive.DriveSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveBackCommand extends Command {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveSubsystem m_subsystem;
  private double time = Timer.getFPGATimestamp();
  private double x;

  public DriveBackCommand(DriveSubsystem subsystem, double x) {
    m_subsystem = subsystem;
    
    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {
    
    m_subsystem.driveBackSec(x);
    m_subsystem.printTime();
  }

  @Override
  public void execute() {
    
    
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveBackStop(x);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
