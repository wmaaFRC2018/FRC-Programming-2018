package org.usfirst.frc.team5473.robot;

import org.usfirst.frc.team5473.robot.commands.ArmMove_Command;
import org.usfirst.frc.team5473.robot.commands.Log_Command;
import org.usfirst.frc.team5473.robot.commands.Power_Command;
import org.usfirst.frc.team5473.robot.commands.Turn90_AutoCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//import org.usfirst.frc.team5473.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Create the joystick and the 8 buttons on it
		Joystick leftJoy = new Joystick(0);
		Joystick rightJoy = new Joystick(1);
		
		public OI(){
			Button button1 = new JoystickButton(leftJoy, 1),
					button2 = new JoystickButton(leftJoy, 2),
					button3 = new JoystickButton(leftJoy, 3),
					button4 = new JoystickButton(leftJoy, 4),
					button5 = new JoystickButton(leftJoy, 5),
					button6 = new JoystickButton(leftJoy, 6),
					button7 = new JoystickButton(leftJoy, 7),
					button8 = new JoystickButton(leftJoy, 8);
			Button rightButton1 = new JoystickButton(rightJoy, 4);
			
			//When the x button is pressed, activate the up command. *TEMPORARY*
			button4.whileActive(new Turn90_AutoCommand(1));
			//rightButton1.whenPressed(new Log_Command());
			
		}
		
		public Joystick getLeftJoy(){
			return leftJoy;
		}
		
		public Joystick getRightJoy(){
			return rightJoy;
		}
	//THIS IS A TEST OF REMOTE
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	  //Joystick stick = new Joystick(port);
	  //Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
