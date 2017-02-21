package org.usfirst.frc.team166.robot.commands;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team166.robot.Robot;

/**
 *
 */
public class DriveStraightGyro extends Command {
	double distance = Preferences.getInstance().getDouble("Distance driven with gyro", 0.0);
	double power = Preferences.getInstance().getDouble("Speed to drive with gyro", 0.0);

	public DriveStraightGyro(/* double desiredDistance, double desiredPower */) {
		requires(Robot.drive);
		// distance = desiredDistance;
		// power = desiredPower;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drive.resetGyro();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.driveStraightGyro(power);
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
