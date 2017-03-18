package org.usfirst.frc.team166.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team166.robot.RobotMap;
import org.usfirst.frc.team166.robot.commands.DriveStraightAuto;
import org.usfirst.frc.team166.robot.commands.TurnAngle;
import org.usfirst.frc.team166.robot.commands.GearManipulator.UpManipulator;
import org.usfirst.frc.team166.robot.commands.GearManipulator.DownManipulator;

/**
 *
 */
public class BoilerSideRedAuto extends CommandGroup {

	double centerGearAutoSpeed = Preferences.getInstance().getDouble(RobotMap.centerGearAutoSpeed, 0.0);
	double LeftGearAutoDist = Preferences.getInstance().getDouble(RobotMap.LeftGearAutoDist, 0.0);
	double autoWaitTime = Preferences.getInstance().getDouble(RobotMap.autoWaitTime, 0.0);
	double driveToAngledPegDistance = Preferences.getInstance().getDouble(RobotMap.driveToAngledPegDistance, 0.0);

	public BoilerSideRedAuto() {
		addSequential(new DriveStraightAuto(LeftGearAutoDist, centerGearAutoSpeed));
		addSequential(new TurnAngle(-45));
		addSequential(new WaitCommand(autoWaitTime));
		addSequential(new DriveStraightAuto(driveToAngledPegDistance, centerGearAutoSpeed));
		addSequential(new DownManipulator());
		addSequential(new DriveStraightAuto(driveToAngledPegDistance - 10, -centerGearAutoSpeed));
		addSequential(new UpManipulator());
	}
}
