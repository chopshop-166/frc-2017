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

	public void setMotorPower(double motorFrontRightPower, double motorFrontLeftPower, double motorRearRightPower,
			double motorRearLeftPower) {
		motorFrontRight.set(motorFrontRightPower);
		motorFrontLeft.set(motorFrontLeftPower);
		motorRearRight.set(motorRearRightPower);
		motorRearLeft.set(motorRearLeftPower);
	}

	public void driveStraight(double motorPower) {
		double compensatedPowerRight = motorPower + motorCompAngle(motorPower);
		double compensatedPowerLeft = motorPower - motorCompAngle(motorPower);

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
			Robot.drive.stopMotors();
		} else {
			Robot.drive.setMotorPower(leftJoyVal, rightJoyVal, leftJoyVal, rightJoyVal);
		}
	}

	public double motorCompAngle(double motorPower) {
		// double angularVelocity = gyro.getRate();
		// return motorPower * (angularVelocity / 10);
		double angleError = gyro.getAngle();
		return angleError / 45.0;

	}

	public double getMotorSpeed(Encoder enc) {
		encoderRight.setDistancePerPulse((Math.PI * 4) / 1024); // Diameter of wheels is 4"
		encoderLeft.setDistancePerPulse((Math.PI * 4) / 1024);
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
