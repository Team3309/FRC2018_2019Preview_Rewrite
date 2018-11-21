package org.usfirst.frc.team3309.commands;

import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class Arms_Clamp extends Command {

    public Arms_Clamp() {
        require(Robot.arms);
    }

    @Override
    protected void execute() {
       Robot.arms.clampArms();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
