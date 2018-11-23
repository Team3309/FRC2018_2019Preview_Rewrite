package org.usfirst.frc.team3309.commands;

import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class FalconDoors_Deploy extends Command {

    public FalconDoors_Deploy() {
        require(Robot.falconDoor);
    }

    @Override
    protected void execute() {
        Robot.falconDoor.release();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
