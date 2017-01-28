package org.usfirst.frc.team166.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name. This provides
 * flexibility changing wiring, makes checking the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Solenoids

	// Motor Controllers
	public static int frontRightMotor = 0;
	public static int frontLeftMotor = 1;
	public static int rearRightMotor = 2;
	public static int rearLeftMotor = 3;

	// Analog Sensors
	public static int gyroPort = 0;

	// Digital Sensors

	// Encoders
	public static int rightEncoderA = 0;
	public static int rightEncoderB = 0;
	public static int leftEncoderA = 0;
	public static int leftEncoderB = 0;

	// Joysticks
	public static int stickLeft = 0;
	public static int stickRight = 1;

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
