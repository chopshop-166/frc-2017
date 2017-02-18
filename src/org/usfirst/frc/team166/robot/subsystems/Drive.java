package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team166.robot.Robot;
import org.usfirst.frc.team166.robot.RobotMap;
import org.usfirst.frc.team166.robot.commands.DriveWithJoysticks;

/**
 * TEMPORARALY REMOVED CAN FROM CANTALON TO MAKE SOFTWARE MERGEABLE
 */
public class Drive extends Subsystem {

	Talon motorFrontRight = new Talon(RobotMap.frontRightMotor);
	Talon motorFrontLeft = new Talon(RobotMap.frontLeftMotor);
	Talon motorRearRight = new Talon(RobotMap.rearRightMotor);
	Talon motorRearLeft = new Talon(RobotMap.rearLeftMotor);

	Encoder encoderRight = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
	Encoder encoderLeft = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);

	AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

	public double wheelDiameter = 4.0; // inches
	public double angleError;

	public void setMotorPower(double motorFrontRightPower, double motorFrontLeftPower, double motorRearRightPower,
			double motorRearLeftPower) {

		motorFrontRight.set(motorFrontRightPower);
		motorFrontLeft.set(-motorFrontLeftPower);
		motorRearRight.set(motorRearRightPower);
		motorRearLeft.set(-motorRearLeftPower);
		SmartDashboard.putNumber("Motor Power: ", motorFrontRightPower);
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

	public void driveJoysticks(double rightJoyVal, double leftJoyVal) {
		// if (areJoysticksInDeadzone()) {
		// stopMotors();
		// } else {
		setMotorPower(Math.pow(rightJoyVal, 3), Math.pow(leftJoyVal, 3), Math.pow(rightJoyVal, 3),
				Math.pow(leftJoyVal, 3));
		// }
	}

	public double motorCompDriveStraight(double motorPower) {
		// double angularVelocity = gyro.getRate();
		// return motorPower * (angularVelocity / 10);
		return (angleErrorDriveStraight() / 10.0) * motorPower;
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

		setMotorPower(motorCompAngle(angleError), -motorCompAngle(angleError), motorCompAngle(angleError),
				-motorCompAngle(angleError));
	}

	public void turnAngleCW() {
		angleError = Math.abs(angleError);

		setMotorPower(-motorCompAngle(angleError), motorCompAngle(angleError), -motorCompAngle(angleError),
				motorCompAngle(angleError));
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

	public boolean areJoysticksInDeadzone() {
		double joyL = Robot.oi.getLeftY();
		double joyR = Robot.oi.getRightY();
		return ((Math.abs(joyL) - Math.abs(joyR)) < 0.1);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoysticks());

		gyro.calibrate();
	}
}
