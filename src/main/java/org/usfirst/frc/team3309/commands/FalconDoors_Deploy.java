package org.usfirst.frc.team3309.commands;

import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class FalconDoors_Deploy extends Command {

    public FalconDoors_Deploy() {
        require(Robot.falconDoors);
    }

    @Override
    protected void execute() {
        Robot.falconDoors.setDown();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
