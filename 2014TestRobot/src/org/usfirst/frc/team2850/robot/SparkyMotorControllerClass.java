package org.usfirst.frc.team2850.robot;

public class SparkyMotorControllerClass {
//if fixed it!
	
	private static void controlMotors()
	{
		Robot.motor1.set(Robot.xbox2.getRawAxis(1));
		Robot.motor2.set(Robot.xbox2.getRawAxis(5));
		Robot.motor3.set(Robot.xbox2.getRawAxis(2)-Robot.xbox2.getRawAxis(3));
	}
	
}
