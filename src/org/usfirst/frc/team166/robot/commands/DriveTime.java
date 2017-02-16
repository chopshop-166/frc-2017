package org.usfirst.frc.team166.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team166.robot.Robot;

/**
 *
 */
public class DriveTime extends Command {
	double time; // seconds
	double speed; // motor power (for now)
	Timer timer;

	public DriveTime(double desiredTime, double desiredSpeed) {
		requires(Robot.drive);
		time = desiredTime;
		speed = desiredSpeed;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drive.resetGyro();
		timer = new Timer();
		timer.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.driveStraight(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		// return Robot.drive.hasDrivenDistance(time);
		return (timer.get() >= time);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drive.stopMotors();
		timer.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.drive.stopMotors();
	}
}
