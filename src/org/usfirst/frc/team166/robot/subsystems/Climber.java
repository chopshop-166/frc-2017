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

	public Climber() {
		climberMotor.setInverted(true);
	}

	@Override
	public void initDefaultCommand() {
	}

	public void climberOn() {
		climberMotor.set(Math.abs(Preferences.getInstance().getDouble(RobotMap.climberMotorSpeed, 0.0)));
	}

	public void climberOff() {
		climberMotor.stopMotor();
	}
}
