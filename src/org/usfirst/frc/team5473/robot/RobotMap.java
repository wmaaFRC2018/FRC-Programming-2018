package org.usfirst.frc.team5473.robot;

import edu.wpi.first.wpilibj.Spark;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	public static final int leftFrontMotor = 0;
	public static final int rightFrontMotor = 1;
	public static final int leftRearMotor = 2;
	public static final int rightRearMotor = 3;
	
	//Set the sparks
	/*public static Spark sparkF_L;
	public static Spark sparkF_R;
	public static Spark sparkB_L;
	public static Spark sparkB_R;*/
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
