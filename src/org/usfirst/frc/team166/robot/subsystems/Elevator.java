package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class Elevator extends Subsystem {

	Victor ElevatorMotor = new Victor(RobotMap.elevatorMotor);

	@Override
	public void initDefaultCommand() {

	}

	public void start() {

		ElevatorMotor.set(.8);

	}

	public void stop() {

		ElevatorMotor.set(0);

	}
}
