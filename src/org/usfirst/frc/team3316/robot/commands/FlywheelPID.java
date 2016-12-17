package org.usfirst.frc.team3316.robot.commands;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlywheelPID extends Command {
	private PIDController flywheelPID;
	private double velocity; 
    public FlywheelPID() {
    	requires(Robot.flywheel);
    	flywheelPID = new PIDController(0, 0, 0, new PIDSource()
		{
			
			@Override
			public void setPIDSourceType(PIDSourceType pidSource)
			{
				return;
			}
			
			@Override
			public double pidGet()
			{
				return Robot.flywheel.getRPS();
			}
			
			@Override
			public PIDSourceType getPIDSourceType()
			{
				return PIDSourceType.kRate;
			}
		}, new PIDOutput()
		{
			
			@Override
			public void pidWrite(double output)
			{
				velocity = output;
			}
		});
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	velocity = 0;
    	flywheelPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	flywheelPID.setPID(RobotMap.FLYWHEEL_KP, RobotMap.FLYWHEEL_KI, RobotMap.FLYWHEEL_KD);
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
