package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;
import org.usfirst.frc.team5473.robot.RobotMap;

import External_Classes.CheesyDriveHelper;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ClawSolenoid_Command extends Command{
	//RobotDrive mainDrive = new RobotDrive(0, 1); // class that handles basic drive
	// operations
	
	public ClawSolenoid_Command(){
		//mainDrive.setExpiration(0.1);
		requires(Robot.pshuk);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void execute(){
		//if a person is pressing a trigger, perform a solenoid "pshuk" action
		if(Robot.oi.getLeftJoy().getRawButton(7)){
			Robot.pshuk.extend();
		} else {
			Robot.pshuk.retract();
		}
		
	}
		
	@Override
	protected void interrupted(){
		end();
	}
}