package org.usfirst.frc.team166.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team166.robot.Robot;

/**
 *
 */
public class RunIntake extends Command {

	public RunIntake() {
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		Robot.intake.on();
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
