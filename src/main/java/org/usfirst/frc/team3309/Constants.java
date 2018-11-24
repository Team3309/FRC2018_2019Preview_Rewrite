package org.usfirst.frc.team3309;


import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;


/*
 * This class holds all the key values that control how the robot functions.
 * The values are kept in one place so its easy to find them when you need to make a change.
 */
public class Constants {


    /*
     * These MAC_ADDR values are just unique IDs for each of the roboRIO's used in 2018
     * They are used to identify which robot the code is running on, because some values are specific to each robot.
     */
    private static final byte[] PRACTICEBOT_MAC_ADDR = {0x00, (byte) 0x80, 0x2F, 0x17, (byte) 0x85, (byte) 0xD3};
    private static final byte[] COMPBOT_MAC_ADDR = {0x00, (byte)0x80, 0x2F, 0x17, (byte) 0xE4, 0x5E}; // find this at comp

    /*
     * This enum defines a type with 2 values, PRACTICE and COMPETITION
     * These values represent our COMPETITION robot and PRACTICE robot.
     */
    public enum Robot {
        PRACTICE,
        COMPETITION
    }

    /*
     * This holds an instance of the type we defined above.
     * The static block beneath it just handles fetching the address of the rio we are running on
     * and sets currentRobot to the appropriate value
     */
    public static Robot currentRobot;

    static {
        try {
            byte[] rioMac = NetworkInterface.getByName("eth0").getHardwareAddress();
            if (Arrays.equals(rioMac, PRACTICEBOT_MAC_ADDR)) {
                currentRobot = Robot.PRACTICE;
            } else if (Arrays.equals(rioMac, COMPBOT_MAC_ADDR)) {
                currentRobot = Robot.COMPETITION;
            } else {
                currentRobot = null;
                System.err.println("Oh no! Unknown robot! Did somebody install a new rio?");
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
    }


    //===========================
    //= DRIVEBASE PORT MAPPINGS =
    //===========================

    // These are the CAN IDs for the DriveBase motor controllers.
    public static final int DRIVE_RIGHT_MASTER_TALON_ID = 11;
    public static final int DRIVE_RIGHT_SLAVE_VICTOR_1_ID = 13;
    public static final int DRIVE_RIGHT_SLAVE_VICTOR_2_ID = 15;
    public static final int DRIVE_LEFT_MASTER_TALON_ID = 10;
    public static final int DRIVE_LEFT_SLAVE_VICTOR_1_ID = 12;
    public static final int DRIVE_LEFT_SLAVE_VICTOR_2_ID = 14;

    // This is the PCM solenoid port that the gearbox shifter is connected
    public static final int DRIVE_SHIFTER_PCM_PORT = 7;


    //==============================
    //= DRIVEBASE TUNING CONSTANTS =
    //==============================

    // There is no logical reason why this is 9.6. it just be like that.
    // Don't question it, and dont touch it!
    // This value being wrong was part of why the robot took a fat L at AVR.
    public static final double DRIVE_ENCODER_COUNTS_PER_REV = 4096*9.6;
    public static final int DRIVEBASE_ACCELERATION = 30000;
    public static final double WHEEL_DIAMETER_INCHES = 6.0;
    public static final double WHEELBASE_INCHES = 26;
    public static final double DRIVEBASE_P = 0.019;
    public static final double DRIVEBASE_I = 0.0006;
    public static final double DRIVEBASE_D = 0.002;


    //========================
    //= INTAKE PORT MAPPINGS =
    //========================

    public static final int INTAKE_LEFT_VICTOR_ID = 40;
    public static final int INTAKE_RIGHT_VICTOR_ID = 41;

    //========================
    //= INTAKE TUNING VALUES =
    //========================

    public static final double AUTON_INTAKE_POWER = -1;

    //=====================
    //= ARM PORT MAPPINGS =
    //=====================

    public static final int ARMS_PISTON_FORWARD_PORT = 2;
    public static final int ARMS_PISTON_REVERSE_PORT = 1;

    //======================
    //= LIFT PORT MAPPINGS =
    //======================

    public static final int LIFT_MASTER_TALON_ID = 20;
    public static final int LIFT_SLAVE_TALON_1_ID = 21;
    public static final int LIFT_SLAVE_VICTOR_2_ID = 22;
    public static final int LIFT_SLAVE_VICTOR_3_ID = 23;
    public static final int LIFT_SLAVE_VICTOR_4_ID = 24;

    public static final int LIFT_SHIFTER_PCM_PORT = 6;

    public static final int LIFT_BANNER_SENSOR = 0;

    public static final int LIFT_CARRIAGE_LOCK_FORWARD_PORT = 3;
    public static final int LIFT_CARRIAGE_LOCK_REVERSE_PORT = 0;

    //======================
    //= LIFT TUNING VALUES =
    //======================

    public static final int LIFT_MAX_HEIGHT = 44000;
    public static final double LIFT_NUDGE_SPEED = 6955; // viva chile!

    public static final double LIFT_P = 0.26;
    public static final double LIFT_I = 3.2*Math.pow(10,-5);
    public static final double LIFT_D = 30;
    public static final double LIFT_FEEDFORWARD = 0.024;
    public static final int LIFT_IZONE = 200;
    public static final double LIFT_RAMP_RATE = .22;

    public static final double LIFT_MAX_FORWARD_OUTPUT = 1.0;
    public static final double LIFT_MAX_REVERSE_OUTPUT = -0.4;


    public static double LIFT_BOTTOM_POSITION = 0;
    public static double LIFT_INTAKE_POSITION = 1100;
    public static double LIFT_EXCHANGE_POSITION = 700;
    public static double LIFT_SWITCH_POSITION = 15000;
    public static double LIFT_SCALE_LOW_POSITION = 31000;
    public static double LIFT_SCALE_MIDDLE_POSITION = 36000;
    public static double LIFT_SCALE_HIGH_POSITION = 39000;

    //=========================
    //= BELTBAR PORT MAPPINGS =
    //=========================

    public static final int BELTBAR_TALON_ID = 31;

    //=========================
    //= BELTBAR TUNING VALUES =
    //=========================

    public static final int BELTBAR_MAX_CURRENT = 18;
    public static final int BELTBAR_MAX_CURRENT_DURATION = 125;
    public static final int BELTBAR_MAX_CONTINUOUS_CURRENT = 1;

    public static int BELTBAR_FORWARD_SOFT_LIMIT;
    public static int BELTBAR_REVERSE_SOFT_LIMIT;

    public static final double BELTBAR_P = 0.7;
    public static final double BELTBAR_I = 0;
    public static final double BELTBAR_D = 0;
    public static final int BELTBAR_IZONE = 0;
    public static final double BELTBAR_FEEDFORWARD = 0.03;

    public static double BELTBAR_BOTTOM_POSITION;
    public static double BELTBAR_INTAKE_POSITION;
    public static double BELTBAR_EXCHANGE_POSITION;
    public static double BELTBAR_EJECT_POSITION;
    public static double BELTBAR_SCALE_HIGH_POSITION;
    public static double BELTBAR_SWITCH_POSITION;
    public static double BELTBAR_CLIMB_POSITION;

    //=============================
    //= FALCON DOOR PORT MAPPINGS =
    //=============================

    public static final int FALCON_DOOR_SOLENOID_PCM_PORT = 4;

    //=====================
    //= LED PORT MAPPINGS =
    //=====================

    public static final int LED_CHANNEL = 1;

    /*
     * This function populates values that have a robot specific value.
     * It's important to call it from robotInit!
     */
    public static void configureRobotSpecificConstants() {
        if (Constants.currentRobot == Constants.Robot.PRACTICE) {
            BELTBAR_REVERSE_SOFT_LIMIT = -2840;
            BELTBAR_FORWARD_SOFT_LIMIT = -1200;
            BELTBAR_BOTTOM_POSITION = -2680;
            BELTBAR_INTAKE_POSITION = -1550;
            BELTBAR_EXCHANGE_POSITION = -1800;
            BELTBAR_EJECT_POSITION = -2400;
            BELTBAR_SCALE_HIGH_POSITION = -2550;
            BELTBAR_SWITCH_POSITION = -2000;
            BELTBAR_CLIMB_POSITION = -2800;
        }

        if (Constants.currentRobot == Constants.Robot.COMPETITION) {
            BELTBAR_REVERSE_SOFT_LIMIT = -4700;
            BELTBAR_FORWARD_SOFT_LIMIT = -3050;
            BELTBAR_BOTTOM_POSITION = -4500;
            BELTBAR_INTAKE_POSITION = -3350;
            BELTBAR_EXCHANGE_POSITION = -3600;
            BELTBAR_EJECT_POSITION = -4100;
            BELTBAR_SCALE_HIGH_POSITION = -4300;
            BELTBAR_SWITCH_POSITION = -3500;
            BELTBAR_CLIMB_POSITION = -4500;
        }

    }
}
