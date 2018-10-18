package org.usfirst.frc.team5473.robot.subsystems;

import org.usfirst.frc.team5473.robot.Robot;
import org.usfirst.frc.team5473.robot.RobotMap;
import org.usfirst.frc.team5473.robot.commands.ArmMove_Command;
import org.usfirst.frc.team5473.robot.commands.Drive_Command;
import org.usfirst.frc.team5473.robot.commands.Power_Command;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import External_Classes.Constants;
import External_Classes.DriveSignal;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm_Subsystem extends Subsystem{

	StringBuilder _sb = new StringBuilder();
	
	private TalonSRX armMotor = RobotMap.armMotor;
	
	public Arm_Subsystem(){
		super();
		/* first choose the sensor */
		armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		armMotor.setSensorPhase(true);
		armMotor.setInverted(false);
		// armMotor.configEncoderCodesPerRev(XXX)
		// armMotor.configPotentiometerTurns(XXX)
		
		/* set the peak and nominal outputs, 12V means full */
		armMotor.configNominalOutputForward(0, Constants.kTimeoutMs);
		armMotor.configNominalOutputReverse(0, Constants.kTimeoutMs);
		armMotor.configPeakOutputForward(1, Constants.kTimeoutMs);
		armMotor.configPeakOutputReverse(-1, Constants.kTimeoutMs);
		
		/* set closed loop gains in slot0 - see documentation */
		armMotor.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
		armMotor.config_kF(0, 1.04, Constants.kTimeoutMs);
		armMotor.config_kP(0, 0.2, Constants.kTimeoutMs);
		armMotor.config_kI(0, 0, Constants.kTimeoutMs);
		armMotor.config_kD(0, 0, Constants.kTimeoutMs);
		/* set acceleration and vcruise velocity - see documentation */
		armMotor.configMotionCruiseVelocity(983, Constants.kTimeoutMs);
		armMotor.configMotionAcceleration(983, Constants.kTimeoutMs);
		/* zero the sensor */
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ArmMove_Command());
	}
	
	public void move(){
		/* get gamepad axis - forward stick is positive */ 
		double rightTrigger = 1.0 * Robot.oi.getRightJoy().getRawAxis(1);
		
		/* Percent voltage mode */
		armMotor.set(ControlMode.PercentOutput, rightTrigger);
	}
	
	public void moveToPosition(double position){
		/* calculate the percent motor output */

		double motorOutput = Robot.arm.getArmMotor().getMotorOutputPercent();
		//double motorOutput = armMotor.getMotorOutputPercent();
		/* prepare line to print */

		
		/* Motion Magic - 4096 ticks/rev * 10 Rotations in either direction */
		double targetPos = position * 4096 * 10.0;
		Robot.arm.getArmMotor().set(ControlMode.MotionMagic, targetPos);
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
