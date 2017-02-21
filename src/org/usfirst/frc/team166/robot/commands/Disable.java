package org.usfirst.frc.team166.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team166.robot.Robot;

/**
 *
 */
public class Disable extends CommandGroup {

	public Disable() {
		requires(Robot.intake);
		requires(Robot.gearManipulator);
		requires(Robot.storage);
		requires(Robot.elevator);
		requires(Robot.drive);
		requires(Robot.climber);
		requires(Robot.elevator);
		requires(Robot.shooter);
	}
}
