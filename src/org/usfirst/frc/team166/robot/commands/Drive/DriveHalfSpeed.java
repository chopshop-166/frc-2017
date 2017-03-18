package org.usfirst.frc.team166.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team166.robot.Robot;

/**
 *
 */
public class DriveHalfSpeed extends Command {

	public DriveHalfSpeed() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.driveHalfSpeed(Robot.oi.getRightY() / 2, Robot.oi.getLeftY() / 2);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
