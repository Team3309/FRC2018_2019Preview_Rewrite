package org.usfirst.frc.team3309.commands;

import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class Intake_Teleop extends Command {

    private final double MIN_POWER = 0.1;
    private final double MAX_OUT_POWER = 0.7;

    public Intake_Teleop() {
        require(Robot.intake);
        setInterruptBehavior(InterruptBehavior.Suspend);
    }

    @Override
    public void initialize() {
        Robot.intake.setLeftRight(0, 0);
    }

    @Override
    protected void execute() {
        double leftTrigger = Robot.oi.getOperatorController().getLt().axis();
        double rightTrigger = Robot.oi.getOperatorController().getRt().axis();

        if (Math.abs(leftTrigger) > MIN_POWER) {
                Robot.intake.setLeftRight(-rescale(leftTrigger)* MAX_OUT_POWER, rescale(leftTrigger)*MAX_OUT_POWER);
        } else if (Math.abs(rightTrigger) > MIN_POWER) {
                Robot.intake.setLeftRight(rescale(rightTrigger),-rescale(rightTrigger));
        } else {
            Robot.intake.setLeftRight(0, 0);
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
