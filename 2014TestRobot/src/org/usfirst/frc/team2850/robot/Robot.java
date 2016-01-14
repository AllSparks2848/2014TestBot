
package org.usfirst.frc.team2850.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
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
     */
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
	
	public static PID velocitypid;
	public static PID distancepid;
	
	public static Encoder encoder;
	
	public static I2C accelerometer;
	
    public void robotInit() {
    	xbox1 = new Joystick(0);
    	xbox2 = new Joystick(1);
    	
    	drivetrain = new RobotDrive(new Victor(0), new Victor(1));
    	
    	shifter1 = new DoubleSolenoid(0,1);
    	shifter2 = new DoubleSolenoid(2,3);
    	
    	motor1 = new Victor(2);
    	motor2 = new Victor(3);
    	motor3 = new Victor(4);
    	motor4 = new Victor(5);
    	motor5 = new Victor(6);
    	
    	encoder = new Encoder(0, 1, false, EncodingType.k4X);
    	
    	accelerometer = new I2C(Port.kOnboard, 0x53);
    	accelerometer.write(0x2d, 0b00001000);
//    	distancepid = new PID(.6, 0, .05, 100000, 0);
//    	velocitypid = new PID(0.00018, 0.000015, 0.000001, 0, encoder.getRate());
//    	distancepid.setBounds(-10000, 10000);
//    	velocitypid.setITermBounds(-0.5, 0.5);
//    	velocitypid.setBounds(-1, 1);
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
//        double target = distancepid.compute(encoder.getDistance());
//        velocitypid.setTarget(target);
//    	double output = velocitypid.compute(encoder.getRate());
//    	drivetrain.tankDrive(0,output);
//    	System.out.println(encoder.getRate() + " " + encoder.getDistance() + " " + target + " " + output);
    	byte[] data = new byte[1];
    	accelerometer.read(0x32, 1, data);
//    	short x = (short) ((short)(data[0]) | (short)(data[1]<< 8));
//    	short y = (short) ((short)(data[2]) | (short)(data[3]<< 8));
//    	short z = (short) ((short)(data[4]) | (short)(data[5]<< 8));
    	System.out.println(data[0]);
        Timer.delay(0.01);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
