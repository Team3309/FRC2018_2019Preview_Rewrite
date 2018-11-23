package org.usfirst.frc.team3309.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team3309.Constants;
import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

/*
 * This command is a little complicated.
 * It works a lot like Lift_Elevate,
 * but allows the operator to manually move the setpoint around.
 * This makes it easy to fine tune the lift position.
 */
public class Lift_HybridMove extends Command {
    // Store the current target angle
    private double goalPosition;
    // Store the last position of the lift.
    private double last = 0;
    private double startingPosition;

    public Lift_HybridMove(double goalPosition) {
        require(Robot.lift);
        this.goalPosition = goalPosition;
        startingPosition = goalPosition;
    }

    @Override
    protected void initialize() {
        //put the current time into last.
        // we need to know how long it has been since we last moved the lift
        // in order to calculate the offset to apply.
        last = Timer.getFPGATimestamp();
    }

    @Override
    protected void execute() {
        //get the current time
        double now = Timer.getFPGATimestamp();

        // multiply the nudge speed constant with the time since last move,
        // and multiply that times the input from the operator's left stick y axis.
        double offset = Constants.LIFT_NUDGE_SPEED * (Timer.getFPGATimestamp() - last) * Robot.oi.getOperatorController().getLeftStick().y();

        // add the offset to the lift position
        goalPosition += offset;

        // Bound the new target position between the max lift height and zero.
        if (goalPosition > Constants.LIFT_MAX_HEIGHT) {
            goalPosition = Constants.LIFT_MAX_HEIGHT;
        } else if (goalPosition < 0) {
            goalPosition = 0;
        }

        // send the new target position to the lift talon
        Robot.lift.set(ControlMode.Position, goalPosition);

        //update the time of the last run to now.
        last = now;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
        //when we finish. restore goalposition to its initial value.
        goalPosition = startingPosition;
    }
}
