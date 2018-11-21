package org.usfirst.frc.team3309.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team3309.Constants;
import org.usfirst.frc.team4322.commandv2.Subsystem;

public class Arms extends Subsystem {

    private DoubleSolenoid actuator = new DoubleSolenoid(Constants.ARMS_ACTUATOR_A,
            Constants.ARMS_ACTUATOR_B);

    private Solenoid otherActuator = new Solenoid(Constants.ARMS_OTHER_ACTUATOR);

    public void openArms() {
        actuator.set(DoubleSolenoid.Value.kReverse);
    }

    public void clampArms() {
        actuator.set(DoubleSolenoid.Value.kForward);
    }

    public void middleArms() {
        actuator.set(DoubleSolenoid.Value.kForward);
    }

    public boolean isArmsClosed() {
        return actuator.get() == DoubleSolenoid.Value.kReverse;
    }

}
