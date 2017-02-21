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

	public void driveStraight(double motorPower) {
		double compensatedPowerRight = motorPower + motorCompDriveStraight(motorPower);
		double compensatedPowerLeft = motorPower - motorCompDriveStraight(motorPower);

		if (compensatedPowerRight > 1.0) {
			setMotorPower(1.0, compensatedPowerLeft);

		} else if (compensatedPowerRight < 1.0) {
			setMotorPower(-1.0, compensatedPowerLeft);

		} else if (compensatedPowerLeft > 1.0) {
			setMotorPower(compensatedPowerRight, 1.0);

		} else if (compensatedPowerLeft < 1.0) {
			setMotorPower(compensatedPowerRight, -1.0);

		} else {
			setMotorPower(compensatedPowerRight, compensatedPowerLeft);
		}
	}

	public void driveStraightGyro(double motorPower) {
		double angleError = angleErrorDriveStraight();
		double compensatedPowerRight = motorPower + motorCompDriveStraightGyro(angleError);
		double compensatedPowerLeft = motorPower - motorCompDriveStraightGyro(angleError);

		setMotorPower(compensatedPowerRight, compensatedPowerLeft);
	}

	public double getDistanceSinceLastReset() {
		return (encoderRight.getDistance() + encoderLeft.getDistance() / 2);
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

	public double motorCompDriveStraight(double motorPower) {
		double distDifference = encoderLeft.getDistance() - encoderRight.getDistance();
		return (distDifference / 2.0) * motorPower;
	}

	public double motorCompDriveStraightGyro(double angleError) {
		// double distDifference = encoderLeft.getDistance() - encoderRight.getDistance();
		// return (distDifference / 2.0) * motorPower;
		if (angleError >= 0.0)
			return (-1.0 * ((1 / (Math.abs(angleError / 5.0) + 1.0)) + 1.0));
		else
			return ((1.0 / (Math.abs(angleError / 5.0) + 1.0)) - 1.0);
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

	public double angleErrorDriveStraight() {
		double getAngle = gyro.getAngle();

		if (getAngle < 0)
			return -360.0 + gyro.getAngle();
		else
			return gyro.getAngle();
	}

	public double angleError() {
		double getAngle = gyro.getAngle();

		if (getAngle <= 180)
			return gyro.getAngle();
		else
			return 360 - gyro.getAngle();
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
