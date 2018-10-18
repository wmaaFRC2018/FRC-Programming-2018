package org.usfirst.frc.team5473.robot.commands;

import org.usfirst.frc.team5473.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwitchScore_AutoCommand extends CommandGroup{
	public SwitchScore_AutoCommand(){
		addSequential(new DriveForward_AutoCommand(1));
		addSequential(new Turn90_AutoCommand(Robot.GSM));
		addSequential(new DriveForward_AutoCommand(1));
		addSequential(new Turn90_AutoCommand(-Robot.GSM));
		addSequential(new DriveForward_AutoCommand(2.75));
		addSequential(new ClawLowerForSwitch_AutoCommand(.5));
		addSequential(new ClawVroomOut_AutoCommand(.5));
		
	}
}
