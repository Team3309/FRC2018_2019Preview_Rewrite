package org.usfirst.frc.team3309.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team3309.Constants;
import org.usfirst.frc.team3309.OI;
import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class Lift_HybridMove extends Command {
    private double goalAngle;
    private double last = 0;
    private boolean started = false;
    private double origAngle;

    public Lift_HybridMove(double goalAngle) {
        this.goalAngle = goalAngle;
        origAngle = goalAngle;
        require(Robot.lift);
    }

    @Override
    protected void execute() {
        double now = Timer.getFPGATimestamp();

        if (!started) {
            last = Timer.getFPGATimestamp();
            started = true;
        }

        double offset = Constants.LIFT_NUDGE_SPEED * (Timer.getFPGATimestamp() - last) * Robot.oi.getOperatorController().getLeftStick().getY();

        if (goalAngle + offset > Constants.LIFT_FORWARD_LIM - 2000) {
            goalAngle = Constants.LIFT_FORWARD_LIM - 2000;
        } else if (goalAngle + offset < 0) {
            goalAngle = 0;
        } else {
            goalAngle += offset;
        }

        Robot.lift.set(ControlMode.Position,goalAngle);
        last = now;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
        started = false;
        goalAngle = origAngle;
    }
}
