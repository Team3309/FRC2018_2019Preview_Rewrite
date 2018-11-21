package org.usfirst.frc.team3309.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team3309.Constants;
import org.usfirst.frc.team4322.commandv2.Subsystem;

public class FalconDoors extends Subsystem {

    private Solenoid shifter = new Solenoid(Constants.FALCONDOORS_SOLENOID);

    public void setDown() {
        shifter.set(true);
    }

    public void setUp() {
        shifter.set(false);
    }

}
