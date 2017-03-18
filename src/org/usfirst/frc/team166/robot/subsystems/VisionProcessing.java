package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VisionProcessing extends Subsystem {

	UsbCamera cam0;

	public void runUsbCamera() {
		cam0 = CameraServer.getInstance().startAutomaticCapture();
	}

	public void StartServer() {

	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
