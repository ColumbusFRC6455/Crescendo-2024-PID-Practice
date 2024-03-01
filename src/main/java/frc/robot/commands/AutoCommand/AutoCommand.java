package frc.robot.commands.AutoCommand;


import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Auto.Auto;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class AutoCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Auto m_subsystem;


  public AutoCommand(Auto subsystem) {
    m_subsystem = subsystem;
    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {
    m_subsystem.encLeftController.setSetpoint(0);
    m_subsystem.encRightController.setSetpoint(0);

  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return m_subsystem.encLeftController.atSetpoint() && m_subsystem.encRightController.atSetpoint();
  }
}
