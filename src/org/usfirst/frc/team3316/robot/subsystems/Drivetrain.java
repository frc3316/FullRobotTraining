package org.usfirst.frc.team3316.robot.subsystems;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.RobotMap;
import org.usfirst.frc.team3316.robot.commands.MoveRobot;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    VictorSP rightMotor1, rightMotor2, leftMotor1, leftMotor2;
    public Drivetrain()
    {
    	rightMotor1 = new VictorSP(RobotMap.RIGHT_MOTOR1);
        rightMotor2 = new VictorSP(RobotMap.RIGHT_MOTOR2);
        leftMotor1 = new VictorSP(RobotMap.LEFT_MOTOR1);
        leftMotor2 = new VictorSP(RobotMap.LEFT_MOTOR2);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new MoveRobot());
    }
    public double getRightJoystick()
    {
    	return -Robot.oi.rightJoystick.getY();
    }
    public double getLeftJoystick()
    {
    	return -Robot.oi.leftJoystick.getY();
    }
    public void setRightMotors(double speed)
    {
    	rightMotor1.set(speed);
    	rightMotor2.set(speed);
    }
    public void setLeftMotors(double speed)
    {
    	leftMotor1.set(speed);
    	leftMotor2.set(speed);
    }
}

