package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;
import org.usfirst.frc.team5473.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Power_Command extends Command{
	
	public Power_Command(){
		requires(Robot.driveTrain);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void execute(){
		//Robot.driveTrain.power(1);
	}
	
	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	@Override
	protected void interrupted(){
		end();
	}
}
