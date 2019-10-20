/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.defaultCode;


import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import hearthstone.wisp;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class DefaultRobot extends IterativeRobot {

    RobotDrive myRobot;
    Joystick stick;
    Joystick stick2;
    Victor leftDrive;
    Victor rightDrive;
    Victor turretX;
    AnalogPotentiometer turretXPot;


    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        

        // Initialize all subsystems
        leftDrive = new Victor(10);
        rightDrive = new Victor(9);
        turretX = new Victor(8);
        myRobot = new RobotDrive(leftDrive,rightDrive);
    	stick = new Joystick(1);
    	stick2 = new Joystick(2);
        turretXPot = new AnalogPotentiometer(1,7,1023,0);


    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
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
        
        myRobot.tankDrive(stick.getY()*-1, stick2.getY()*-1);
        
        if(stick.getRawButton(4) && turretXPot.get() < 5100){
            turretX.set(0.75);
        }
        else if(stick.getRawButton(5) && turretXPot.get() > 10){
            turretX.set(-0.75);
        }
        else{
            turretX.set(0);
        }
        //SmartDashboard.putDouble("Pot Pos", turretXPot.get());
        
        

        

    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
