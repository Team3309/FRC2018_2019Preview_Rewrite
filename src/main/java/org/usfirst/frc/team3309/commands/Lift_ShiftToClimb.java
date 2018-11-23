package org.usfirst.frc.team3309.commands;

import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

/*
 * This command shifts the lift into climb mode.
 */
public class Lift_ShiftToClimb extends Command {
    @Override
    protected void execute() {
        Robot.lift.setLiftShifter(false);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
