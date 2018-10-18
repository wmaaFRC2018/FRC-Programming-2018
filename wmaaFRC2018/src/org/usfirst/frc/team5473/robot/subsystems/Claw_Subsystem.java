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
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import External_Classes.Constants;
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
public class Claw_Subsystem extends Subsystem {
	private TalonSRX clawPivot = RobotMap.clawPivot;
	
	public Claw_Subsystem() {
		super();
		
		/* first choose the sensor */
		clawPivot.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		clawPivot.setSensorPhase(true);
		clawPivot.setInverted(false);
		// clawPivot.configEncoderCodesPerRev(XXX)
		// clawPivot.configPotentiometerTurns(XXX)
		
		/* set the peak and nominal outputs, 12V means full */
		clawPivot.configNominalOutputForward(0, Constants.kTimeoutMs);
		clawPivot.configNominalOutputReverse(0, Constants.kTimeoutMs);
		clawPivot.configPeakOutputForward(.5, Constants.kTimeoutMs);
		clawPivot.configPeakOutputReverse(-.5, Constants.kTimeoutMs);
		
		/* set closed loop gains in slot0 - see documentation */
		clawPivot.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
		clawPivot.config_kF(0, 5.167, Constants.kTimeoutMs);
		clawPivot.config_kP(0, 0.2, Constants.kTimeoutMs);
		clawPivot.config_kI(0, 0, Constants.kTimeoutMs);
		clawPivot.config_kD(0, 0, Constants.kTimeoutMs);
		/* set acceleration and vcruise velocity - see documentation */
		clawPivot.configMotionCruiseVelocity(198, Constants.kTimeoutMs);
		clawPivot.configMotionAcceleration(198, Constants.kTimeoutMs);
		
		//clawPivot.setNeutralMode(brake));
		
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
	
	public void stop(){
		clawPivot.set(ControlMode.PercentOutput, 0);
	}

	public TalonSRX getClawMotor(){return clawPivot;}
}
