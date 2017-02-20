package org.usfirst.frc.team166.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team166.robot.commands.Storage.RunAuger;

/**
 *
 */
public class ShooterCommandGroup extends CommandGroup {

	public ShooterCommandGroup() {
		addSequential(new RunShooter());
		addParallel(new RunAuger());
		addParallel(new ElevatorOn());

	}
}
