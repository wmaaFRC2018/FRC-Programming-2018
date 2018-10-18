package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import External_Classes.CheesyDriveHelper;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class ClawVroomOut_AutoCommand extends TimedCommand {
	CheesyDriveHelper signal = new CheesyDriveHelper();
	
	public ClawVroomOut_AutoCommand(double time) {
		super(time);
		requires(Robot.vroom);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void execute(){
		//Set motor speed to 75%
		Robot.vroom.goVroomIn(.75);
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
		//Set motor speed back to 0%
		Robot.vroom.goVroomOut(0);
	}

}
