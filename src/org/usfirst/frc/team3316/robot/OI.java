package org.usfirst.frc.team3316.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	Joystick joystick;
    public JoystickButton aBtn;
    
    public OI(){
    	joystick = new Joystick(RobotMap.JOYSTICK);
        aBtn = new JoystickButton(joystick,0);
    }
    
    
}

