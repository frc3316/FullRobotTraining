package org.usfirst.frc.team3316.robot.subsystems;

import org.usfirst.frc.team3316.robot.RobotMap;
import org.usfirst.frc.team3316.robot.commands.Close;
import org.usfirst.frc.team3316.robot.commands.Open;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
    VictorSP rollerGripper;
	DoubleSolenoid ds;
	AnalogInput button;
	public Gripper()
	{
		ds = new DoubleSolenoid(RobotMap.OPEN_SELONID, RobotMap.CLOSE_SELONID);
    	rollerGripper = new VictorSP(RobotMap.ROLLER_GRIPPER);
    	button = new AnalogInput(RobotMap.SWITCH);
	}
	

    public void initDefaultCommand() {
    	
    }
    
    public void open(){
    	ds.set(Value.kForward);
    }
    public void close(){
    	ds.set(Value.kReverse);
    }
    public void setMotor(double speed)
    {
    	rollerGripper.set(speed);
    }
    public boolean isOpen(){
    	return (ds.get() == Value.kForward);
    }
    public boolean isPressed()
    {
    	return button.getAverageVoltage() >= 2500;
    }
    
    
}

