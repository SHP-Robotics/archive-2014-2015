/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.Turret;

/**
 * <p>
 * The CommandBase class is automatically generated when the project is created.
 * However, whenever you create a new subsystem, you must create a public static
 * reference to it in the CommandBase class. All commands (except for
 * CommandGroups) should be subclasses of CommandBase.</p>
 *
 * <p>
 * Recommended next step: {@link ClawDoNothing}</p>
 *
 * @author Alex Henning
 */
public abstract class CommandBase extends Command {

    // CommandBase holds a static instance of OI
    public static OI oi;

    // Instances of each subsystem
    public static DriveTrain drivetrain = new DriveTrain();
    public static Turret turret = new Turret();
    

    /**
     * Call this command to properly finish initializing the CommandBase. This
     * call is automatically included in the default template.
     */
    public static void init() {
        oi = new OI();

        // Optional: Logs the currently running command for each subsystem in
        //           the SmartDashboard. This can be useful for debugging.
        SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(turret);
    }

    // Automatically created constructors.
    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
