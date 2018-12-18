package org.usfirst.frc.team3309.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3309.Constants;
import org.usfirst.frc.team4322.commandv2.Subsystem;
/*
 * Arms subsystem.
 * Just 1 DoubleSolenoid.
 */
public class Arms extends Subsystem {

    private DoubleSolenoid actuator = new DoubleSolenoid(Constants.ARMS_PISTON_FORWARD_PORT,
            Constants.ARMS_PISTON_REVERSE_PORT);

    public Arms() {
//        RobotPerformanceData.addToLog(() -> new Pair<String,Object>("Arm Actuator Value: ",actuator.get().toString())
//        );
        addChild(actuator);
    }

    public void openArms() {
        actuator.set(DoubleSolenoid.Value.kReverse);
    }

    public void clampArms() {
        actuator.set(DoubleSolenoid.Value.kForward);
    }
}
