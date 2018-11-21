package org.usfirst.frc.team3309.commands;

import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class Lift_LockSecondStage extends Command {

    @Override
    protected void execute() {
        Robot.lift.lockSecondStage();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}
