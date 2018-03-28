package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import External_Classes.CheesyDriveHelper;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class DriveForward_AutoCommand extends TimedCommand {
	CheesyDriveHelper signal = new CheesyDriveHelper();
	
	public DriveForward_AutoCommand(double seconds){
		//mainDrive.setExpiration(0.1);
		super(seconds);
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void execute(){
		Robot.driveTrain.power(signal.cheesyDrive(-0.25, 0, false));
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.driveTrain.power(signal.cheesyDrive(0, 0, false));
	}
	
	@Override
	protected void interrupted(){
		end();
	}
	
	
	
}
