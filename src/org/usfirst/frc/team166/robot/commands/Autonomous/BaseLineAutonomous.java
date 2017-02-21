package org.usfirst.frc.team166.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team166.robot.RobotMap;
import org.usfirst.frc.team166.robot.commands.DriveDistance;

/**
 *
 */
public class BaseLineAutonomous extends CommandGroup {

	public BaseLineAutonomous() {

		double baseLineDistance = Preferences.getInstance().getDouble(RobotMap.baseLineDistance, 0.0);
		double baseLineSpeed = Preferences.getInstance().getDouble(RobotMap.baseLineSpeed, 0.0);

		addSequential(new DriveDistance(baseLineDistance, baseLineSpeed));

	}
}
