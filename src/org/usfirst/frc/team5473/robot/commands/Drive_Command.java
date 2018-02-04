package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.OI;
import org.usfirst.frc.team5473.robot.Robot;
import org.usfirst.frc.team5473.robot.RobotMap;

import External_Classes.CheesyDriveHelper;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Drive_Command extends Command{
	//RobotDrive mainDrive = new RobotDrive(0, 1); // class that handles basic drive
	// operations
	Joystick leftStick = new Joystick(0); // set to ID 1 in DriverStation
	Joystick rightStick = new Joystick(1);
	
	CheesyDriveHelper signal = new CheesyDriveHelper();
	
	public Drive_Command(){
		//mainDrive.setExpiration(0.1);
		requires(Robot.driveTrain);
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
		
		Robot.driveTrain.power(signal.cheesyDrive(.5*Robot.oi.leftJoy.getY(), -Robot.oi.leftJoy.getRawAxis(4), (Robot.oi.leftJoy.getRawButton(5))));
	}

	@Override
	protected void interrupted(){
		end();
	}
}
