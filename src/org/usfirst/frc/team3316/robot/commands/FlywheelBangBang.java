package org.usfirst.frc.team3316.robot.commands;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlywheelBangBang extends Command {
	private double velocity;		
    
	public FlywheelBangBang() {
    	requires(Robot.flywheel);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	velocity = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.flywheel.getRPS() < RobotMap.FLYWHEEL_SETPOINT)
    	{
    		velocity = RobotMap.FLYWHEEL_ON_VELOCITY;
    	}
    	else
    	{
    		velocity = RobotMap.FLYWHEEL_OFF_VELOCITY;
    	}
    	
    	Robot.flywheel.setMotors(velocity);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
