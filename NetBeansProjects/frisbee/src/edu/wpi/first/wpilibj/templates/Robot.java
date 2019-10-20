/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Timer;
//import hearthstone.wisp;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    RobotDrive myRobot;
    Joystick stick;
    Joystick stick2;
    DigitalInput pressureSensor;
    Relay compressor;
    Solenoid out;
    Solenoid in;
    Compressor pneumatics;
    Jaguar launchmotor1;
    Jaguar launchmotor2;
    Jaguar leftDrive;
    Jaguar rightDrive;
    int autoLoops = 0;

    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        

        // Initialize all subsystems
        leftDrive = new Jaguar(1);
        rightDrive = new Jaguar(2);
        myRobot = new RobotDrive(leftDrive,rightDrive);
        launchmotor1 = new Jaguar(4);
        launchmotor2 = new Jaguar(5);
    	stick = new Joystick(1);
    	stick2 = new Joystick(2);
    	pressureSensor = new DigitalInput(1);
    	compressor = new Relay(1);
    	out = new Solenoid(1);
    	in = new Solenoid(2);

    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        launchmotor1.set(-0.95);
        launchmotor2.set(-0.95);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        autoLoops++;
        if (autoLoops > 150 && autoLoops < 170) {
            out.set(true);
            in.set(false);
        } else if (autoLoops > 170) {
            launchmotor1.set(0);
            launchmotor2.set(0);
            out.set(false);
            in.set(true);
        }
        
        Timer.delay(20);
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        myRobot.tankDrive(stick2.getY()*-1, stick.getY()*-1);
        
        if(stick.getRawButton(1)){
            out.set(true);
            in.set(false);
        }
        else{
            out.set(false);
            in.set(true);
        }
        
        
        
        if(stick2.getRawButton(1)){
            launchmotor1.set(-0.95);
            launchmotor2.set(-0.95);
        }
        else{
            launchmotor1.set(0);
            launchmotor2.set(0);
        }
        
        if(!pressureSensor.get()){
            compressor.set(Relay.Value.kForward);
        }
        else{
            compressor.set(Relay.Value.kOff);
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
