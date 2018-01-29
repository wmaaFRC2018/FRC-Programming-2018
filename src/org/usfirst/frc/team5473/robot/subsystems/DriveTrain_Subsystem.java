package org.usfirst.frc.team5473.robot.subsystems;

import org.usfirst.frc.team5473.robot.RobotMap;
import org.usfirst.frc.team5473.robot.commands.Drive_Command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain_Subsystem extends Subsystem{
	//private RobotDrive mainDrive = new RobotDrive(RobotMap.leftFrontMotor, RobotMap.rightFrontMotor, RobotMap.leftRearMotor, RobotMap.rightRearMotor);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new Drive_Command());
	}
	
	public void TeleopDrive(Joystick driver){
		//mainDrive.arcadeDrive(-driver.getX(), driver.getY());
	}
	
	public void stop(){
		//mainDrive.drive(0,0);
	}
}
