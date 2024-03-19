package frc.robot.commands.Drive;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive.DriveSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveBackCommand extends Command {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveSubsystem m_subsystem;
  private Timer Time; 


  public DriveBackCommand(DriveSubsystem subsystem) {
    m_subsystem = subsystem;
    Time = RobotContainer.Time;
    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {
    Time.reset();
    Time.start();
    
    
  }

  @Override
  public void execute() {
    
    
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveBackStop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
