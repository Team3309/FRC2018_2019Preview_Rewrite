package org.usfirst.frc.team3309.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import org.usfirst.frc.team4322.commandv2.Subsystem;

import org.usfirst.frc.team3309.Constants;

public class BeltBar extends Subsystem {

    private TalonSRX masterBar = new TalonSRX(Constants.BELTBAR_TALON_ID);




    private boolean disabledForClimb = false;

    public BeltBar() {
        masterBar.setInverted(false);
        masterBar.setSensorPhase(true);

        masterBar.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);

        masterBar.config_kP(0, 3, 10);
        masterBar.config_kI(0, 0, 10);
        masterBar.config_kD(0, 0.5, 10);
        masterBar.config_kF(0, 0.04, 10);
        masterBar.config_IntegralZone(0, 0, 0);
        masterBar.clearStickyFaults(10);


        masterBar.configForwardSoftLimitThreshold(Constants.BELTBAR_FORWARD_SOFT_LIM, 10);
        masterBar.configForwardSoftLimitEnable(false, 10);
        masterBar.configReverseSoftLimitThreshold(Constants.BELTBAR_REVERSE_SOFT_LIM, 10);
        masterBar.configReverseSoftLimitEnable(false, 10);
        masterBar.setNeutralMode(NeutralMode.Brake);
        masterBar.configPeakCurrentLimit(Constants.BELTBAR_MAX_CURRENT, 10);
        masterBar.configPeakCurrentDuration(Constants.BELTBAR_MAX_CURRENT_DURATION, 10);
        masterBar.configContinuousCurrentLimit(1, 10);
        masterBar.enableCurrentLimit(true);

    }

    public void beginClimb() {
        disabledForClimb = true;
        masterBar.set(ControlMode.Disabled,0);
        masterBar.configForwardSoftLimitEnable(false, 10);
        masterBar.configReverseSoftLimitEnable(false, 10);
    }


    public void sendToDashboard() {
        ShuffleboardTab beltbar = Shuffleboard.getTab("Beltbar");
        beltbar.add("Position: ", getPosition());
        ShuffleboardLayout talonInfo = beltbar.getLayout("List","Talon Values");
        talonInfo.add("Raw Output: ",masterBar.getMotorOutputPercent());
        talonInfo.add("Control Mode: ",masterBar.getControlMode().toString());
        talonInfo.add("Current Draw: ",masterBar.getOutputCurrent());
        Shuffleboard.update();
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
