package org.usfirst.frc.team166.robot.subsystems;

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

	public void climberOn() {
		climberMotor.set(-0.8);
	}

	public void climberOff() {
		climberMotor.stopMotor();
	}
}
