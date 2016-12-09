package org.usfirst.frc.team3316.robot;
/*
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// PCM CHANNELS
	public static final int OPEN_SELONID = 4;
	public static final int CLOSE_SELONID = 5;
	// OI
	public static final int JOYSTICK = 2;
	public static final int JOYSTICK_BUTTON_A = 1;
	public static final int JOYSTICK_BUTTON_X = 2;
	public static final int LEFT_JOYSTICK = 0;
	public static final int RIGHT_JOYSTICK = 1;
	// ACTUATORS & SENSORS
		// Gripper
		public static final int ROLLER_GRIPPER_MOTOR = 4;
		public static final int ROLLER_GRIPPER_SWITCH = 3;
		// Drivetrain
		public static final int RIGHT_MOTOR1 = 15;
		public static final int RIGHT_MOTOR2 = 2;
		public static final int LEFT_MOTOR1 = 3;
		public static final int LEFT_MOTOR2 = 14;
		// Transport
		public static final int TRANSPORT_MOTOR = 0;
	// CONSTANTS
	public static final double ROLLIN_SPEED = -1.0;
	public static final double ROLLOUT_SPEED = 1.0;
	public static final double TIMEOUT_GRIPPER_PISTON = 1.0;
	public static final double TRANSPORT_SPEED = 1.0;
	public static final int TIME_TO_REACH_SHOOTER = 75;
	
	
}
