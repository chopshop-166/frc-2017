package org.usfirst.frc.team166.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team166.robot.commands.Drive.DriveTime;
import org.usfirst.frc.team166.robot.commands.Drive.TurnAngle;
import org.usfirst.frc.team166.robot.commands.GearManipulator.UpManipulator;
import org.usfirst.frc.team166.robot.commands.GearManipulator.DownManipulator;

/**
 * USE ONLY IN THE CASE OF THERE NOT BEING ENCODERS ON THE ROBOT
 */
public class EmergencyTimeAutonomous extends CommandGroup {

	public EmergencyTimeAutonomous() {
		addSequential(new DriveTime(.386, 1.0));
		addSequential(new WaitCommand(1));
		addSequential(new DownManipulator());
		addSequential(new WaitCommand(1));
		addSequential(new DriveTime(.294, -1.0));
		addSequential(new UpManipulator());
		addSequential(new WaitCommand(1));
		addSequential(new TurnAngle(90));
		addSequential(new DriveTime(1, 1.0));
		addSequential(new TurnAngle(-90));
		addSequential(new DriveTime(.3, 1.0));
	}
}
