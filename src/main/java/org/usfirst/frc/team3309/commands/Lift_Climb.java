package org.usfirst.frc.team3309.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class Lift_Climb extends Command {

    private final double MAX_POWER = 0.775;

    public Lift_Climb() {
        require(Robot.lift);
    }

    @Override
    public void execute() {
        double power = Robot.oi.getOperatorController().getLeftStick().getY();
       if (Math.abs(power) > MAX_POWER) {
           power = Math.signum(power) * MAX_POWER;
       }
        Robot.lift.set(ControlMode.PercentOutput,power);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
