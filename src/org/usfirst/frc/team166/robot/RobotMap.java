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
	public static int shooterMotor = 1;
	public static int elevatorMotor = 2;
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
	public static String intakeControllerSpeed = "Intake Controller Speed";
	public static String climberMotorSpeed = "Climber Motor Speed";
	public static String augerMotorSpeed = "Auger Motor Speed";
	public static String shooterMotorSpeed = "Shooter Speed";
}
