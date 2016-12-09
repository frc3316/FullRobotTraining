package org.usfirst.frc.team3316.robot.subsystems;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Transport extends Subsystem {
    
    VictorSP Transport;
    
    public Transport()
    {
    	Transport = new VictorSP(RobotMap.TRANSPORT_MOTOR);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void transportToShooter()
    {
    	Transport.set(RobotMap.TRANSPORT_SPEED);
    }
    
    
}

