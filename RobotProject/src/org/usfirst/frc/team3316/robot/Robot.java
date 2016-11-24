
package org.usfirst.frc.team3316.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	AnalogInput button;
	DoubleSolenoid ds;
	VictorSP sc;
	Joystick xbox360controller;
	double axis;
	boolean ButtonHeld;
	JoystickButton intakeBTN;
	JoystickButton outtakeBTN;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        sc = new VictorSP(4);
        ds = new DoubleSolenoid(4, 5);
        button = new AnalogInput(3);
        xbox360controller = new Joystick(2);
        intakeBTN = new JoystickButton(xbox360controller, 2);
        outtakeBTN = new JoystickButton(xbox360controller, 1);
        
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        axis = -xbox360controller.getRawAxis(1);
        ButtonHeld = button.getAverageVoltage() >= 2500;
        
        if(ButtonHeld && axis < 0)
        {
        	sc.set(axis);
        }
        else if(!ButtonHeld && axis > 0)
        {
        	sc.set(axis);
        }
        if(ds.get() != Value.kReverse && intakeBTN.get()) 
        {
        	ds.set(Value.kReverse);
        }
        else if(ds.get() != Value.kForward && outtakeBTN.get())
        {
        	ds.set(Value.kForward);
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
