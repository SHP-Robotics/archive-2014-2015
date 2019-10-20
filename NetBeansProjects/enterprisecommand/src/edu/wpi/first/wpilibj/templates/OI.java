package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * <p>
 * The operator interface class ties the commands that have been implemented to
 * the physical controls of the user. This allows you to bind the same command
 * that executes autonomous to a button. It also reveal the joystick as used by
 * the DriveWithJoysticks command.</p>
 *
 * @author Alex Henning
 */
public class OI {

    // Create the joystick and of the 8 buttons on it
    Joystick leftJoy = new Joystick(1),
            rightJoy = new Joystick(2);
    public Button Lbutton1 = new JoystickButton(leftJoy, 1),
            Lbutton2 = new JoystickButton(leftJoy, 2),
            Lbutton3 = new JoystickButton(leftJoy, 3),
            Lbutton4 = new JoystickButton(leftJoy, 4),
            Lbutton5 = new JoystickButton(leftJoy, 5),
            Lbutton6 = new JoystickButton(leftJoy, 6),
            Lbutton7 = new JoystickButton(leftJoy, 7),
            Lbutton8 = new JoystickButton(leftJoy, 8);

    /**
     * Bind the press of each button to a specific command or command group.
     */
    public OI() {

    }

    /**
     * @return The value of the left joystick.
     */
    public double getLeftSpeed() {
        return leftJoy.getY();
    }

    /**
     * @return The value of the right joystick. Note: this uses raw axis because
     * we have a logitech joystick that resembles a PS controller.
     */
    public double getRightSpeed() {
        return rightJoy.getY();
    }

    public double getTurretSpeed() {
        if (Lbutton4.get()) {
            return 0.75;
        } else if (Lbutton5.get()) {
            return -0.75;
        } else {
            return 0;
        }
    }
}
