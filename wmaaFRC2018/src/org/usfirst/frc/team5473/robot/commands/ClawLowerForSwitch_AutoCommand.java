package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class ClawLowerForSwitch_AutoCommand extends TimedCommand{
	public ClawLowerForSwitch_AutoCommand(double seconds){
		//mainDrive.setExpiration(0.1);
		super(seconds);
		requires(Robot.claw);
	}
	
	@Override
	protected void execute(){
		Robot.claw.pivot(.5);
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.claw.stop();
	}
	
	@Override
	protected void interrupted(){
		end();
	}
}
