package org.usfirst.frc.team3309.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import org.usfirst.frc.team4322.commandv2.Subsystem;

import org.usfirst.frc.team3309.Constants;

/*
 * This is the Beltbar subsystem.
 * The beltbar has 1 talon.
 */
public class BeltBar extends Subsystem {

    private WPI_TalonSRX masterBar = new WPI_TalonSRX(Constants.BELTBAR_TALON_ID);

    private boolean disabledForClimb = false;

    public BeltBar() {
        masterBar.setInverted(false);
        masterBar.setSensorPhase(true);

        masterBar.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);

        masterBar.config_kP(0, Constants.BELTBAR_P, 10);
        masterBar.config_kI(0, Constants.BELTBAR_I, 10);
        masterBar.config_kD(0, Constants.BELTBAR_D, 10);
        masterBar.config_kF(0, Constants.BELTBAR_FEEDFORWARD, 10);
        masterBar.config_IntegralZone(0, Constants.BELTBAR_IZONE, 10);

        masterBar.configForwardSoftLimitThreshold(Constants.BELTBAR_FORWARD_SOFT_LIMIT, 10);
        masterBar.configForwardSoftLimitEnable(true, 10);
        masterBar.configReverseSoftLimitThreshold(Constants.BELTBAR_REVERSE_SOFT_LIMIT, 10);
        masterBar.configReverseSoftLimitEnable(true, 10);
        masterBar.setNeutralMode(NeutralMode.Brake);
        masterBar.configPeakCurrentLimit(Constants.BELTBAR_MAX_CURRENT, 10);
        masterBar.configPeakCurrentDuration(Constants.BELTBAR_MAX_CURRENT_DURATION, 10);
        masterBar.configContinuousCurrentLimit(Constants.BELTBAR_MAX_CONTINUOUS_CURRENT, 10);
        masterBar.enableCurrentLimit(true);

//        RobotPerformanceData.addToLog(
//                () -> new Pair<String,Object>("Beltbar Current Draw: ",masterBar.getOutputCurrent()),
//                () -> new Pair<String,Object>("Beltbar Encoder Position: ",getPosition()),
//                () -> new Pair<String,Object>("Beltbar Raw Output: ",masterBar.getMotorOutputPercent()),
//                () -> new Pair<String,Object>("Beltbar Error: ",masterBar.getClosedLoopError())
//        );
        addChild(masterBar);

    }

    public void beginClimb() {
        disabledForClimb = true;
        masterBar.set(ControlMode.Disabled,0);
        masterBar.configForwardSoftLimitEnable(false, 10);
        masterBar.configReverseSoftLimitEnable(false, 10);
    }

    public void set(ControlMode controlMode, double value) {
        if(!disabledForClimb) {
            masterBar.set(controlMode, value);
        }
    }

    public double getPosition() {
        return masterBar.getSelectedSensorPosition(0);
    }


}
