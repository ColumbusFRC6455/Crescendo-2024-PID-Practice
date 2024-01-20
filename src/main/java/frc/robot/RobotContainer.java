// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Autos;

import frc.robot.commands.Intake.IntakeCommand;
import frc.robot.commands.Shooter.ShooterCommand;
import frc.robot.subsystems.Arm.ArmSubsystem;
import frc.robot.subsystems.Intake.IntakeSubsystem;
import frc.robot.subsystems.Shooter.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Arm.ArmCommands;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.RobotContainer;

public class RobotContainer {
  private IntakeSubsystem IntakeSys = new IntakeSubsystem();
  private ShooterSubsystem ShooterSys = new ShooterSubsystem();
  private ArmSubsystem armSys = new ArmSubsystem();

  public final static TalonSRX leftMotor0 = new TalonSRX(Constants.DRIVE_MOTORS.leftMotor0);
  public final static TalonSRX leftMotor1 = new TalonSRX(Constants.DRIVE_MOTORS.leftMotor1);
  public final static TalonSRX rightMotor0 = new TalonSRX(Constants.DRIVE_MOTORS.rightMotor0);
  public final static TalonSRX rightMotor1 = new TalonSRX(Constants.DRIVE_MOTORS.rightMotor1);

  public final static TalonSRX intakeBelt1 = new TalonSRX(Constants.INTAKE_MOTORS.intakeBelt1);
  public final static TalonSRX intakeBelt2 = new TalonSRX(Constants.INTAKE_MOTORS.intakeBelt2);
  public final static TalonSRX intakeWheels = new TalonSRX(Constants.INTAKE_MOTORS.intakeWheels);

  public final static TalonSRX shooter1 = new TalonSRX(Constants.SHOOTER_MOTORS.shooter1);
  public final static TalonSRX shooter2 = new TalonSRX(Constants.SHOOTER_MOTORS.shooter2);

  public final static TalonSRX arm = new TalonSRX(Constants.ARM_MOTORS.arm);

  public final static Ultrasonic colorSense = new Ultrasonic(0, 0);

  public final static Joystick joy1 = new Joystick(Constants.JOYSTICKS.joy1);
  public final static Joystick joy2 = new Joystick(Constants.JOYSTICKS.joy2);

  public final static Timer time = new Timer();

  ArmCommands ArmCommand1 = new ArmCommands(armSys, Constants.ARM.Arm_0_Ang);
  ArmCommands ArmCommand2 = new ArmCommands(armSys, Constants.ARM.Arm_90_Ang);
  ArmCommands ArmCommand3 = new ArmCommands(armSys, Constants.ARM.Arm_Max_Ang);
  ArmCommands ArmCommand4 = new ArmCommands(armSys, Constants.ARM.Arm_Min_Ang);

  ShooterCommand ShooterCommand1 = new ShooterCommand(ShooterSys, 0.2);
  ShooterCommand ShooterCommand2 = new ShooterCommand(ShooterSys, 0.5);
  IntakeCommand IntakeCommand = new IntakeCommand(IntakeSys, 0.2);

  public RobotContainer() {
    configureBindings();
    JoystickButton intakeButton = new JoystickButton(joy2, 1);
    JoystickButton ShooterButton1 = new JoystickButton(joy2, 2);
    JoystickButton ShooterButton2 = new JoystickButton(joy2, 3);

    intakeButton.onTrue(IntakeCommand);
    ShooterButton1.onTrue(ShooterCommand1);
    ShooterButton2.onTrue(ShooterCommand2);
  }

  private void configureBindings() {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(null /* m_exampleSubsystem */);
  }
}
