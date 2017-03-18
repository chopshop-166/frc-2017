package org.usfirst.frc.team166.robot.commands.Climber;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team166.robot.Robot;

/**
 *
 */
public class ClimberTriggerOn extends Command {

	public ClimberTriggerOn() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.climber);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.climber.climbWithTrigger();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.oi.getCopilotLeftTrigger() <= .1;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.climber.climberOff();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.climber.climberOff();
	}
}
