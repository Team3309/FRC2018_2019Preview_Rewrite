package org.usfirst.frc.team3309.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team3309.Robot;
import org.usfirst.frc.team4322.commandv2.Command;

public class Intake_Actuate extends Command {

    private double time;
    private double start;
    private boolean isInit = false;
    private final double intakeRollerPower;

    public Intake_Actuate(double intakeRollerPower, double time) {
        this.intakeRollerPower = intakeRollerPower;
        this.time = time;
        require(Robot.intake);
    }

    @Override
    public void initialize() {
        start = Timer.getFPGATimestamp();
    }

    @Override
    protected void execute() {
        Robot.intake.setLeftRight(intakeRollerPower, -intakeRollerPower);
    }

    @Override
    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - start >= time;
    }

    @Override
    public void end() {
        isInit = false;
        start = Double.POSITIVE_INFINITY;
        Robot.intake.setLeftRight(0, 0);
    }
}
