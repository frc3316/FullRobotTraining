package org.usfirst.frc.team3316.robot;

import edu.wpi.first.wpilibj.VictorSP;

public class DriveTrain
{
	private VictorSP lftback;
	private VictorSP lftfrnt;
	private VictorSP rgtback;
	private VictorSP rgtfrnt;
	
	public DriveTrain(){
		

        
        lftback = new VictorSP(3);
    	lftfrnt = new VictorSP(14);
    	rgtback = new VictorSP(2);
    	rgtfrnt = new VictorSP(15);
		
	}
	
	public void setMotors(double leftValue, double rightValue){
		rgtback.set(-rightValue);
		rgtfrnt.set(-rightValue);
        lftback.set(leftValue);
        lftfrnt.set(leftValue);
	}
	
}

