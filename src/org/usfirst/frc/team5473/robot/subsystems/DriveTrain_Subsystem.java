package org.usfirst.frc.team5473.robot.subsystems;

import org.usfirst.frc.team5473.robot.RobotMap;
import org.usfirst.frc.team5473.robot.commands.Drive_Command;
import org.usfirst.frc.team5473.robot.commands.Power_Command;

import External_Classes.DriveSignal;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain_Subsystem extends Subsystem{
	//create instances of proper spark motors, referencing the robot map.
	private SpeedController leftFrontMotor = new Spark(RobotMap.leftFrontMotor);
	private SpeedController rightFrontMotor = new Spark(RobotMap.rightFrontMotor);
	private SpeedController leftRearMotor = new Spark(RobotMap.leftRearMotor);
	private SpeedController rightRearMotor = new Spark(RobotMap.rightRearMotor);
	
	//private RobotDrive mainDrive = new RobotDrive(RobotMap.leftFrontMotor, RobotMap.rightFrontMotor, RobotMap.leftRearMotor, RobotMap.rightRearMotor);
	
	public DriveTrain_Subsystem(){
		super();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new Drive_Command());
	}
	
	public void TeleopDrive(Joystick driver){
		//mainDrive.arcadeDrive(-driver.getX(), driver.getY());
	}
	
	public void power(DriveSignal signal){
		leftFrontMotor.set(signal.leftMotor);
		rightFrontMotor.set(-signal.rightMotor);
		leftRearMotor.set(signal.leftMotor);
		rightRearMotor.set(-signal.rightMotor);
		
		
	}
	
	public void stop(){
		/*motor.set(0);
		motor2.set(0);*/
		//mainDrive.drive(0,0);
	}
}
