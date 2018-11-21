package org.usfirst.frc.team3309.commands;

import org.usfirst.frc.team4322.commandv2.Command;
import org.usfirst.frc.team3309.Robot;

public class Arms_Open extends Command {

    public Arms_Open() {
        require(Robot.arms);
    }

    @Override
    protected void execute() {
        Robot.arms.openArms();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
