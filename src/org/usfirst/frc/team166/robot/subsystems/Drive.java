package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

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

	public void setMotorPower(double motorFrontRightPower, double motorFrontLeftPower, double motorRearRightPower,
			double motorRearLeftPower) {
		motorFrontRight.set(motorFrontRightPower);
		motorFrontLeft.set(motorFrontLeftPower);
		motorRearRight.set(motorRearRightPower);
		motorRearLeft.set(motorRearLeftPower);
	}

	public double getMotorSpeed(Encoder enc) {
		encoderRight.setDistancePerPulse((Math.PI * 4) / 1024); // Diameter of wheels is 4"
		encoderLeft.setDistancePerPulse((Math.PI * 4) / 1024);
		return enc.getRate();
	}

	// public void setEncoderDistance() {
	//
	// }

	@Override
	public void initDefaultCommand() {
	}
}
