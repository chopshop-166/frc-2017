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
public class CenterGearAutonomous extends CommandGroup {

	public CenterGearAutonomous() {

		double centerGearAutoSpeed = Preferences.getInstance().getDouble(RobotMap.centerGearAutoSpeed, 0.0);
		double centerGearAutoDistance = Preferences.getInstance().getDouble(RobotMap.centerGearAutoDistance, 0.0);
		double autoWaitTime = Preferences.getInstance().getDouble(RobotMap.autoWaitTime, 0.0);
		double wiggleForward = Preferences.getInstance().getDouble(RobotMap.wiggleForward, 0.0);

		addSequential(new DriveStraightAuto(centerGearAutoDistance, centerGearAutoSpeed));
		addSequential(new TurnAngle(3));
		addSequential(new TurnAngle(-6));
		addSequential(new TurnAngle(3));
		addSequential(new DriveStraightAuto(wiggleForward, centerGearAutoSpeed));
		addSequential(new WaitCommand(autoWaitTime));
		addSequential(new DownManipulator());
		// addSequential(new WaitCommand(autoWaitTime));
		addSequential(new DriveStraightAuto(centerGearAutoDistance / 2, -centerGearAutoSpeed));
		addSequential(new WaitCommand(autoWaitTime / 2));
		addSequential(new DriveStraightAuto(centerGearAutoDistance / 3, centerGearAutoSpeed));
		addSequential(new UpManipulator());
	}
}
