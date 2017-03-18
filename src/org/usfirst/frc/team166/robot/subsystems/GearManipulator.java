package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class GearManipulator extends Subsystem {

	DoubleSolenoid manipulatorSolenoid = new DoubleSolenoid(RobotMap.forwardSolenoid, RobotMap.reverseSolenoid);
	Victor manipulatorMotor = new Victor(RobotMap.manipulatorMotor);

	@Override
	public void initDefaultCommand() {

	}

	public void gearManipulatorDown() {
		manipulatorSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void gearManipulatorUp() {
		manipulatorSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void manipulatorMotorOn() {
		manipulatorMotor.set(0.5);
	}

	public void manipulatorMotorReverse() {
		manipulatorMotor.set(-0.25);
	}

	public void manipulatorMotorOff() {
		manipulatorMotor.set(0.0);
	}

	public void toggleManipulator() {
		Value solenoidVal = manipulatorSolenoid.get();
		if (solenoidVal == Value.kForward) {
			manipulatorSolenoid.set(DoubleSolenoid.Value.kReverse);
			manipulatorMotor.set(0.0);
		} else {
			manipulatorSolenoid.set(DoubleSolenoid.Value.kForward);
			manipulatorMotor.set(0.5);
		}

	}

}
