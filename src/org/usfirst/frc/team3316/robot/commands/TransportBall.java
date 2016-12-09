package org.usfirst.frc.team3316.robot.commands;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.RobotMap;
import org.usfirst.frc.team3316.robot.subsystems.Transport;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TransportBall extends Command
{

	int counter;

	public TransportBall()
	{
		requires(Robot.transport);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		counter = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		counter++;
		Robot.transport.transportToShooter();

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return counter == RobotMap.TIME_TO_REACH_SHOOTER;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
