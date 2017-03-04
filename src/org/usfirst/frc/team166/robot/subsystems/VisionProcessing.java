package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionProcessing extends Subsystem {

	CameraServer Camera;

	public void runUsbCamera() {
		Camera.startAutomaticCapture();
		SmartDashboard.putData("CameraFeed", (Sendable) Camera.startAutomaticCapture());
	}

	public void StartServer() {
		Camera.addServer("cam0", 1);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
