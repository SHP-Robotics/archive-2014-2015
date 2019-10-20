package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * <p>
 * A simple PID subsystem, it enables PID and leaves always on. The PID control
 * loop runs asynchronously in the background, so that once you set a setpoint.
 * It's only is setSetpoint which changes the setpoint the PID is trying to get
 * to. Our PID Input is a potentiometer hooked up to the wrist and our PID
 * output is a motor that drives the wrist. For more information on PID see:
 * https://en.wikipedia.org/wiki/PID_controller If you're having trouble, just
 * start with the</p>
 *
 * <p>
 * This subsystem also declares two constants that represent when the wrist at
 * the right height trying to pickup and when th wrist is in stowed position.
 * These can be used as known setpoints. wrist.setSetpoint(Wrist.STOW) would
 * stow the wrist</p>
 *
 * <p>
 * Recommended next step: {@link DriveTrain}<br/>
 * Related subsystem: {@link Elevator}</p>
 *
 * @author Alex Henning
 */
public class Turret extends PIDSubsystem {

    // The constants for the P, I and D portion of PID
    private static final double Kp = -2;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;

    Victor motor;
    //AnalogPotentiometer pot;
    Encoder turretEncoder; 

    // Initialize your subsystem here
    public Turret() {
        super("Wrist", Kp, Ki, Kd);
        motor = new Victor(RobotMap.turretMotor);
        //pot = new AnalogPotentiometer(1, RobotMap.turretPot, 1023, 0);
        turretEncoder = new Encoder(1,2);
    }

    /**
     * @return The value of the potentiometer used as the PID input device.
     * These values correspond to your PID setpoint, in this case the value can
     * be anywhere between 0v and 5v.
     */
    protected double returnPIDInput() {
        return turretEncoder.get();
    }

    public double getPot() {
        return turretEncoder.get();
    }

    /**
     * @param output The value to set the output to as determined by the PID
     * algorithm. This gets called each time through the PID loop to update the
     * output to the motor.
     */
    protected void usePIDOutput(double output) {
        motor.set(output);
    }

    public void driveTurret(double output) {
        motor.set(output);
    }

    /**
     * No default command is necessary because PID runs by default in the
     * backround.
     */
    protected void initDefaultCommand() {
    }
}
