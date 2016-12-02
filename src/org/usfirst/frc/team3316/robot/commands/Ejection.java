package org.usfirst.frc.team3316.robot.commands;

import org.usfirst.frc.team3316.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Ejection extends CommandGroup {
    
    public  Ejection() {
    	addSequential(new Open());
    	addSequential(new WaitCommand(RobotMap.TIMEOUT_GRIPPER_PISTON));
    	addSequential(new RollOut());
    	addSequential(new Close());
    }
}
