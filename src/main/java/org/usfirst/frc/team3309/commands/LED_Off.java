package org.usfirst.frc.team3309.commands;

import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class LED_Off extends Command {

    public LED_Off() {
        require(Robot.led);
    }


    @Override
    public void execute() {
        Robot.led.set(false);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
