package org.usfirst.frc.team166.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team166.robot.commands.DriveDistance;
import org.usfirst.frc.team166.robot.commands.DriveStraightGyro;
import org.usfirst.frc.team166.robot.commands.Autonomous.CenterGearAutonomous;
import org.usfirst.frc.team166.robot.commands.Climber.ClimberOn;
import org.usfirst.frc.team166.robot.commands.GearManipulator.CloseManipulator;
import org.usfirst.frc.team166.robot.commands.GearManipulator.ToggleGearManip;
import org.usfirst.frc.team166.robot.commands.Intake.RunIntake;
import org.usfirst.frc.team166.robot.commands.Shooter.ShooterCommandGroup;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups
 * that allow control of the robot.
 */
public class OI {

	private final Joystick stickLeft = new Joystick(RobotMap.stickLeft);
	private final Joystick stickRight = new Joystick(RobotMap.stickRight);

	// private final Joystick xbox = new Joystick(RobotMap.xboxPort);;
	private final XboxController xbox = new XboxController(RobotMap.xboxPort);

	public OI() {

		// SmartDashboard.putData(new OpenManipulator());
		// SmartDashboard.putData(new CloseManipulator());
		SmartDashboard.putData(new ToggleGearManip());
		SmartDashboard.putData(new ClimberOn());
		SmartDashboard.putData(new RunIntake());
		SmartDashboard.putData(new ShooterCommandGroup());
		double speed = Preferences.getInstance().getDouble(RobotMap.desiredSpeed, 0.0);
		double distance = Preferences.getInstance().getDouble(RobotMap.desiredDistance, 0.0);
		SmartDashboard.putData(new DriveDistance(distance, speed));

		SmartDashboard.putData(new CenterGearAutonomous());

		SmartDashboard.putData(new CloseManipulator());

		SmartDashboard.putData(new DriveStraightGyro());

		JoystickButton leftJoyTrigger = new JoystickButton(stickLeft, 1);
		JoystickButton button2Left = new JoystickButton(stickLeft, 2);
		JoystickButton button3Left = new JoystickButton(stickLeft, 3);
		JoystickButton button4Left = new JoystickButton(stickLeft, 4);
		JoystickButton button5Left = new JoystickButton(stickLeft, 5);
		JoystickButton button6Left = new JoystickButton(stickLeft, 6);
		JoystickButton button7Left = new JoystickButton(stickLeft, 7);
		JoystickButton button8Left = new JoystickButton(stickLeft, 8);
		JoystickButton button9Left = new JoystickButton(stickLeft, 9);
		JoystickButton button10Left = new JoystickButton(stickLeft, 10);
		JoystickButton button11Left = new JoystickButton(stickLeft, 11);

		JoystickButton rightJoyTrigger = new JoystickButton(stickRight, 1);
		JoystickButton button2Right = new JoystickButton(stickRight, 2);
		JoystickButton button3Right = new JoystickButton(stickRight, 3);
		JoystickButton button4Right = new JoystickButton(stickRight, 4);
		JoystickButton button5Right = new JoystickButton(stickRight, 5);
		JoystickButton button6Right = new JoystickButton(stickRight, 6);
		JoystickButton button7Right = new JoystickButton(stickRight, 7);
		JoystickButton button8Right = new JoystickButton(stickRight, 8);
		JoystickButton button9Right = new JoystickButton(stickRight, 9);
		JoystickButton button10Right = new JoystickButton(stickRight, 10);
		JoystickButton button11Right = new JoystickButton(stickRight, 11);

		JoystickButton buttonA = new JoystickButton(xbox, 1);
		JoystickButton buttonB = new JoystickButton(xbox, 2);
		JoystickButton buttonX = new JoystickButton(xbox, 3);
		JoystickButton buttonY = new JoystickButton(xbox, 4);

		JoystickButton leftButton = new JoystickButton(xbox, 5);
		JoystickButton rightButton = new JoystickButton(xbox, 6);

		JoystickButton back = new JoystickButton(xbox, 7);
		JoystickButton start = new JoystickButton(xbox, 8);

		JoystickButton leftJoyXboxButton = new JoystickButton(xbox, 9);
		JoystickButton rightJoyXboxButton = new JoystickButton(xbox, 10);

		// Xbox commands

		buttonA.whenPressed(new ToggleGearManip());
		buttonX.whileHeld(new ClimberOn());
		buttonB.whileHeld(new ShooterCommandGroup());
		// Double joystick commands

		rightJoyTrigger.whileHeld(new RunIntake());
		leftJoyTrigger.whenPressed(new DriveStraightGyro());
	}

	public double getLeftY() {
		return -stickLeft.getY();
	}

	// public double getLeftX() {
	// return stickLeft.getX();
	// }

	public double getRightY() {
		return -stickRight.getY();
	}

	public double getCopilotLeftTrigger() {
		return xbox.getRawAxis(1);
	}

	public double getCopilotRightTrigger() {
		return xbox.getRawAxis(2);
	}

	// public double getRightX() {
	// return stickRight.getX();
	// }
}
