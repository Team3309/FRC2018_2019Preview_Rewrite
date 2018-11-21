package org.usfirst.frc.team3309.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team3309.Constants;
import org.usfirst.frc.team4322.commandv2.Subsystem;

public class DriveBase extends Subsystem {

    private TalonSRX driveLeftMaster,driveRightMaster;
    private VictorSPX driveLeftSlave1,driveRightSlave1;
    private VictorSPX driveLeftSlave2,driveRightSlave2;
    private Solenoid shifter;
    private AHRS navx;

    public DriveBase() {
        driveLeftMaster = new TalonSRX(Constants.DRIVE_LEFT_0_ID);
        driveLeftSlave1 = new VictorSPX(Constants.DRIVE_LEFT_1_ID);
        driveLeftSlave2 = new VictorSPX(Constants.DRIVE_LEFT_2_ID);
        driveRightMaster = new TalonSRX(Constants.DRIVE_RIGHT_0_ID);
        driveRightSlave1 = new VictorSPX(Constants.DRIVE_RIGHT_1_ID);
        driveRightSlave2 = new VictorSPX(Constants.DRIVE_RIGHT_2_ID);
        shifter = new Solenoid(Constants.DRIVE_SHIFTER);
        navx = new AHRS(SPI.Port.kMXP);

        //Configure Left Side of Drive
        driveLeftMaster.configPeakOutputForward(1.0, 10);
        driveLeftMaster.configPeakOutputReverse(-1.0, 10);
        driveLeftMaster.configNominalOutputForward(0.0, 10);
        driveLeftMaster.configNominalOutputReverse(-0.0, 10);
        driveLeftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        driveLeftMaster.configOpenloopRamp(0, 10);
        driveLeftMaster.configMotionAcceleration(30000, 10);
        driveLeftMaster.config_kP(0, Constants.DRIVEBASE_P, 10);
        driveLeftMaster.config_kD(0, Constants.DRIVEBASE_I, 10);
        driveLeftMaster.config_kF(0, Constants.DRIVEBASE_D, 10);
        driveLeftMaster.setNeutralMode(NeutralMode.Brake);

        driveLeftSlave1.follow(driveLeftMaster);
        driveLeftSlave2.follow(driveLeftMaster);

        //Configure Right Side of Drive
        driveRightMaster.configPeakOutputForward(1.0, 10);
        driveRightMaster.configPeakOutputReverse(-1.0, 10);
        driveRightMaster.configNominalOutputForward(0.0, 10);
        driveRightMaster.configNominalOutputReverse(-0.0, 10);
        driveRightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        driveRightMaster.configOpenloopRamp(0, 10);
        driveRightMaster.configMotionAcceleration(30000, 10);
        driveRightMaster.config_kP(0, Constants.DRIVEBASE_P, 10);
        driveRightMaster.config_kD(0, Constants.DRIVEBASE_I, 10);
        driveRightMaster.config_kF(0, Constants.DRIVEBASE_D, 10);
        driveRightMaster.setNeutralMode(NeutralMode.Brake);

        driveRightSlave1.follow(driveRightMaster);
        driveRightSlave2.follow(driveRightMaster);
    }


    public double encoderCountsToInches(double counts) {
        return counts / Constants.DRIVE_ENCODER_COUNTS_PER_REV * (Math.PI * Constants.WHEEL_DIAMETER_INCHES);
    }

    public double inchesToEncoderCounts(double inches) {
        return inches * (Constants.DRIVE_ENCODER_COUNTS_PER_REV / (Math.PI * Constants.WHEEL_DIAMETER_INCHES));
    }


    public void reset() {
        driveLeftMaster.clearMotionProfileTrajectories();
        driveRightMaster.clearMotionProfileTrajectories();
        driveLeftMaster.setSelectedSensorPosition(0, 0,0);
        driveRightMaster.setSelectedSensorPosition(0, 0,0);
        navx.zeroYaw();
    }


    public void zeroNavx() {
        navx.zeroYaw();
    }

    public double getEncoderPos() {
        return (getLeftEncoder() + getRightEncoder()) / 2.0;
    }

    public double getLeftEncoder() {
        return driveLeftMaster.getSelectedSensorPosition(0);
    }

    public double getRightEncoder() {
        return -driveRightMaster.getSelectedSensorPosition(0);
    }

    public double getVelocity() {
        return (getLeftVelocity() + getRightVelocity()) / 2.0;
    }

    public int getLeftVelocity() {
        return driveLeftMaster.getSelectedSensorVelocity(0);
    }

    public double getRightVelocity() {
        return -driveRightMaster.getSelectedSensorVelocity(0);
    }

    public double getAngPos() {
        return -navx.getAngle();
    }

    public double getAngVel() {
        return navx.getRate();
    }

    public void setHighGear() {
        shifter.set(false);
    }

    public void setLowGear() {
        shifter.set(true);
    }

    public boolean inHighGear() {
        return !shifter.get();
    }

    public void setLeftRight(ControlMode mode,double left, double right) {
        driveLeftMaster.set(mode,left);
        driveRightMaster.set(mode,-right);
    }


}
