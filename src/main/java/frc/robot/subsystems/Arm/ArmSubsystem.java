package frc.robot.subsystems.Arm;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.hardware.CANcoder;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import com.revrobotics.SparkLimitSwitch;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkPIDController;

public class ArmSubsystem extends SubsystemBase {
    TalonSRX arm_motor;
    public PIDController armController;
    CANcoder coder;

    double kP;
    double kI;
    double kD;

    public ArmSubsystem() {

        arm_motor = RobotContainer.arm;
        armController = new PIDController(kP, kI, kD); // reasonable first guess would be .01 assuming input in degree,
                                                       // output is in percent
        coder = new CANcoder(0);
        Robot.initTalon(arm_motor);

        armController.setIntegratorRange(-180.0f, 180.0f);
        armController.setTolerance(2.0f);
        // armController.enableContinuousInput(kI, kD);
    }

    public void rotateDegrees(double angle) {
        armController.reset();
        armController.setSetpoint(angle);
        armController.calculate(angle);
    }

    @Override
    public void periodic() {
        arm_motor.set(ControlMode.PercentOutput, 
            armController.calculate(coder.getAbsolutePosition().getValueAsDouble()));
        System.out.println(coder.getAbsolutePosition().getValueAsDouble());
    }

    /*
     * public void ArmOpen() {
     * RobotContainer.solenoid.set(Value.kForward);
     * }
     * 
     * public void ArmClose() {
     * RobotContainer.solenoid.set(Value.kReverse);
     * }
     */
}