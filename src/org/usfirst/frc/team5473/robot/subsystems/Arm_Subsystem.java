package org.usfirst.frc.team5473.robot.subsystems;

import org.usfirst.frc.team5473.robot.Robot;
import org.usfirst.frc.team5473.robot.RobotMap;
import org.usfirst.frc.team5473.robot.commands.ArmMove_Command;
import org.usfirst.frc.team5473.robot.commands.Drive_Command;
import org.usfirst.frc.team5473.robot.commands.Power_Command;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import External_Classes.DriveSignal;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm_Subsystem extends Subsystem{

	StringBuilder _sb = new StringBuilder();
	
	private TalonSRX armMotor = RobotMap.armMotor;
	
	public Arm_Subsystem(){
		super();
		armMotor.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		armMotor.setSensorPhase(false);
		armMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ArmMove_Command());
	}
	
	public void move(){
		/* get gamepad axis - forward stick is positive */ 
		double rightTrigger = 1.0 * Robot.oi.getRightJoy().getRawAxis(1);
		/* calculate the percent motor output */
		//double motorOutput = armMotor.getMotorOutputPercent();
		/* prepare line to print */

		if (Robot.oi.getRightJoy().getRawButton(2)) {
			/* Motion Magic - 4096 ticks/rev * 10 Rotations in either direction */
			double targetPos = rightTrigger * 4096 * 10.0;
			armMotor.set(ControlMode.MotionMagic, targetPos);

		} else {
			/* Percent voltage mode */
			armMotor.set(ControlMode.PercentOutput, rightTrigger);
		}
		
	}
	
	//use this stuff to copy/paste what you need to communicate to CTRE motor controllers
	public void learningPLeaseIgnore(){
		/* Talon Direction has been inverted */
		//armMotor.set
		
		/* Displaying the two neutral mode options that both the Talon and Victor have */
		/*armMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
		armMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);*/
		
		/* The following java example limits the current to 10 amps whenever the current has exceeded 15 amps for 100 Ms */
		/*armMotor.configContinuousCurrentLimit(10, 0);
		armMotor.configPeakCurrentLimit(15, 0);
		armMotor.configPeakCurrentDuration(100, 0);
		armMotor.enableCurrentLimit(true);*/
		
		/* Talon is configured to ramp from neutral to full within 2 seconds, and followers are configured to 0*/
		// *leftMaster*.configOpenloopRamp(2, 0);
		// *leftFollower*.configOpenloopRamp(0, 0); /* no need since master ramps */
		// *rightMaster*.configOpenloopRamp(2, 0);
		// *rightFollower*.configOpenloopRamp(0, 0); /* no need since master ramps */
		
		/* The first line, we have a Victor following a Talon. The follow() function may also be used to create Talon follower for a Victor */
		//victorFollower.follow(Hardware.TalonMaster);
		/* In the second line, we have a Talon following Talon. The set(ControlMode.Follower, MotorcontrollerID) creates followers of the same model. */
		//talonFollower.set(com.ctre.phoenix.motorcontrol.ControlMode.Follower, 6);
	}
	
	public TalonSRX getArmMotor(){return armMotor;}
}
