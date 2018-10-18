package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import External_Classes.CheesyDriveHelper;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class SolenoidOut_AutoCommand extends TimedCommand {
	CheesyDriveHelper signal = new CheesyDriveHelper();
	
	public SolenoidOut_AutoCommand(double time) {
		super(time);
		requires(Robot.pshuk);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void execute(){
		//extend solenoids
		Robot.pshuk.extend();
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
		//Set solenoids to default non extended state
		Robot.pshuk.retract();
	}

}
