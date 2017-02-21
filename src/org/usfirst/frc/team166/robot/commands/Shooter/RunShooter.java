package org.usfirst.frc.team166.robot.commands.Shooter;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team166.robot.Robot;

/**
 *
 */
public class RunShooter extends Command {

	public RunShooter() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	@Override
	protected void initialize() {
		Robot.shooter.shooterOn();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return Robot.shooter.hasRunFor(5.0);
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {
	}
}
