package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.Preferences;
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

	Spark intakeController = new Spark(RobotMap.intakeMotor);

	@Override
	public void initDefaultCommand() {

	}

	double intakeControllerSpeed;

	public void on() {
		intakeControllerSpeed = Preferences.getInstance().getDouble(RobotMap.intakeControllerSpeed, 0.0);
		intakeController.set(intakeControllerSpeed);
	}

	public void off() {
		intakeController.stopMotor();
	}
}
