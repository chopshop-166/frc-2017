package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	// 2 states: on&off.
	// On has the needed engines pulling balls in
	// Off has those engines disabled
	//
	//
	SpeedController x;

	@Override
	public void initDefaultCommand() {

	}

	public void on() {
		x.set(.5);
	}

	public void off() {
		x.stopMotor();
	}
}
