package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class Climber extends Subsystem {
	Victor climberMotor = new Victor(RobotMap.climberMotor);

	@Override
	public void initDefaultCommand() {
	}

	double climberMotorSpeed;

	public void climberOn() {
		climberMotorSpeed = Preferences.getInstance().getDouble(RobotMap.climberMotorSpeed, 0.0);
		climberMotor.set(climberMotorSpeed);
	}

	public void climberOff() {
		climberMotor.stopMotor();
	}
}
