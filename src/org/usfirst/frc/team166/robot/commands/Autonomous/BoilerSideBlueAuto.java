package org.usfirst.frc.team166.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team166.robot.RobotMap;
import org.usfirst.frc.team166.robot.commands.DriveStraightAuto;
import org.usfirst.frc.team166.robot.commands.TurnAngle;

/**
 *
 */
public class BoilerSideBlueAuto extends CommandGroup {

	double centerGearAutoSpeed = Preferences.getInstance().getDouble(RobotMap.centerGearAutoSpeed, 0.0);
	double LeftGearAutoDist = Preferences.getInstance().getDouble(RobotMap.LeftGearAutoDist, 0.0);
	double autoWaitTime = Preferences.getInstance().getDouble(RobotMap.autoWaitTime, 0.0);

	public BoilerSideBlueAuto() {
		addSequential(new DriveStraightAuto(LeftGearAutoDist, centerGearAutoSpeed));
		addSequential(new TurnAngle(300));
		double driveToAngledPegDistance = Preferences.getInstance().getDouble(RobotMap.driveToAngledPegDistance, 0.0);
		addSequential(new DriveStraightAuto(driveToAngledPegDistance, 0.5));
		addSequential(new DriveStraightAuto(driveToAngledPegDistance - 10, 0.5));
	}
}
