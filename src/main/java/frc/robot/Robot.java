// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.AutoCommand.AutoCommand;
import frc.robot.commands.Drive.DriveCommand;
import frc.robot.commands.Intake.IntakeCommand;
import frc.robot.commands.Shooter.ShooterCommand;
import frc.robot.subsystems.Shooter.ShooterSubsystem;
import frc.robot.subsystems.Auto.Auto;
import frc.robot.subsystems.Drive.DriveSubsystem;
import frc.robot.subsystems.Intake.IntakeSubsystem;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
  int autoStep;
  private ShooterSubsystem ShooterSys =new ShooterSubsystem();
  private Auto auto = new Auto();
  private IntakeSubsystem intakeSys = new IntakeSubsystem();
  @Override
  public void robotInit() {

    m_robotContainer = new RobotContainer();
    
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }


  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }


  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    autoStep = 1;
    if (autoStep == 1) {
      new ShooterCommand(ShooterSys, Constants.SHOOTER.shootSpeed1);
      autoStep = 2; 
    } else if (autoStep ==2 ) {
      new AutoCommand(auto, -3);
      new IntakeCommand(intakeSys);
      autoStep = 3;
    } else if (autoStep == 3 ){
      new AutoCommand(auto, 3);
      autoStep = 4;
    } else if (autoStep == 4){
      new ShooterCommand(ShooterSys, Constants.SHOOTER.shootSpeed1);
      autoStep = 5;
    } else if (autoStep == 5){
      new AutoCommand(auto, -10);
    }
  }
  

  @Override
  public void teleopInit() {
  
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    new DriveCommand(new DriveSubsystem()).schedule();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {
  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {
  }

  public static void initTalon(TalonSRX motor) {
    motor.setNeutralMode(NeutralMode.Coast);
    motor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    motor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    motor.configNominalOutputForward(0.0, 0);
    motor.configNominalOutputReverse(0.0, 0);
  }
  public static void initAutoTalon(TalonSRX motor) {
    motor.setNeutralMode(NeutralMode.Brake);
    motor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    motor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    motor.configNominalOutputForward(0.0, 0);
    motor.configNominalOutputReverse(0.0, 0);
  }
}
