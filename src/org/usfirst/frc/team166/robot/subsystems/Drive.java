package org.usfirst.frc.team166.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team166.robot.Robot;
import org.usfirst.frc.team166.robot.RobotMap;
import org.usfirst.frc.team166.robot.commands.DriveWithJoysticks;

/**
 * TEMPORARALY REMOVED CAN FROM CANTALON TO MAKE SOFTWARE MERGEABLE
 */
public class Drive extends Subsystem {

	CANTalon motorFrontRight = new CANTalon(RobotMap.frontRightMotor);
	CANTalon motorRearRight = new CANTalon(RobotMap.rearRigthMotor);
	CANTalon motorFrontLeft = new CANTalon(RobotMap.frontLeftMotor);
	CANTalon motorRearLeft = new CANTalon(RobotMap.rearLeftMotor);

	Encoder encoderRight = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
	Encoder encoderLeft = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);

	AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

	private static final double wheelDiameter = 4;
	private static final int pulsesPerRevolution = 360;
	public double angleError;

	public Drive() { // constructor
		encoderLeft.setReverseDirection(true);
		encoderRight.setDistancePerPulse((Math.PI * wheelDiameter) / pulsesPerRevolution);
		encoderLeft.setDistancePerPulse((Math.PI * wheelDiameter) / pulsesPerRevolution);

		motorFrontRight.setInverted(true);
		motorRearRight.setInverted(true);
	}

	public void setMotorPower(double rightPower, double leftPower) {
		motorFrontRight.set(rightPower);
		motorRearRight.set(rightPower);

		motorFrontLeft.set(leftPower);
		motorRearLeft.set(leftPower);

		SmartDashboard.putNumber("Right Encoder Distance: ", encoderRight.getDistance());
		SmartDashboard.putNumber("Left Encoder Distance: ", encoderLeft.getDistance());
	}

	public double getGyroAngle() {
		double angle = gyro.getAngle();
		SmartDashboard.putNumber("Gyro Angle", angle);
		return angle;
	}

	public void driveStraightGyro(double motorPower) {
		double angleError = angleError();
		double compensatedPowerRight = motorPower;
		double compensatedPowerLeft = motorPower;
		if (Math.abs(angleError) < 1) {
			if (angleError > 0) {
				// if error is positive then we need to turn left
				// to turn left the right side needs to go faster
				compensatedPowerRight = compensatedPowerRight + motorCompDriveStraightGyro(angleError);
			} else {
				// if error is negative then we need to turn right
				// to turn right the left side needs to go faster
				compensatedPowerLeft = compensatedPowerLeft + motorCompDriveStraightGyro(angleError);
			}
		}

		SmartDashboard.putNumber("Angle Error", angleError);
		SmartDashboard.putNumber("Comp Power Left", compensatedPowerLeft);
		SmartDashboard.putNumber("Comp Power Right", compensatedPowerRight);
		setMotorPower(compensatedPowerRight, compensatedPowerLeft);
	}

	public double getDistanceSinceLastReset() {
		return (encoderLeft.getDistance());
	}

	public boolean hasDrivenDistance(double distInches) {
		return getDistanceSinceLastReset() >= distInches;
	}

	public void stopMotors() {
		setMotorPower(0, 0);
	}

	public void driveJoysticks(double rightJoyVal, double leftJoyVal) {
		// if (areJoysticksInDeadzone()) {
		// stopMotors();
		// } else {
		double RightPower = Math.pow(rightJoyVal, 3);
		double LeftPower = Math.pow(leftJoyVal, 3);

		setMotorPower(RightPower, LeftPower);
		// }
	}

	public double motorCompDriveStraightGyro(double angleError) {
		return (angleError / 90) * 2;
	}

	public void turnAngle(double desiredAngle) {

		angleError = desiredAngle - gyro.getAngle();
		SmartDashboard.putNumber("Angle: ", gyro.getAngle());
		SmartDashboard.putNumber("Desired Angle: ", desiredAngle);
		SmartDashboard.putNumber("Angle error: ", angleError);

		if (angleError <= 180.0 || angleError <= -180.0)
			turnAngleCW();
		else
			turnAngleCCW();

	}

	public void turnAngleCCW() {
		angleError = Math.abs(angleError);

		setMotorPower(motorCompAngle(angleError), -motorCompAngle(angleError));
	}

	public void turnAngleCW() {
		angleError = Math.abs(angleError);

		setMotorPower(-motorCompAngle(angleError), motorCompAngle(angleError));
	}

	public double angleError() {
		double getAngle = gyro.getAngle();

		// if (getAngle > 180)
		// getAngle += -360.0;

		SmartDashboard.putNumber("Gyro Angle", getAngle);
		return getAngle;
	}

	public double motorCompAngle(double angleError) {
		if ((angleError + 2) >= 45)
			return 1.0;
		else
			return (1 / 1.65321) * Math.log10(angleError + 2);
	}

	public double getMotorSpeed(Encoder enc) {
		encoderRight.setDistancePerPulse((Math.PI * wheelDiameter) / 1024);
		encoderLeft.setDistancePerPulse((Math.PI * wheelDiameter) / 1024);
		return enc.getRate();
	}

	public void resetGyro() {
		gyro.reset();
	}

	public void resetEncoders() {
		encoderRight.reset();
		encoderLeft.reset();
	}

	public void invertEncoders() {
		encoderLeft.setReverseDirection(true);
	}

	public boolean areJoysticksInDeadzone() {
		double joyL = Robot.oi.getLeftY();
		double joyR = Robot.oi.getRightY();
		return ((Math.abs(joyL) - Math.abs(joyR)) < 0.1);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoysticks());

		// gyro.calibrate();
	}
}
