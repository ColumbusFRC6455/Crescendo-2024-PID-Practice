package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm.ArmSubsystem;

public class ArmCommands extends Command {
  private double m_angle;
  private ArmSubsystem m_subsystem;

  public ArmCommands(ArmSubsystem subsystem, double angle) {
    m_subsystem = subsystem;
    m_angle = angle;

    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {

    m_subsystem.armController.setSetpoint(m_angle);

  }

  @Override
  public void execute() {

  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return m_subsystem.armController.atSetpoint();
  }
}
