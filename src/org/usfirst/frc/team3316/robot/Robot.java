
package org.usfirst.frc.team3316.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3316.robot.commands.Close;
import org.usfirst.frc.team3316.robot.commands.Collection;
import org.usfirst.frc.team3316.robot.commands.Ejection;
import org.usfirst.frc.team3316.robot.commands.FlywheelPID;
import org.usfirst.frc.team3316.robot.commands.Open;
import org.usfirst.frc.team3316.robot.commands.RollIn;
import org.usfirst.frc.team3316.robot.commands.RollOut;
import org.usfirst.frc.team3316.robot.commands.Toggle;
import org.usfirst.frc.team3316.robot.commands.TransportBall;
import org.usfirst.frc.team3316.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3316.robot.subsystems.Flywheel;
import org.usfirst.frc.team3316.robot.subsystems.Gripper;
import org.usfirst.frc.team3316.robot.subsystems.Transport;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to each mode,
 * as described in the IterativeRobot documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource directory.
 */
public class Robot extends IterativeRobot
{

	public static final Gripper gripper = new Gripper();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Transport transport = new Transport();
	public static final Flywheel flywheel = new Flywheel();
	public static OI oi;
	public static boolean isFlywheelRunning = false;
	public static Command flywheelPID;
	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be used for any initialization code.
	 */
	public void robotInit()
	{
		oi = new OI();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You can use it to reset any
	 * subsystem information you want to clear when the robot is disabled.
	 */
	public void disabledInit()
	{

	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void autonomousInit()
	{
	}

	public void autonomousPeriodic()
	{

	}

	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        if (oi.aBtn.get()) {
        	(new Toggle()).start();
        }
        if (oi.xBtn.get())
        {
        	new TransportBall().start();
        }
        SmartDashboard.putBoolean("Button", gripper.isPressed());
        SmartDashboard.putNumber("Button Voltage", gripper.getSwitchVoltage());
        if(Robot.oi.joystick.getTrigger(Hand.kRight) && isFlywheelRunning == false)
        {		
        		flywheelPID = new FlywheelPID();
        		flywheelPID.start();
        		isFlywheelRunning = true;
        }
        if(Robot.oi.joystick.getTrigger(Hand.kRight) && isFlywheelRunning == true){
        	flywheelPID.cancel();
        	isFlywheelRunning = false;
        }
    }

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}
