package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class Elevator extends Subsystem {

	Victor elevatorMotor = new Victor(RobotMap.elevatorMotor);

	@Override
	public void initDefaultCommand() {
	}

	double elevatorMotorSpeed;

	public void start() {
		elevatorMotorSpeed = Preferences.getInstance().getDouble(RobotMap.elevatorMotorSpeed, 0.0);
		elevatorMotor.set(elevatorMotorSpeed);
	}

	public void stop() {
		elevatorMotor.stopMotor();
	}
}
