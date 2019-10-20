package edu.wpi.first.wpilibj.templates.commands;

/**
 * <p>
 * The default command for the drive train. When no other command is running,
 * the robot can be driven using the joysticks.</p>
 *
 * <p>
 * Recommended next step: {@link DriveToDistance}
 *
 * @author Alex Henning
 */
public class DriveTurret extends CommandBase {

    /**
     * Requires the drive train
     */
    public DriveTurret() {
        requires(turret);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Have the drivetrain drive tank drive with the latest values from
     * joysticks.
     */
    protected void execute() {
        if (turret.getPot() < 5050 && oi.Lbutton4.get()) {
            turret.driveTurret(
                    oi.getTurretSpeed());
        } else if (turret.getPot() > 100 && oi.Lbutton5.get()) {
            turret.driveTurret(
                    oi.getTurretSpeed());
        } else {
            turret.driveTurret(0);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return false, so that it executes forever or until another command
     * interrupts it.
     */
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
