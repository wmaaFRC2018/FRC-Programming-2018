/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5473.robot.subsystems;

import org.usfirst.frc.team5473.robot.Robot;
import org.usfirst.frc.team5473.robot.commands.ArmMove_Command;
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
	private TalonSRX clawPivot = new TalonSRX(62);
	private VictorSP vroom = new VictorSP(4);
	private VictorSP vroom2 = new VictorSP(5);

	public Claw_Subsystem() {
		super();
		
		// Let's show everything on the LiveWindow
		/*LiveWindow.addActuator("Claw", "Motor", (Victor) motor);
		LiveWindow.addActuator("Claw", "Limit Switch", contact);*/
	}
	

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ClawVroom_Command());
	}

	public void log() {
	}

	/**
	 * Set the claw pivot motor to move in the direction indicated by the left joystick.
	 */
	public void pivot(double power) {
		clawPivot.set(ControlMode.PercentOutput, power);
	}

	//Make the claw motors spin inward to pull in cubes
	public void goVroomIn(double percentOutput){
		vroom.set(percentOutput);
		vroom2.set(-percentOutput);
	}
	
	//Make the claw motors spin outward to push out power cubes
	public void goVroomOut(double percentOutput){
		vroom.set(-percentOutput);
		vroom2.set(percentOutput);
	}
	
	//stop the claw spinning motors
	public void stopVroom(){
		vroom.set(0);
		vroom2.set(0);
	}
}
