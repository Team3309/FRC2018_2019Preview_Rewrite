package org.usfirst.frc.team3309.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

/*
 * This command handles moving the lift in autonomous.
 */
public class Lift_Elevate extends Command {

    private double goalPos;
    private final double ERROR_THRESHOLD = 400;

    public Lift_Elevate(double goalPos) {
        this(goalPos,0);
    }

    public Lift_Elevate(double goalPos, double timeout) {
        super(timeout);
        this.goalPos = goalPos;
        require(Robot.lift);
    }

    @Override
    protected void execute() {
            Robot.lift.set(ControlMode.Position,goalPos);
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Robot.lift.getPosition() - goalPos) < ERROR_THRESHOLD;
    }

    @Override
    public void end() {
        super.end();
        System.out.println("The lift finished! " + Robot.lift.getPosition());
    }

}
