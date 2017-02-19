package org.usfirst.frc.team166.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team166.robot.Robot;

/**
 *
 */
public class DriveDistance extends Command {
	double distance; // inches
	double speed; // motor power (for now)

	public DriveDistance(double desiredDistance, double desiredSpeed) {
		requires(Robot.drive);
		distance = Math.abs(desiredDistance);
		speed = desiredSpeed;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// Robot.drive.resetGyro();
		Robot.drive.resetEncoders();
		// Robot.drive.setMotorPower(speed, speed);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.driveStraight(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.drive.hasDrivenDistance(distance);
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
		end();
	}
}
