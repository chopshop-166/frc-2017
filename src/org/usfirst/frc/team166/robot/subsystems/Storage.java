package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class Storage extends Subsystem {

	Victor augerMotor = new Victor(RobotMap.augerMotor);

	@Override
	public void initDefaultCommand() {
	}

	public void agitatorOn() {

		double augerMotorSpeed;

		augerMotorSpeed = Preferences.getInstance().getDouble(RobotMap.augerMotorSpeed, 0); // TODO set Preference to
																							// 0.8

		augerMotor.set(Math.abs(augerMotorSpeed));
	}

	public void agitatorOff() {
		augerMotor.stopMotor();
	}
}
