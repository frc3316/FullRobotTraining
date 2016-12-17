package org.usfirst.frc.team3316.robot.subsystems;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flywheel extends Subsystem {

    private VictorSP flywheel;
    private DigitalInput halleffect;
    private Counter flywheelCounter;
    
	public void initDefaultCommand() {
    }
    
	public Flywheel()
    {
    	flywheel = new VictorSP(RobotMap.FLYWHEEL_MOTOR);
    	halleffect = new DigitalInput(RobotMap.HALL_EFFECT);
    	flywheelCounter = new Counter(halleffect);
    	flywheelCounter.setDistancePerPulse(1.0/6.0);
    }
	
	public double getRPS()
	{
		return flywheelCounter.getRate();
	}
    
	public void setMotors(double speed)
	{
		flywheel.set(speed);
	}
}

