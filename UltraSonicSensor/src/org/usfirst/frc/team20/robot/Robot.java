
package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Joystick joy;
    Joystick joy2;
	AnalogInput sensor;
	double vcc; 
	AnalogInput voltage;
	double inches;
	double calculatedInches;
	//Sensors s = new Sensors();
	DriveTrain d = new DriveTrain(4);
	
	public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        joy = new Joystick(0);
    	//sensor = new AnalogInput(3);
    	voltage = new AnalogInput(2);
    	joy2 = new Joystick(1);
    	d.assignPort(0, 10);
    	d.assignPort(1, 9);
    	d.assignPort(2, 1);
    	d.assignPort(3, 2);
    	
    	
    	
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    	
   	
    /**
     * This function is called periodically during autonomous
     */
	public void autonomousInit(){
		calculatedInches = sensor.getAverageVoltage()/(vcc/512);
	}	
    public void autonomousPeriodic() {
//    	double numberInches;
//    	numberInches = getSensorInches();
//    	System.out.println(numberInches);
//    	if(numberInches > 13){
//    		fr.set(-.5);
//    		br.set(-.5);
//    		fl.set(0);
//    		bl.set(0);
//    		
//    	}
//    	else if(numberInches < 11){
//    		fr.set(0);
//    		br.set(0);
//    		fl.set(.5);
//    		bl.set(.5);
//    	}else{
//    		fr.set(-.25);
//        	br.set(-.25);	
//        	fl.set(.25);
//        	bl.set(.25);	
//    	}
    
    }
    

    /**
     * This function is called periodically during operator control
     */
    double inchesGoal = 12;
    double inchesFromWall;
    public void teleopPeriodic() {
//    	System.out.println("Inches Goal:" + inchesGoal);
//    	inchesFromWall = inches;
//    	if(joy.getRawButton(5)){
//    		inchesGoal += 6;  		
//    	}
//    	if(joy.getRawButton(4)){
//    		inchesGoal -= 6;
//    		if(inchesGoal < 12){
//    			inchesGoal = 12;
//    		}
//    	}
//		
//		if(inchesFromWall < inchesGoal + 3 && inchesFromWall > inchesGoal - 3){	
//    		fr.set(0);					
//    		br.set(0);
//    		fl.set(0);
//    		bl.set(0);
//    	}else if(inchesFromWall < inchesGoal + 3){
//    		fr.set(.15);				
//    		br.set(.15);
//    		fl.set(-.15);
//    		bl.set(-.15);
//    	}else if(inchesFromWall > inchesGoal - 3){
//    		fr.set(-.15);				
//    		br.set(-.15);
//    		fl.set(.15);
//    		bl.set(.15);
//    	}
    	double l = joy2.getRawAxis(1);
    	double r = joy.getRawAxis(1);
    	d.tankDrive(l, r);
    }
    
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic(){
    	
    }
}    