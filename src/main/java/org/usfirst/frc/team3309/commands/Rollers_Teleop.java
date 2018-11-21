package org.usfirst.frc.team3309.commands;

import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class Rollers_Teleop extends Command {

    private final double MIN_POWER = 0.1;
    private final double MAX_OUT_POWER = 0.7;

    public Rollers_Teleop() {
        require(Robot.rollers);
        setInterruptBehavior(InterruptBehavior.Suspend);
    }

    @Override
    public void initialize() {
        Robot.rollers.setLeftRight(0, 0);
    }

    @Override
    protected void execute() {
        double leftTrigger = Robot.oi.getOperatorController().getLt().getY();
        double rightTrigger = Robot.oi.getOperatorController().getRt().getY();

        if (Math.abs(leftTrigger) > MIN_POWER) {
                Robot.rollers.setLeftRight(-rescale(leftTrigger)* MAX_OUT_POWER, rescale(leftTrigger)*MAX_OUT_POWER);
        } else if (Math.abs(rightTrigger) > MIN_POWER) {
                Robot.rollers.setLeftRight(rescale(rightTrigger),-rescale(rightTrigger));
        } else {
            Robot.rollers.setLeftRight(0, 0);
        }

    }

    private double rescale(double val)
    {
        return Math.copySign(val*val,val);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
