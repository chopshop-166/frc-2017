package org.usfirst.frc.team166.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team166.robot.RobotMap;
import org.usfirst.frc.team166.robot.commands.DriveDistance;
import org.usfirst.frc.team166.robot.commands.GearManipulator.OpenManipulator;

/**
 *
 */
public class CenterGearAutonomous extends CommandGroup {

	public CenterGearAutonomous() {

		double centerGearAutoSpeed = Preferences.getInstance().getDouble(RobotMap.centerGearAutoSpeed, 0.0);
		double centerGearAutoDistance = Preferences.getInstance().getDouble(RobotMap.centerGearAutoDistance, 0.0);
		double autoWaitTime = Preferences.getInstance().getDouble(RobotMap.autoWaitTime, 0.0);

		addSequential(new DriveStraightAuto(centerGearAutoDistance, centerGearAutoSpeed));
		addSequential(new WaitCommand(autoWaitTime));
		addSequential(new OpenManipulator());

		double autoWaitTime2 = Preferences.getInstance().getDouble(RobotMap.autoWaitTime2, 0.0);
		addSequential(new WaitCommand(autoWaitTime2));
		double centerGearAutoDistanceBackwards = Preferences.getInstance()
				.getDouble(RobotMap.centerGearAutoDistanceBackwards, 0.0);
		addSequential(new DriveDistance(centerGearAutoDistanceBackwards, -0.25));
	}
}
