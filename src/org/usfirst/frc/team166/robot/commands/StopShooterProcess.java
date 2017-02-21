package org.usfirst.frc.team166.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team166.robot.commands.Storage.AugerOff;

/**
 *
 */
public class StopShooterProcess extends CommandGroup {

	public StopShooterProcess() {
		addParallel(new AugerOff());
		addParallel(new ElevatorOff());
		addParallel(new ShooterOff());
	}
}
