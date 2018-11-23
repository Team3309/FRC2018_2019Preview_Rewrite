package org.usfirst.frc.team3309.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import org.usfirst.frc.team3309.Constants;
import org.usfirst.frc.team4322.commandv2.Subsystem;

/*
 * This subsystem controls the Intake.
 * The intake consists of 2 motor controllers.
 */
public class Intake extends Subsystem {

    private VictorSPX leftMotor = new VictorSPX(Constants.INTAKE_LEFT_VICTOR_ID);
    private VictorSPX rightMotor = new VictorSPX(Constants.INTAKE_RIGHT_VICTOR_ID);

    public Intake() {
        leftMotor.set(ControlMode.Disabled,0);
        rightMotor.set(ControlMode.Disabled,0);
    }

    public void setLeftRight(double left, double right) {
        leftMotor.set(ControlMode.PercentOutput, -left);
        rightMotor.set(ControlMode.PercentOutput, -right);
    }
}
