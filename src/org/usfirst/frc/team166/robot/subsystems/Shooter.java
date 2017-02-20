package org.usfirst.frc.team166.robot.subsystems;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class Shooter extends Subsystem {
	Victor shooterMotor = new Victor(RobotMap.shooterMotor);

	Timer shooterTimer = new Timer();

	@Override
	public void initDefaultCommand() {
	}

	double shooterMotorSpeed;

	public void shooterOn() {
		shooterMotorSpeed = Preferences.getInstance().getDouble(RobotMap.shooterMotorSpeed, 0.0);
		shooterMotor.set(shooterMotorSpeed);

		shooterTimer.start();
	}

	public void stopShooter() {
		shooterMotor.stopMotor();

		shooterTimer.stop();
		shooterTimer.reset();
	}

	public boolean hasRunFor(double amountOfTime) {
		double shooterTime = shooterTimer.get();

		return (shooterTime > amountOfTime);
	}
}
