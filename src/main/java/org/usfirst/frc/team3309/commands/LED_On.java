package org.usfirst.frc.team3309.commands;

import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class LED_On extends Command {

    public LED_On() {
        require(Robot.led);
    }


    @Override
    public void execute() {
        Robot.led.set(true);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
