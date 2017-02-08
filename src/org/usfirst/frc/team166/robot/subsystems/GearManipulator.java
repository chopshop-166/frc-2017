package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearManipulator extends Subsystem {

	DoubleSolenoid manipulatorSolenoid = new DoubleSolenoid(1, 2);

	@Override
	public void initDefaultCommand() {

	}

	public void open() {
		manipulatorSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void close() {
		manipulatorSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
}
