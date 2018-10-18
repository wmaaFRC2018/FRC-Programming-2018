package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import External_Classes.Constants;
import edu.wpi.first.wpilibj.command.Command;

public class Turn90_AutoCommand extends Command{
	private int direction;
	private boolean isFinished=false;
	
	public Turn90_AutoCommand(int direction){
		this.direction=direction;
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void initialize(){
		Robot.driveTrain.getPidgey().setYaw(0, Constants.kTimeoutMs);
		Robot.driveTrain.enable();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if(isFinished){
			Robot.driveTrain.disable();
			return true;
		}else
			return false;
	}
	
	@Override
	protected void execute(){
		Robot.driveTrain.setSetpoint(direction*90);
		isFinished=(Robot.driveTrain.onTarget());
	}
	
	@Override
	protected void interrupted(){
		Robot.driveTrain.disable();
		end();
	}

}
