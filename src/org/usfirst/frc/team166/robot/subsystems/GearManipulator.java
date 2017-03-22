package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class GearManipulator extends Subsystem {

	DoubleSolenoid manipulatorSolenoid = new DoubleSolenoid(RobotMap.forwardSolenoid, RobotMap.reverseSolenoid);
	Victor manipulatorMotor = new Victor(RobotMap.manipulatorMotor);
	AnalogInput IrSensor = new AnalogInput(RobotMap.irSensor);

	@Override
	public void initDefaultCommand() {
		SmartDashboard.putNumber("Ir Value", IrSensor.getVoltage());

	}

	public double IrValue() {
		return IrSensor.getValue();
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
		Double IRValue = IrSensor.getVoltage();
		if (solenoidVal == Value.kForward) {
			manipulatorSolenoid.set(DoubleSolenoid.Value.kReverse);
			manipulatorMotor.set(0.0);
		} else {
			manipulatorSolenoid.set(DoubleSolenoid.Value.kForward);
			manipulatorMotor.set(0.5);
		}

	}

}
