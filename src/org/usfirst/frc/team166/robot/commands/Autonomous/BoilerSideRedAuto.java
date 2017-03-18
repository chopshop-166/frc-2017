package org.usfirst.frc.team166.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team166.robot.RobotMap;
import org.usfirst.frc.team166.robot.commands.Drive.DriveDistance;
import org.usfirst.frc.team166.robot.commands.Drive.DriveStraightAuto;
import org.usfirst.frc.team166.robot.commands.Drive.TurnAngle;

/**
 *
 */
public class BoilerSideRedAuto extends CommandGroup {

	public BoilerSideRedAuto() {

		addSequential(new DriveDistance(120, 0.5));
		addSequential(new TurnAngle(-60));
		double driveToAngledPegDistance = Preferences.getInstance().getDouble(RobotMap.driveToAngledPegDistance, 0.0);
		addSequential(new DriveStraightAuto(driveToAngledPegDistance, 0.5));
		addSequential(new DriveStraightAuto(driveToAngledPegDistance - 10, 0.5));
	}
}
