package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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

	public void togglesGearmanip() {
		Value solenoidVal = manipulatorSolenoid.get();
		if (solenoidVal == Value.kForward) {
			manipulatorSolenoid.set(DoubleSolenoid.Value.kReverse);
		} else {
			manipulatorSolenoid.set(DoubleSolenoid.Value.kForward);
		}

	}
}
