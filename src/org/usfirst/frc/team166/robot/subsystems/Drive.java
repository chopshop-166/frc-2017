package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team166.robot.Robot;
import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class Drive extends Subsystem {

	Victor motorFrontRight = new Victor(RobotMap.frontRightMotor);
	Victor motorFrontLeft = new Victor(RobotMap.frontRightMotor);
	Victor motorRearRight = new Victor(RobotMap.frontRightMotor);
	Victor motorRearLeft = new Victor(RobotMap.frontRightMotor);

	Encoder encoderRight = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
	Encoder encoderLeft = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);

	AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

	public double wheelDiameter = 10.0; // inches

	public void setMotorPower(double motorFrontRightPower, double motorFrontLeftPower, double motorRearRightPower,
			double motorRearLeftPower) {
		motorFrontRight.set(motorFrontRightPower);
		motorFrontLeft.set(motorFrontLeftPower);
		motorRearRight.set(motorRearRightPower);
		motorRearLeft.set(motorRearLeftPower);
	}

	public void driveStraight(double motorPower) {
		double compensatedPowerRight = motorPower + motorCompDriveStraight(motorPower);
		double compensatedPowerLeft = motorPower - motorCompDriveStraight(motorPower);

		setMotorPower(compensatedPowerRight, compensatedPowerLeft, compensatedPowerRight, compensatedPowerLeft);
	}

	public double getDistanceSinceLastReset() {
		return (encoderRight.getDistance() + encoderLeft.getDistance()) / 2;
	}

	public boolean hasDrivenDistance(double distInches) {
		return getDistanceSinceLastReset() >= distInches;
	}

	public void stopMotors() {
		setMotorPower(0, 0, 0, 0);
	}

	public void driveJoysticks(double leftJoyVal, double rightJoyVal) {
		if (areJoysticksInDeadzone()) {
			stopMotors();
		} else {
			setMotorPower(leftJoyVal, rightJoyVal, leftJoyVal, rightJoyVal);
		}
	}

	public double motorCompDriveStraight(double motorPower) {
		// double angularVelocity = gyro.getRate();
		// return motorPower * (angularVelocity / 10);
		return (angleErrorDriveStraight() / 10.0) * motorPower;
	}

	public void turnAngle(double desiredAngle) {

		double angleError = desiredAngle - gyro.getAngle();

		if (angleError >= 20.0) {
			setMotorPower(1, -1, 1, -1);
		} else if (angleError <= -20.0) {
			setMotorPower(-1, 1, -1, 1);

		} else if ((angleError <= 20.0 && angleError >= 5.0) || (angleError >= -20.0 && angleError <= -5.0)) {
			setMotorPower(angleError / 20.0, -angleError / 20.0, angleError / 20.0, -angleError / 20.0);

		} else if ((angleError < 5.0 && angleError >= 0.1) || (angleError > -5.0 && angleError <= -0.1)) {
			setMotorPower(0.25, -0.25, 0.25, -0.25);

		} else if (angleError < 0.1 && angleError > -0.1) {
			stopMotors();
		}
	}

	public double angleErrorDriveStraight() {
		double getAngle = gyro.getAngle();

		if (getAngle <= 180)
			return gyro.getAngle();
		else
			return gyro.getAngle() - 360;
	}

	public double angleError() {
		double getAngle = gyro.getAngle();

		if (getAngle <= 180)
			return gyro.getAngle();
		else
			return gyro.getAngle() - 360;
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

	public boolean areJoysticksInDeadzone() {
		double joyL = Robot.oi.getLeftY();
		double joyR = Robot.oi.getRightY();
		return ((Math.abs(joyL) - Math.abs(joyR)) < 0.1);
	}

	// public void setEncoderDistance() {
	//
	// }

	@Override
	public void initDefaultCommand() {
	}
}
