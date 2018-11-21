package org.usfirst.frc.team3309.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class Rollers_Actuate extends Command {

    private double time;
    private double start;
    private boolean isInit = false;
    private final double intakeRollerPower;

    public Rollers_Actuate(double intakeRollerPower, double time) {
        this.intakeRollerPower = intakeRollerPower;
        this.time = time;
        require(Robot.rollers);
    }

    @Override
    public void initialize() {
        start = Timer.getFPGATimestamp();
    }

    @Override
    protected void execute() {
        Robot.rollers.setLeftRight(intakeRollerPower, -intakeRollerPower);
    }

    @Override
    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - start >= time;
    }

    @Override
    public void end() {
        isInit = false;
        start = Double.POSITIVE_INFINITY;
        Robot.rollers.setLeftRight(0, 0);
    }
}
