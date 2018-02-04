package org.usfirst.frc.team5473.robot.subsystems;

import org.usfirst.frc.team5473.robot.RobotMap;
import org.usfirst.frc.team5473.robot.commands.Drive_Command;
import org.usfirst.frc.team5473.robot.commands.Power_Command;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import External_Classes.DriveSignal;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm_Subsystem extends Subsystem{
	//create instances of proper spark motors, referencing the robot map.
	private TalonSRX armMotor = new TalonSRX(15);


	//private RobotDrive mainDrive = new RobotDrive(RobotMap.leftFrontMotor, RobotMap.rightFrontMotor, RobotMap.leftRearMotor, RobotMap.rightRearMotor);
	
	public Arm_Subsystem(){
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
	
	public void learning(DriveSignal signal){
		armMotor.setInverted(true);
		armMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
		armMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
	}
	
	public void stop(){
		/*motor.set(0);
		motor2.set(0);*/
		//mainDrive.drive(0,0);
	}
}
