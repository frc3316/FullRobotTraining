package org.usfirst.frc.team3316.robot;

import org.usfirst.frc.team3316.robot.commands.Toggle;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI
{
	public Joystick joystick, rightJoystick, leftJoystick;
	public JoystickButton aBtn, xBtn;

	public OI()
	{
		joystick = new Joystick(RobotMap.JOYSTICK);
		leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK);
		rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);
		aBtn = new JoystickButton(joystick, RobotMap.JOYSTICK_BUTTON_A);
		xBtn = new JoystickButton(joystick, RobotMap.JOYSTICK_BUTTON_X);
	}

}
