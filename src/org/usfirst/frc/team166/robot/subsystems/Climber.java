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

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	@Override
	public void initDefaultCommand() {

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	double climberMotorSpeed;

	public void climberOn() {
		climberMotorSpeed = Preferences.getInstance().getDouble(RobotMap.climberMotorSpeed, 0.0);
	}

	public void climberOff() {
		climberMotor.stopMotor();
	}
}
