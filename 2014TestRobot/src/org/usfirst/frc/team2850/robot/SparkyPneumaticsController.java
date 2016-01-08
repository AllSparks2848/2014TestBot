package org.usfirst.frc.team2850.robot;

public class SparkyPneumaticsController {

	private static boolean shifterstate= false;
	private static boolean wasrightbutton = false;
	private static boolean wasrightshoulder = false;
	
	public static void pneumaticToggle(){
		wasrightshoulder = false;
		wasrightbutton = false;
		if (Robot.xbox1.getRawAxis(3) > 0.75 && !wasrightshoulder) {
			wasrightshoulder = true;
			shifterstate = true;
		}
		if (Robot.xbox1.getRawButton(6) && !wasrightbutton){
			wasrightbutton = true;
			shifterstate = false;
		}
		Robot.shifter1.set(shifterstate);
		Robot.shifter2.set(shifterstate);
	}
}
