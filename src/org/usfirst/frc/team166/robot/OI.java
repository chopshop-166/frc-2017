package org.usfirst.frc.team166.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team166.robot.commands.DriveDistance;
import org.usfirst.frc.team166.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team166.robot.commands.DriveWithJoysticksReversed;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups
 * that allow control of the robot.
 */
public class OI {

	private final boolean isReversed;

	private final Joystick stickLeft;
	private final Joystick stickRight;

	private final Joystick xbox;

	public OI() {
		isReversed = false;
		stickLeft = new Joystick(RobotMap.stickLeft);
		stickRight = new Joystick(RobotMap.stickRight);

		xbox = new Joystick(0);

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

		buttonA.whenPressed(new DriveDistance(31.4, 0.5));

		if (!isReversed)
			rightJoyTrigger.whenPressed(new DriveWithJoysticksReversed());
		else
			rightJoyTrigger.whenPressed(new DriveWithJoysticks());
	}

	public double getLeftY() {
		return stickLeft.getY();
	}

	// public double getLeftX() {
	// return stickLeft.getX();
	// }

	public double getRightY() {
		return stickRight.getY();
	}

	// public double getRightX() {
	// return stickRight.getX();
	// }
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
