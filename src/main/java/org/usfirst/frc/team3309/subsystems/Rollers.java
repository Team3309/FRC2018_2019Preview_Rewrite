package org.usfirst.frc.team3309.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import org.usfirst.frc.team3309.Constants;
import org.usfirst.frc.team4322.commandv2.Subsystem;

public class Rollers extends Subsystem {

    private VictorSPX leftMotor = new VictorSPX(Constants.ROLLER_LEFT);
    private VictorSPX rightMotor = new VictorSPX(Constants.ROLLER_RIGHT);

    private boolean enableRollerPower = false;
    private double defaultAutoPower = Constants.AUTO_ROLLER_INTAKE_POWER;

    public Rollers() {
        leftMotor.set(ControlMode.Disabled,0);
        rightMotor.set(ControlMode.Disabled,0);
    }

    public void setLeftRight(double left, double right) {
        leftMotor.set(ControlMode.PercentOutput, -left);
        rightMotor.set(ControlMode.PercentOutput, -right);
    }
}
