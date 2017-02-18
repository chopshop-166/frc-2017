package org.usfirst.frc.team166.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name. This provides
 * flexibility changing wiring, makes checking the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Solenoids
	public static int forwardSolenoid = 1;
	public static int reverseSolenoid = 0;
	// Motor Controllers

	// CAN[1] is right side and negative is forward
	public static int frontRightMotor = 1;
	// CAN[4] is right side and negative is forward
	public static int rearRigthMotor = 4;

	// CAN[3] is left side and positive is forward
	public static int frontLeftMotor = 3;
	// CAN[2] is left side and positive is forward
	public static int rearLeftMotor = 2;

	public static int augerMotor = 5;
	public static int climberMotor = 0;
	public static int intakeMotor = 3;
	// Analog Sensors
	public static int gyroPort = 0;

	// Digital Sensors

	// Encoders
	public static int rightEncoderA = 1;
	public static int rightEncoderB = 2;
	public static int leftEncoderA = 3;
	public static int leftEncoderB = 4;

	// Joysticks
	public static int stickLeft = 0;
	public static int stickRight = 1;
	public static int xboxPort = 2;

	// Preferences
	public static String intakeControllerSpeed = "IntakeControllerSpeed";
	public static String climberMotorSpeed = "ClimberMotorSpeed";
	public static String augerMotorSpeed = "AugerMotorSpeed";
	public static String wheelDiameter = "WheelDiameter";

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
