package org.usfirst.frc.team3309.commands;

import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

/*
 * This command unlocks the lift's second stage.
 */
public class Lift_UnlockSecondStage extends Command {

    @Override
    protected void execute() {
        Robot.lift.unlockSecondStage();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}
