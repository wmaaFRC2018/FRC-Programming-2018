package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;
import org.usfirst.frc.team5473.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Drive_Command extends Command{
	public Drive_Command(){
		requires(Robot.driveTrain);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void execute(){
		RobotMap.sparkF_L.set(Robot.oi.getJoystick().getY());
	}

	@Override
	protected void interrupted(){
		end();
	}
}
