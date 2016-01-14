
package org.usfirst.frc.team2850.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     * 
     * 
     */
	public static PID distancePid;
	public static PID velocityPid;
	public static Joystick xbox1;
	public static Joystick xbox2;
	
	public static RobotDrive drivetrain;
	
	public static DoubleSolenoid shifter1;
	public static DoubleSolenoid shifter2;
	
	public static Victor motor1;
	public static Victor motor2;
	public static Victor motor3;
	public static Victor motor4;
	public static Victor motor5;
	public static Encoder enc;
	
	
    public void robotInit() {
    	enc = new Encoder(0, 1,false, EncodingType.k4X);
    	xbox1 = new Joystick(0);
    	xbox2 = new Joystick(1);
    	
    	drivetrain = new RobotDrive(new Talon(0), new Talon(1));
    	
    	shifter1 = new DoubleSolenoid(0,1);
    	shifter2 = new DoubleSolenoid(2,3);
    	
    	motor1 = new Victor(2);
    	motor2 = new Victor(3);
    	motor3 = new Victor(4);
    	motor4 = new Victor(5);
    	motor5 = new Victor(6);
    	
    	velocityPid=new PID(.00009, .01, .00000001, 50000, 0);
    	velocityPid.setBounds(-1, 1);
    	velocityPid.setITermBounds(-0.5, 0.5);
    	
    	//distancePid= new PID(.0001, 0.00005, -0.0001, 100000, 0);
    	
    	//distancePid.setBounds(-1, 1);
    	//distancePid.setITermBounds(-0.5, 0.5);
    	
    	Timer.delay(0.01);

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
        //SparkyDriveHelper.arcadeDrive(xbox1, drivetrain);
        //SparkyMotorControllerClass.controlMotors();
        //SparkyPneumaticsController.pneumaticToggle();
        
//    	if(xbox1.getRawButton(1)) {
//    		pid.setTarget(15000);
//    	}
//    	else {
//    		pid.setTarget(5000);
//    	}
    	

    	
    	
    	
    	
    	double output = velocityPid.compute(enc.getRate());
    	
    	
        
        
        System.out.println(enc.getRate() + " " + output + " " + velocityPid.getTarget());
    	drivetrain.tankDrive(0, output);
        Timer.delay(0.01);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
