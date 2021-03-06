
package org.usfirst.frc.team5473.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;

import org.usfirst.frc.team5473.robot.commands.ArmUp_AutoCommand;
import org.usfirst.frc.team5473.robot.commands.AutoLine_AutoCommand;
import org.usfirst.frc.team5473.robot.commands.ClawUp_AutoCommand;
import org.usfirst.frc.team5473.robot.commands.DriveForward_AutoCommand;
import org.usfirst.frc.team5473.robot.commands.ExampleCommand;
import org.usfirst.frc.team5473.robot.commands.Log;
import org.usfirst.frc.team5473.robot.commands.Log_Command;
import org.usfirst.frc.team5473.robot.commands.Power_Command;
import org.usfirst.frc.team5473.robot.commands.SwitchScore_AutoCommand;
import org.usfirst.frc.team5473.robot.subsystems.Arm_Subsystem;
import org.usfirst.frc.team5473.robot.subsystems.Claw_Subsystem;
import org.usfirst.frc.team5473.robot.subsystems.DriveTrain_Subsystem;
import org.usfirst.frc.team5473.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team5473.robot.subsystems.SolenoidGrabber_Subsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static DriveTrain_Subsystem driveTrain;
	public static OI oi;
	public static Arm_Subsystem arm;
	public static Claw_Subsystem claw;
	public static SolenoidGrabber_Subsystem pshuk;
	
	public static int GSM;

	Command autonomousCommand;
	Log log;
	SendableChooser<String> autoChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//Robot Init//
		CameraServer.getInstance().startAutomaticCapture();
		RobotMap.init();
		
		//Making some subsystems//
		driveTrain = new DriveTrain_Subsystem();
		arm = new Arm_Subsystem();
		claw = new Claw_Subsystem();
		pshuk = new SolenoidGrabber_Subsystem();
		 
		//Please keep oi last in subsystem connections//
		oi = new OI();
		
		//Autonomous modes for choosing on SmartDashboard//
		autoChooser = new SendableChooser<>();
		autoChooser.addDefault("Default Auto", "def");
		autoChooser.addObject("Switch Score", "switch");
		autoChooser.addObject("SwitchScoreFromSide", "AutWTurn");
		/*autoChooser.addObject("Arm Auto", "");
		autoChooser.addObject("Test ClawUp Subsystem", "");*/

		//autoChooser.addObject("My Auto", new MyAutoCommand());
			
		SmartDashboard.putData("Auto mode", autoChooser);
		SmartDashboard.putString("Starting Side", "L");
		//SmartDashboard.putNumber("SwitchAutonDirection(1 or -1):", 1);

		/*SmartDashboard.putNumber("armMotor Output Voltage", RobotMap.armMotor.getMotorOutputVoltage());
		SmartDashboard.putNumber("armMotor Output Percent", RobotMap.armMotor.getMotorOutputPercent());
		
		SmartDashboard.putNumber("clawPivot Output Voltage", RobotMap.clawPivot.getMotorOutputVoltage());
		SmartDashboard.putNumber("clawPivot Output Percent", RobotMap.clawPivot.getMotorOutputPercent());
		
		
		
		SmartDashboard.putNumber("robotYaw", Robot.driveTrain.getYaw());
		SmartDashboard.putNumber("robotPitch", Robot.driveTrain.getPitch());
		SmartDashboard.putNumber("robotRoll", Robot.driveTrain.getRoll());
		
		SmartDashboard.putNumber("Arm Encoder", Robot.arm.getArmMotor().getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Claw Encoder", Robot.claw.getClawMotor().getSelectedSensorPosition(0));*/
		
		//Log systems of the robot
		log = new Log();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		GSM=getGameSpecificMessage();
		switch(autoChooser.getSelected()){
		case "def":autonomousCommand=new DriveForward_AutoCommand(7);
			break;
		case "switch":autonomousCommand=new SwitchScore_AutoCommand();
			break;
		case "AutWTurn":autonomousCommand=new AutoLine_AutoCommand();
			break;
		default: autonomousCommand=new DriveForward_AutoCommand(7);
		}
		/*autoChooser.addDefault("Default Auto", new DriveForward_AutoCommand(7));
		autoChooser.addObject("Switch Score", new SwitchScore_AutoCommand());
		autoChooser.addObject("Arm Auto", new ArmUp_AutoCommand(-.1));
		autoChooser.addObject("Test ClawUp Subsystem", new ClawUp_AutoCommand(.1));
		autonomousCommand = autoChooser.getSelected();*/
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log.log();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log.log();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public int getGameSpecificMessage(){
		String gameData= DriverStation.getInstance().getGameSpecificMessage();
        if(gameData.length() > 0){
        	if(gameData.charAt(0) == 'L'){
        		//Put left auto code here
        		return 1;
        	} else {
        		//Put right auto code here
        		return -1;
		  }
       }else
    	   return -1;
	}
	
}
