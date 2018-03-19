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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The claw subsystem is a simple system with a motor for opening and closing.
 * If using stronger motors, you should probably use a sensor so that the motors
 * don't stall.
 */
public class Vroom_Subsystem extends Subsystem {
	private VictorSP vroom = RobotMap.vroom;
	private VictorSP vroom2 = RobotMap.vroom2;

	public Vroom_Subsystem() {
		super();
		
		// Let's show everything on the LiveWindow
		/*LiveWindow.addActuator("Claw", "Motor", (Victor) motor);
		LiveWindow.addActuator("Claw", "Limit Switch", contact);*/
	}
	

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ClawVroom_Command());
		//setDefaultCommand(new ClawUp_Command());
	}

	/**
	 * Set the claw pivot motor to move in the direction indicated by the left joystick.
	 */

	//Make the claw motors spin inward to pull in cubes
	public void goVroomIn(double percentOutput){
		vroom.set(percentOutput);
		vroom2.set(percentOutput);
	}
	
	//Make the claw motors spin outward to push out power cubes
	public void goVroomOut(double percentOutput){
		vroom.set(-percentOutput);
		vroom2.set(-percentOutput);
	}
	
	//stop the claw spinning motors
	public void stopVroom(){
		vroom.set(0);
		vroom2.set(0);
	}
	
	public void log(String key, double data){
		SmartDashboard.putNumber(key, data);
	}
}
