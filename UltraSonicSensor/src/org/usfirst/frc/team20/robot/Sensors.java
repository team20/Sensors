package org.usfirst.frc.team20.robot;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Sensors {
	private double vcc;
	private double inches;
	private AnalogInput sensor;
	private AnalogInput voltage;
	private double inchesFromWall;
	
	public Sensors(){
		sensor = new AnalogInput(3);
    	voltage = new AnalogInput(2);
	}
	public double getDistance(){
		vcc = voltage.getVoltage();
        inches = (sensor.getAverageVoltage()/(vcc/5120))/25.4;		//takes sensor input, compares against voltage, and convert to inches
    	return inches;
	}
	public void goToDistance(double targetInches){
		inchesFromWall = getDistance();
		if(inchesFromWall < targetInches + 3 && inchesFromWall > targetInches - 3){	
//    		fr.set(0);					To do: insert code for drive train stopping
//    		br.set(0);
//    		fl.set(0);
//    		bl.set(0);
    	}else if(inchesFromWall < targetInches + 3){
//    		fr.set(.15);				To do: insert code for drive train forward
//    		br.set(.15);
//    		fl.set(-.15);
//    		bl.set(-.15);
    	}else if(inchesFromWall > targetInches - 3){
//    		fr.set(-.15);				To do: insert code for drive train backwards
//    		br.set(-.15);
//    		fl.set(.15);
//    		bl.set(.15);
    	}
	}
}
