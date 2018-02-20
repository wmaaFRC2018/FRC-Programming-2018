package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import External_Classes.Constants;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmUp_AutoCommand extends Command{
	private double position;
	private boolean isFinished;
	
	public ArmUp_AutoCommand(double position){
		this.position=position;
	}
	
	@Override
	protected void initialize(){
		Robot.arm.getArmMotor().setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isFinished;
	}
	
	@Override
	protected void execute(){
		Robot.arm.moveToPosition(position);
		isFinished=false;
	}

	@Override
	protected void interrupted(){
		end();
	}
	
}