package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClawUp_Command extends Command{

	public ClawUp_Command(){
		//mainDrive.setExpiration(0.1);
		requires(Robot.claw);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void execute(){
		//RobotMap.sparkF_L.set(Robot.oi.getJoystick().getY());
		//RobotMap.sparkF_L.set(Robot.oi.getJoystick().getY());
		
		/*mainDrive.setSafetyEnabled(true);
		mainDrive.tankDrive(leftStick, rightStick);
		Timer.delay(0.005); // wait for a motor update time*/
		
		Robot.claw.pivot(Robot.oi.getRightJoy().getRawAxis(0));
	}
	
	@Override
	protected void interrupted(){
		end();
	}

}
