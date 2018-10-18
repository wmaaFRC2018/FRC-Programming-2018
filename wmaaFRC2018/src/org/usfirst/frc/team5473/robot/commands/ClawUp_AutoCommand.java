package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import External_Classes.CheesyDriveHelper;
import edu.wpi.first.wpilibj.command.Command;

public class ClawUp_AutoCommand extends Command {
	private boolean isFinished;
	
	CheesyDriveHelper signal = new CheesyDriveHelper();
	private double rotations;
	
	public ClawUp_AutoCommand(double rotations){
		this.rotations = rotations;
		//mainDrive.setExpiration(0.1);
		requires(Robot.claw);
	}
	
	@Override
	protected void execute() {
		Robot.claw.autoPivot(rotations);
		isFinished = Robot.claw.getClawMotor().getClosedLoopError(0)<100;
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub5
		return isFinished;
	}
	
	@Override
	protected void interrupted(){
		end();
	}

}
