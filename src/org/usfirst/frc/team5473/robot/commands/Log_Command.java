package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Log_Command extends Command{

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void execute(){
		Robot.driveTrain.log("robotYaw", Robot.driveTrain.getYaw());
		Robot.driveTrain.log("robotPitch", Robot.driveTrain.getPitch());
		Robot.driveTrain.log("robotRoll", Robot.driveTrain.getRoll());
		
		Robot.arm.log("Arm Encoder", Robot.arm.getArmMotor().getSelectedSensorPosition(0));
	}

}
