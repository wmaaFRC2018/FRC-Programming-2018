package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import External_Classes.Constants;
import edu.wpi.first.wpilibj.command.Command;

public class Turn90_AutoCommand extends Command{
	private int direction;
	
	public Turn90_AutoCommand(int direction){
		this.direction=direction;
	}
	
	@Override
	protected void initialize(){
		Robot.driveTrain.getPidgey().setYaw(0, Constants.kTimeoutMs);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void execute(){
		Robot.driveTrain.setSetpoint(direction*90);
	}
	
	@Override
	protected void interrupted(){
		end();
	}

}
