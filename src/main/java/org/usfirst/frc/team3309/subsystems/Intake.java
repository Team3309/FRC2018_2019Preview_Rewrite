package org.usfirst.frc.team3309.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import org.usfirst.frc.team3309.Constants;
import org.usfirst.frc.team3309.commands.Intake_Teleop;
import org.usfirst.frc.team4322.commandv2.Subsystem;

/*
 * This subsystem controls the Intake.
 * The intake consists of 2 motor controllers.
 */
public class Intake extends Subsystem {

    private WPI_VictorSPX leftMotor = new WPI_VictorSPX(Constants.INTAKE_LEFT_VICTOR_ID);
    private WPI_VictorSPX rightMotor = new WPI_VictorSPX(Constants.INTAKE_RIGHT_VICTOR_ID);

    public Intake() {
        leftMotor.set(ControlMode.Disabled,0);
        rightMotor.set(ControlMode.Disabled,0);
        addChild(leftMotor);
        addChild(rightMotor);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new Intake_Teleop());
    }

    public void setLeftRight(double left, double right) {
        leftMotor.set(ControlMode.PercentOutput, -left);
        rightMotor.set(ControlMode.PercentOutput, -right);
    }
}
