package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class XboxLeftTrigger extends Trigger {

	@Override
	public boolean get() {
		return true; // (Math.abs(Robot.oi.getCopilotLeftTrigger()) >=.1);
	}
}
