package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class VisionProcessing extends Subsystem {

	NetworkTable networktable;

	// public double CenterPoint() {
	// return networktable.getDouble();
	// }

	public void NetworkTable() {
		networktable = NetworkTable.getTable("VisionDataTAble");
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
