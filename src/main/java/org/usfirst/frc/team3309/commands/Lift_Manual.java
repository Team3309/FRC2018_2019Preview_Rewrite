package org.usfirst.frc.team3309.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

/*
 * This command handles manual control of the lift for climbing.
 * It just runs the lift in manual power mode
 */
public class Lift_Manual extends Command {


    public Lift_Manual() {
        require(Robot.lift);
    }

    @Override
    public void execute() {
        double power = Robot.oi.getOperatorController().getLeftStick().y();
        Robot.lift.set(ControlMode.PercentOutput,power);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
