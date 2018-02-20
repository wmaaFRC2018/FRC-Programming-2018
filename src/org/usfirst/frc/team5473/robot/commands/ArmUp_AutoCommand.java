package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmUp_AutoCommand extends Command{
	
	public ArmUp_AutoCommand(){
		
	}
	
	@Override
	protected void initialize(){
		/* first choose the sensor */
		Robot.arm.armMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		Robot.arm.armMotor.reverseSensor(false);
		// Robot.arm.armMotor.configEncoderCodesPerRev(XXX)
		// Robot.arm.armMotor.configPotentiometerTurns(XXX)
		/* set the peak and nominal outputs, 12V means full */
		Robot.arm.armMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		Robot.arm.armMotor.configPeakOutputVoltage(+12.0f, -12.0f);
		/* set closed loop gains in slot0 - see documentation */
		Robot.arm.armMotor.setProfile(0);
		Robot.arm.armMotor.setF(0);
		Robot.arm.armMotor.setP(0);
		Robot.arm.armMotor.setI(0);
		Robot.arm.armMotor.setD(0);
		Robot.arm.armMotor.setMotionMagicCruiseVelocity(0);
		Robot.arm.armMotor.setMotionMagicAcceleration(0);

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void execute(){
		
	}

	@Override
	protected void interrupted(){
		end();
	}
	
}