package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;
import org.usfirst.frc.team5473.robot.RobotMap;

import External_Classes.CheesyDriveHelper;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ClawVroom_Command extends Command{
	//RobotDrive mainDrive = new RobotDrive(0, 1); // class that handles basic drive
	// operations
	
	public ClawVroom_Command(){
		//mainDrive.setExpiration(0.1);
		requires(Robot.vroom);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void execute(){
		//if a person is pressing a trigger, perform a vroom action
		if(Math.abs(Robot.oi.getRightJoy().getRawAxis(3))>.03){
			Robot.vroom.goVroomIn(Robot.oi.getRightJoy().getRawAxis(3));
		}else if(Math.abs(Robot.oi.getRightJoy().getRawAxis(2))>.03){
			Robot.vroom.goVroomOut(Robot.oi.getRightJoy().getRawAxis(2));
		}else{
			Robot.vroom.stopVroom();
		}
		
		//Robot.claw.goVroomOut(.5);
	}
		
	@Override
	protected void interrupted(){
		end();
	}
}
