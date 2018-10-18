package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import External_Classes.Constants;
import edu.wpi.first.wpilibj.command.Command;

public class TurnToGyro_AutoCommand extends Command{
	private int direction;
	private boolean isFinished=false;

	public TurnToGyro_AutoCommand(int heading){
		this.direction=direction;
	}
	
	@Override
	protected void initialize(){
		//Robot.driveTrain.getPidgey().setYaw(0, Constants.kTimeoutMs);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isFinished;
	}
	
	@Override
	protected void execute(){
		Robot.driveTrain.setSetpoint(direction*90);
		isFinished=(Robot.driveTrain.onTarget())?true:false;
	}
	
	@Override
	protected void interrupted(){
		end();
	}
}
