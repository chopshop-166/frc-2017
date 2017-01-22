package org.usfirst.frc.team166.robot.subsystems;

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

	public void driveStraight(double motorPower) {

	}

	public void turnRight() {

	}

	public void turnLeft() {

	}

	public void stop() {

	}

	@Override
	public void initDefaultCommand() {
	}
}
