package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	// Victor elevatorMotor = new Victor(RobotMap.elevatorMotor);

	@Override
	public void initDefaultCommand() {
	}

	// double elevatorMotorSpeed;

	public void start() {
		// elevatorMotorSpeed = Preferences.getInstance().getDouble(RobotMap.elevatorMotorSpeed, 0.0);
		// elevatorMotor.set(elevatorMotorSpeed);
	}

	public void stop() {
		// elevatorMotor.stopMotor();
	}
}
