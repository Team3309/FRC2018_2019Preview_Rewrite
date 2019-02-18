package org.usfirst.frc.team3309.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team3309.Constants;
import org.usfirst.frc.team4322.commandv2.Subsystem;

/*
 * This subsystem controls the Falcon Door.
 * The intake consists of a single solenoids.
 */
public class FalconDoor extends Subsystem {

    private Solenoid shifter = new Solenoid(Constants.FALCON_DOOR_SOLENOID_PCM_PORT);

    public FalconDoor() {
//        addChild(shifter);
    }

    public void release() {
        shifter.set(true);
    }

}
