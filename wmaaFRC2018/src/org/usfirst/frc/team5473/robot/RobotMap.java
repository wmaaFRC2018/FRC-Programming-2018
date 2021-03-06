package org.usfirst.frc.team5473.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	
	public static SpeedController leftFrontMotor;
	public static SpeedController rightFrontMotor;
	public static SpeedController leftRearMotor;
	public static SpeedController rightRearMotor;
	
	public static TalonSRX armMotor;
	public static TalonSRX clawPivot;
	public static Compressor compressor;
	public static Solenoid solenoid1;
	public static Solenoid solenoid2;
	
	public static PigeonIMU pidgey;
	
	
	//Talons
	//Test push
	
	//Set the sparks
	/*public static Spark sparkF_L;
	public static Spark sparkF_R;
	public static Spark sparkB_L;
	public static Spark sparkB_R;*/
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static void init(){
		
		leftFrontMotor = new Spark(0);
		rightFrontMotor = new Spark(1);
		leftRearMotor = new Spark(2);
		rightRearMotor = new Spark(3);
		
		solenoid1 = new Solenoid(1);
		solenoid2 = new Solenoid(2);
		compressor = new Compressor(0);
		clawPivot = new TalonSRX(62);
		armMotor = new TalonSRX(61);
		
		pidgey = new PigeonIMU(60);
		
	}

}