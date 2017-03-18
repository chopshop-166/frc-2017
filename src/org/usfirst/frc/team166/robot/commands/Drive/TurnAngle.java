package org.usfirst.frc.team166.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team166.robot.Robot;

/**
 * DO NOT USE; I DON'T THINK IT CURRENTLY WORKS!!
 */
public class TurnAngle extends Command {

	double angle;

	public TurnAngle(double desiredAngle) {
		requires(Robot.drive);
		angle = desiredAngle;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drive.resetGyro();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (angle < 0) {
			Robot.drive.turnRight(.5);
		} else {
			Robot.drive.turnLeft(.5);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (Math.abs(Robot.drive.angleError()) > (Math.abs(angle) - 1)
				&& Math.abs(Robot.drive.angleError()) < (Math.abs(angle) + 1));
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drive.stopMotors();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.drive.stopMotors();
	}
}
