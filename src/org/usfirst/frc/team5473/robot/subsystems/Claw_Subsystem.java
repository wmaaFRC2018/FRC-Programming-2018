/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5473.robot.subsystems;

import org.usfirst.frc.team5473.robot.Robot;
import org.usfirst.frc.team5473.robot.RobotMap;
import org.usfirst.frc.team5473.robot.commands.ArmMove_Command;
import org.usfirst.frc.team5473.robot.commands.ClawUp_Command;
import org.usfirst.frc.team5473.robot.commands.ClawVroom_Command;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The claw subsystem is a simple system with a motor for opening and closing.
 * If using stronger motors, you should probably use a sensor so that the motors
 * don't stall.
 */
public class Claw_Subsystem extends Subsystem {
	private TalonSRX clawPivot = RobotMap.clawPivot;
	
	public Claw_Subsystem() {
		super();
		
		// Let's show everything on the LiveWindow
		/*LiveWindow.addActuator("Claw", "Motor", (Victor) motor);
		LiveWindow.addActuator("Claw", "Limit Switch", contact);*/
	}
	

	@Override
	public void initDefaultCommand() {

		setDefaultCommand(new ClawUp_Command());

		//setDefaultCommand(new ClawVroom_Command());

		//setDefaultCommand(new ClawUp_Command());
	}

	public void log() {
	}

	/**
	 * Set the claw pivot motor to move in the direction indicated by the left joystick.
	 */
	public void pivot(double power) {
		clawPivot.set(ControlMode.PercentOutput, power);
	}
	
	
	public void autoPivot(double rotations) {
		double targetPos = 4096 * rotations;
		clawPivot.set(ControlMode.MotionMagic, targetPos);
	}

}
