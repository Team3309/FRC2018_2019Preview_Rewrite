package org.usfirst.frc.team3309.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import org.usfirst.frc.team3309.Constants;
import org.usfirst.frc.team4322.commandv2.Subsystem;

public class LED extends Subsystem {

    private DigitalOutput indicatorLight = new DigitalOutput(Constants.LED_CHANNEL);

    public void set(boolean on) {
        indicatorLight.set(true);
    }

}
