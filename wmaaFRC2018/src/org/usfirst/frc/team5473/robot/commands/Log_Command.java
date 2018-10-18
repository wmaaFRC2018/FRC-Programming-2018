package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;
import org.usfirst.frc.team5473.robot.RobotMap;

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
		/*Robot.driveTrain.log("robotYaw", Robot.driveTrain.getYaw());
		Robot.driveTrain.log("robotPitch", Robot.driveTrain.getPitch());
		Robot.driveTrain.log("robotRoll", Robot.driveTrain.getRoll());
		
		Robot.arm.log("Arm Encoder", Robot.arm.getArmMotor().getSelectedSensorPosition(0));
		Robot.claw.log("Claw Encoder", Robot.claw.getClawMotor().getSelectedSensorPosition(0));*/
		SmartDashboard.putNumber("armMotor Output Voltage", RobotMap.armMotor.getMotorOutputVoltage());
		SmartDashboard.putNumber("armMotor Output Percent", RobotMap.armMotor.getMotorOutputPercent());
		
		SmartDashboard.putNumber("clawPivot Output Voltage", RobotMap.clawPivot.getMotorOutputVoltage());
		SmartDashboard.putNumber("clawPivot Output Percent", RobotMap.clawPivot.getMotorOutputPercent());
		
		SmartDashboard.putNumber("robotYaw", Robot.driveTrain.getYaw());
		SmartDashboard.putNumber("robotPitch", Robot.driveTrain.getPitch());
		SmartDashboard.putNumber("robotRoll", Robot.driveTrain.getRoll());
		
		SmartDashboard.putNumber("Arm Encoder", Robot.arm.getArmMotor().getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Claw Encoder", Robot.claw.getClawMotor().getSelectedSensorPosition(0));
	}

}
