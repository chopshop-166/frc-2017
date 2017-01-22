package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearManipulator extends Subsystem {

	DoubleSolenoid exampleDouble = new DoubleSolenoid(1, 2);

	@Override
	public void initDefaultCommand() {

	}

	public void open() {
		exampleDouble.set(DoubleSolenoid.Value.kForward);
	}

	public void close() {
		exampleDouble.set(DoubleSolenoid.Value.kReverse);
	}
}
