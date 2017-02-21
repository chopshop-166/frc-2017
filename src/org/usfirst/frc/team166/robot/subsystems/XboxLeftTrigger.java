package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team166.robot.Robot;

/**
 *
 */
public class XboxLeftTrigger extends Trigger {

	@Override
	public boolean get() {
		return (Math.abs(Robot.oi.getCopilotLeftTrigger()) > .75);
	}
}
