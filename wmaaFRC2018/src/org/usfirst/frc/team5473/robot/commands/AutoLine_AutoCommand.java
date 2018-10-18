package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoLine_AutoCommand extends CommandGroup{
	public AutoLine_AutoCommand(){
		addSequential(new DriveForward_AutoCommand(6));
		if(SmartDashboard.getString("Starting Side", "L").charAt(0)==DriverStation.getInstance().getGameSpecificMessage().charAt(0)){
			if(DriverStation.getInstance().getGameSpecificMessage().charAt(0)=='L'){
				addSequential(new Turn90_AutoCommand(-1));
			}else{
				addSequential(new Turn90_AutoCommand(1));
			}
			addSequential(new DriveForward_AutoCommand(.75));
			addSequential(new ClawLowerForSwitch_AutoCommand(.5));
			addSequential(new ClawVroomOut_AutoCommand(.5));
		}
		
	}
}
