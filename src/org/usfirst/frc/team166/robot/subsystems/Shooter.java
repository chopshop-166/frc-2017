package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class Shooter extends Subsystem {
	Victor shooterMotor = new Victor(RobotMap.shooterMotor);

	@Override
	public void initDefaultCommand() {
	}

	double shooterMotorSpeed;

	public void start() {
		shooterMotor.set(Preferences.getInstance().getDouble(RobotMap.shooterMotorSpeed, 0.0));
	}

	public void stop() {
		shooterMotor.stopMotor();

	}

	public void shoot() {

	}
}
