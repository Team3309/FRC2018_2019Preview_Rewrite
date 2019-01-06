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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import org.usfirst.frc.team3309.commands.Lift_FindZero;
import org.usfirst.frc.team4322.commandv2.Subsystem;
import org.usfirst.frc.team3309.Constants;


/*
 * This class defines the lift subsystem.
 * The lift subsystem is responsible for controlling the position of the carriage.
 */
public class Lift extends Subsystem {

    /*
     * Here we set up all the various actuators and sensors that are connected to the lift.
     * The lift has 5 motor controllers, 1 double solenoid, 1 banner sensor, and 1 single solenoid.
     */
    private TalonSRX liftMaster = new TalonSRX(Constants.LIFT_MASTER_TALON_ID);
    private TalonSRX liftSlave1 = new TalonSRX(Constants.LIFT_SLAVE_TALON_1_ID);
    private VictorSPX liftSlave2 = new VictorSPX(Constants.LIFT_SLAVE_VICTOR_2_ID);
    private VictorSPX liftSlave3 = new VictorSPX(Constants.LIFT_SLAVE_VICTOR_3_ID);
    private VictorSPX liftSlave4 = new VictorSPX(Constants.LIFT_SLAVE_VICTOR_4_ID);

    private DoubleSolenoid secondStageHolder = new DoubleSolenoid(Constants.LIFT_CARRIAGE_LOCK_FORWARD_PORT, Constants.LIFT_CARRIAGE_LOCK_REVERSE_PORT);

    private DigitalInput bannerSensor = new DigitalInput(Constants.LIFT_BANNER_SENSOR);

    private Solenoid liftShifter = new Solenoid(Constants.LIFT_SHIFTER_PCM_PORT);

    public Lift() {
        liftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0,
                10);

        liftMaster.configForwardSoftLimitThreshold(Constants.LIFT_MAX_HEIGHT, 10);
        liftMaster.configForwardSoftLimitEnable(true, 10);

        liftMaster.config_kP(0, Constants.LIFT_P, 10);
        liftMaster.config_kI(0, Constants.LIFT_I, 10);
        liftMaster.config_kD(0, Constants.LIFT_D, 10);
        liftMaster.config_IntegralZone(0, Constants.LIFT_IZONE, 10);
        liftMaster.config_kF(0, Constants.LIFT_FEEDFORWARD, 10);

        liftMaster.configClosedloopRamp(Constants.LIFT_RAMP_RATE, 10);

        liftMaster.configPeakOutputForward(Constants.LIFT_MAX_FORWARD_OUTPUT, 10);
        liftMaster.configPeakOutputReverse(Constants.LIFT_MAX_REVERSE_OUTPUT, 10);

        liftMaster.setNeutralMode(NeutralMode.Brake);

        if (Constants.currentRobot == Constants.Robot.PRACTICE) {
            liftMaster.setSensorPhase(true);
            liftMaster.setInverted(false);
        }

        if (Constants.currentRobot == Constants.Robot.COMPETITION) {
            liftMaster.setInverted(false);
            liftMaster.setSensorPhase(true);
        }

        liftSlave1.follow(liftMaster);
        liftSlave2.follow(liftMaster);
        liftSlave3.follow(liftMaster);
        liftSlave4.follow(liftMaster);

        addChild(liftMaster);
        addChild(liftShifter);

        unlockSecondStage();
        setLiftShifter(true);
    }

    public void zeroLift() {
        liftMaster.setSelectedSensorPosition(0, 0, 0);

    }

    public void initDefaultCommand() {
        setDefaultCommand(new Lift_FindZero());
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

    public void lockSecondStage() {
        secondStageHolder.set(DoubleSolenoid.Value.kForward);
    }

    public void unlockSecondStage() {
        secondStageHolder.set(DoubleSolenoid.Value.kReverse);
    }

}
