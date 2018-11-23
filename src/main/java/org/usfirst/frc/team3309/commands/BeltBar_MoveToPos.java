package org.usfirst.frc.team3309.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class BeltBar_MoveToPos extends Command {

    private double goalPosition;
    public static final double ERROR_THRESHOLD = 250;



    public BeltBar_MoveToPos(double goalPosition) {
        this.goalPosition = goalPosition;
        require(Robot.beltBar);
    }

    @Override
    protected void initialize() {
        Robot.beltBar.set(ControlMode.Position, goalPosition);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Robot.beltBar.getPosition()- goalPosition) < ERROR_THRESHOLD;
    }

}
