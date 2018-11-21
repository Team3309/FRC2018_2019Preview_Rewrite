package org.usfirst.frc.team3309.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class Lift_FindZero extends Command {

    private double start = Double.POSITIVE_INFINITY;
    private final double DESIRED_TIME_ELUDED = 0.3;
    private boolean hasStarted = false;

    private boolean isZeroed = false;

    @Override
    protected void execute() {
        if (Robot.lift.isAtBottom() && !isZeroed) {
            if (!hasStarted) {
                start = Timer.getFPGATimestamp();
                hasStarted = true;
            } else {
                double timeEluded = Timer.getFPGATimestamp() - start;
                if (timeEluded > DESIRED_TIME_ELUDED) {
                    Robot.lift.zeroLift();
                    hasStarted = false;
                }
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return isZeroed;
    }

}
