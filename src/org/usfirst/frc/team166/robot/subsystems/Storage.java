package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Storage extends Subsystem {

	Victor exampleVictor = new Victor(11);

	@Override
	public void initDefaultCommand() {
	}

	public void agitatorOn() {
		exampleVictor.set(Preferences.getInstance().getDouble("Forward", 1.0));

	}

	public void agitatorOff() {
		exampleVictor.set(0.0);
	}
}
