package frc.robot.commands.AutoCommand;


import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Auto.Auto;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class AutoCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Auto m_subsystem;
    private final double m_distance;

  public AutoCommand(Auto subsystem, double distance) {
    m_subsystem = subsystem;
    m_distance = distance;
    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {
    Auto.encLeftController.setSetpoint(m_distance);
    Auto.encRightController.setSetpoint(m_distance);

  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return Auto.encLeftController.atSetpoint() && Auto.encRightController.atSetpoint();
  }
}
