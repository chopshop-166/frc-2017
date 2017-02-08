package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class Intake extends Subsystem {
	// 2 states: on&off.
	// On has the needed engines pulling balls in
	// Off has those engines disabled
	//
	//

	Spark augerController = new Spark(RobotMap.augerMotor);

	@Override
	public void initDefaultCommand() {

	}

	public void on() {
		augerController.set(.5);
	}

	public void off() {
		augerController.stopMotor();
	}
}
