package org.usfirst.frc.team5473.robot.subsystems;

import org.usfirst.frc.team5473.robot.RobotMap;
import org.usfirst.frc.team5473.robot.commands.Drive_Command;
import org.usfirst.frc.team5473.robot.commands.Power_Command;

import com.ctre.phoenix.sensors.PigeonIMU;

import External_Classes.DriveSignal;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain_Subsystem extends Subsystem{
	//create instances of proper spark motors, referencing the robot map.
	private SpeedController leftFrontMotor = RobotMap.leftFrontMotor;
	private SpeedController rightFrontMotor = RobotMap.rightFrontMotor;
	private SpeedController leftRearMotor = RobotMap.leftRearMotor;
	private SpeedController rightRearMotor = RobotMap.rightRearMotor;
	
	private PigeonIMU pidgey = RobotMap.pidgey;
	PigeonIMU.GeneralStatus genStatus = new PigeonIMU.GeneralStatus();
	
	private double [] ypr = new double[3];
	
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
	
	public double getYaw(){
		pidgey.getYawPitchRoll(ypr);
		return ypr[0];
	}
	
	public double getPitch(){
		pidgey.getYawPitchRoll(ypr);
		return ypr[1];
	}
	
	public double getRoll(){
		pidgey.getYawPitchRoll(ypr);
		return ypr[2];
	}
	
	public PigeonIMU getPidgey(){
		return pidgey;
	}
	
	public void log(String key, double data){
		SmartDashboard.putNumber(key, data);
	}
	
	public void stop(){
		/*motor.set(0);
		motor2.set(0);*/
		//mainDrive.drive(0,0);
	}
	
/*
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}*/
	
	/*public void logPigeonGenStat(){
		SmartDashboard.putData(pidgey.getGeneralStatus(genStatus));
	}*/
}
