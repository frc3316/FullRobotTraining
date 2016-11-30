package org.usfirst.frc.team3316.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Collection extends CommandGroup {
    
    public  Collection() {
    	addSequential(new Open());
    	addSequential(new RollIn());
    	addSequential(new Close());
    }
}
