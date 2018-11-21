package org.usfirst.frc.team3309.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team4322.commandv2.Subsystem;
import org.usfirst.frc.team3309.Constants;

public class Lift extends Subsystem {

    private TalonSRX liftMaster = new TalonSRX(Constants.LIFT_0);
    private TalonSRX lift1 = new TalonSRX(Constants.LIFT_1);
    private VictorSPX lift2 = new VictorSPX(Constants.LIFT_2);
    private VictorSPX lift3 = new VictorSPX(Constants.LIFT_3);
    private VictorSPX lift4 = new VictorSPX(Constants.LIFT_4);

    private DoubleSolenoid secondStageHolder = new DoubleSolenoid(Constants.LIFT_HOLDER_A, Constants.LIFT_HOLDER_B);

    private DigitalInput bannerSensor = new DigitalInput(Constants.LIFT_BANNER_SENSOR);

    private Solenoid liftShifter = new Solenoid(Constants.LIFT_SHIFTER);




    public Lift() {
        liftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0,
                10);

        liftMaster.configForwardSoftLimitThreshold(Constants.LIFT_FORWARD_LIM, 10);
        liftMaster.configForwardSoftLimitEnable(true, 10);

        liftMaster.config_kP(0, 0.26, 10);
        liftMaster.config_kI(0,3.2*Math.pow(10,-5),10);
        liftMaster.config_kD(0, 30, 10);
        liftMaster.config_IntegralZone(0,200,10);
        liftMaster.config_kF(0, 0.024, 10);

        liftMaster.configClosedloopRamp(0.22, 10);

        liftMaster.configPeakOutputForward(1.0, 10);
        liftMaster.configPeakOutputReverse(-0.4, 10);

        liftMaster.setNeutralMode(NeutralMode.Brake);

        if(Constants.currentRobot == Constants.Robot.PRACTICE) {
            liftMaster.setSensorPhase(true);
            liftMaster.setInverted(false);
        }

        if(Constants.currentRobot == Constants.Robot.COMPETITION) {
            liftMaster.setInverted(false);
            liftMaster.setSensorPhase(true);
        }

        lift1.follow(liftMaster);
        lift2.follow(liftMaster);
        lift3.follow(liftMaster);
        lift4.follow(liftMaster);

        unlockSecondStage();
    }

    public void sendToDashboard() {

        NetworkTable table = NetworkTableInstance.getDefault().getTable("Lift");
        table.getEntry("lift pos: ").setNumber(getPosition());
        table.getEntry("lift control mode: ").setString(liftMaster.getControlMode().toString());
        table.getEntry("lift percent mode: ").setNumber(liftMaster.getMotorOutputPercent());
        table.getEntry("lift percent output: ").setNumber(liftMaster.getMotorOutputPercent());
        table.getEntry("lift banner sensor: ").setBoolean(bannerSensor.get());
        table.getEntry("banner sensor trigger: ").setBoolean(bannerSensor.isAnalogTrigger());
    }

    public void zeroLift() {
        liftMaster.setSelectedSensorPosition(0, 0, 0);

    }

    public double getPosition() {
        return liftMaster.getSelectedSensorPosition(0);
    }


    public void set(ControlMode controlMode, double value) {
        liftMaster.set(controlMode, value);
    }

    public void setLiftShifter(boolean value) {
        liftShifter.set(value);
    }

    public boolean isAtBottom() {
        return bannerSensor.get();
    }

    public double getError() {
        return liftMaster.getClosedLoopError(0);
    }

    public void unlockSecondStage() {
        secondStageHolder.set(DoubleSolenoid.Value.kForward);
    }

    public void lockSecondStage() {
        secondStageHolder.set(DoubleSolenoid.Value.kReverse);
    }

}
