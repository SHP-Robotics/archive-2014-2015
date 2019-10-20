/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Jaguar;
//import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogChannel;
import java.lang.Math;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    
    /* Global variables */
    Joystick left= new Joystick(1);
    Joystick right = new Joystick(2);
    Talon exampleTalonMC = new Talon(4);
    Jaguar exampleJaguarMC = new Jaguar(2);
    Victor exampleVictorMC = new Victor(3);
    //Compressor airCompressor = new Compressor(1,1); //Digital I/O (in), relay #(out)
    Solenoid s1 = new Solenoid(1);
    Solenoid s2 = new Solenoid(2);
    Relay spike = new Relay(1);
    DigitalInput touchsensor = new DigitalInput(2);
    AnalogChannel sonar = new AnalogChannel(1);
    double distance;
    double voltage_to_inches = 1/(4.9*2.54*12/1000);
    
  /*  public void robotInit() {
        airCompressor.start();
    }*/
            
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        
        exampleTalonMC.set(0.1);
        exampleJaguarMC.set(0.1);
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        double leftY;
        while(isOperatorControl() && isEnabled())
        {
            leftY = left.getY();
            exampleTalonMC.set(leftY);
            Timer.delay(0.1);
            
            if(left.getRawButton(1))
            {
                exampleJaguarMC.set(0.5);
                Timer.delay(0.1);
            }
            else if (left.getRawButton(2))
            {
                exampleVictorMC.set(-0.5);
                Timer.delay(0.1);
            }
            

            if(left.getRawButton(3))
            {
                spike.set(Relay.Value.kForward);
            }
            else
            {
                spike.set(Relay.Value.kOff);
            }
            
            //System.out.println(touchsensor.get());
            
            if (touchsensor.get())
            {
                s1.set(true);
                s2.set(false);  
            } 
            else
            {
                s1.set(false);
                s2.set(true);                 
            }
            
            //distance = sonar.getVoltage()*voltage_to_inches;
            distance = sonar.getVoltage();
            System.out.println(distance);
            
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
        double leftY, rightY;
        //exampleTalonMC.set(0.1);
        //exampleJaguarMC.set(0.1);
        //exampleVictorMC.set(0.1);
        //airCompressor.start();
        if(left.getRawButton(3))
        {
            spike.set(Relay.Value.kForward);
        }
        else
        {
            spike.set(Relay.Value.kOff);
        }
        


    }
}
