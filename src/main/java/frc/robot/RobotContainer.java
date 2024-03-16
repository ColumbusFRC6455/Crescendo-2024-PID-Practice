// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Intake.IntakeCommand;
import frc.robot.commands.Shooter.AmpShootCommand;
import frc.robot.commands.Shooter.MiniSuckCommand;
import frc.robot.commands.Shooter.ShooterCommand;
import frc.robot.commands.Shooter.ShooterCommandStop;
import frc.robot.commands.Shooter.ShooterCommandStop;
import frc.robot.subsystems.Arm.ArmSubsystem;
import frc.robot.subsystems.Intake.IntakeSubsystem;
import frc.robot.subsystems.Shooter.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Arm.ArmCommands;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotContainer;

public class RobotContainer {
  
  private IntakeSubsystem IntakeSys = new IntakeSubsystem();
  private static ShooterSubsystem ShooterSys = new ShooterSubsystem();
  private ArmSubsystem armSys = new ArmSubsystem();

  public final static WPI_TalonSRX leftMotor0 = new WPI_TalonSRX(Constants.DRIVE_MOTORS.leftMotor0);
  public final static WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(Constants.DRIVE_MOTORS.leftMotor1);
  public final static WPI_TalonSRX rightMotor0 = new WPI_TalonSRX(Constants.DRIVE_MOTORS.rightMotor0);
  public final static WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(Constants.DRIVE_MOTORS.rightMotor1);

  public final static CANSparkMax intakeBelt1 = new CANSparkMax(Constants.INTAKE_MOTORS.intakeBelt0, MotorType.kBrushless);
  public final static CANSparkMax intakeBelt2 = new CANSparkMax(Constants.INTAKE_MOTORS.intakeBelt1, MotorType.kBrushless);
  public final static WPI_TalonSRX intakeWheel1 = new WPI_TalonSRX (Constants.INTAKE_MOTORS.intakeWheel0);
  public final static WPI_TalonSRX intakeWheel2 = new WPI_TalonSRX(Constants.INTAKE_MOTORS.intakeWheel1);

  public final static CANSparkMax shooter1 = new CANSparkMax(Constants.SHOOTER_MOTORS.shooter0, MotorType.kBrushless);
  public final static CANSparkMax shooter2 = new CANSparkMax(Constants.SHOOTER_MOTORS.shooter1, MotorType.kBrushless);

  public final static WPI_TalonSRX arm = new WPI_TalonSRX(Constants.ARM_MOTORS.arm);

  public final static DifferentialDrive drive = new DifferentialDrive(leftMotor0, rightMotor0);

  public final static Encoder EncRight = new Encoder(Constants.Encoder.EncRightA, Constants.Encoder.EncRightB);
  public final static Encoder EncLeft = new Encoder(Constants.Encoder.EncLeftA , Constants.Encoder.EncLeftB );

  public final static Joystick joy1 = new Joystick(Constants.JOYSTICKS.joy1);
  public final static Joystick joy2 = new Joystick(Constants.JOYSTICKS.joy2);

  public final static Timer time = new Timer();

  ArmCommands ArmCommand1 = new ArmCommands(armSys, Constants.ARM.Arm_0_Ang);
  ArmCommands ArmCommand2 = new ArmCommands(armSys, Constants.ARM.Arm_90_Ang);
  ArmCommands ArmCommand3 = new ArmCommands(armSys, Constants.ARM.Arm_Max_Ang);
  ArmCommands ArmCommand4 = new ArmCommands(armSys, Constants.ARM.Arm_Min_Ang);

  ShooterCommand ShooterCommand1 = new ShooterCommand(ShooterSys);
  AmpShootCommand ShooterCommand2 = new AmpShootCommand(ShooterSys);
  ShooterCommandStop ShootCommand3 = new ShooterCommandStop(ShooterSys);
  IntakeCommand IntakeCommand = new IntakeCommand(IntakeSys);
  MiniSuckCommand miniSuckCommand = new MiniSuckCommand(ShooterSys);

  public RobotContainer() {
    configureBindings();
    JoystickButton miniSuckButton = new JoystickButton(joy2, 12);
    JoystickButton intakeButton = new JoystickButton(joy2, 11);
    JoystickButton ShooterButton1 = new JoystickButton(joy2, 4);
    JoystickButton ShooterButton2 = new JoystickButton(joy2, 3);
    JoystickButton StopShoot = new JoystickButton(joy2, 6);
    
    intakeButton.whileTrue(IntakeCommand);
    miniSuckButton.whileTrue(miniSuckCommand);
    ShooterButton1.onTrue(ShooterCommand1);
    ShooterButton2.onTrue(ShooterCommand2);
    StopShoot.onTrue(ShootCommand3);
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
    return null;
  }
}
