package org.usfirst.frc.team2850.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

public class SparkyDriveHelper {

	
	public static void arcadeDrive( Joystick xbox, RobotDrive drive){
		
		drive.arcadeDrive(xbox.getRawAxis(1), -xbox.getRawAxis(4)); 
        	
        
	}
}
