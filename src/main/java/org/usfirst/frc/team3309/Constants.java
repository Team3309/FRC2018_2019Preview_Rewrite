package org.usfirst.frc.team3309;


import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;

public class Constants {


    private static final byte[] PRACTICEBOT_MAC_ADDR = {0x00, (byte) 0x80, 0x2F, 0x17, (byte) 0x85, (byte) 0xD3};
    private static final byte[] COMPBOT_MAC_ADDR = {0x00, (byte)0x80, 0x2F, 0x17, (byte) 0xE4, 0x5E}; // find this at comp

    public enum Robot {
        PRACTICE,
        COMPETITION
    }

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

    public static int JOYSTICK_TRIGGER_BUTTON = 1;

    public static double BELTBAR_BOTTOM_POS = Constants.currentRobot == Robot.PRACTICE ? -2680 : -2700;
    public static double BELTBAR_INTAKE_POS = Constants.currentRobot == Robot.PRACTICE ? -1550 : -1500;
    public static double BELTBAR_EXCHANGE_POS = Constants.currentRobot == Robot.PRACTICE ? -1800 : -1700;
    public static double BELTBAR_EJECT_POS = Constants.currentRobot == Robot.PRACTICE ? -2400 : -2300;
    public static double BELTBAR_SCALE_UP_POS = Constants.currentRobot == Robot.PRACTICE ? -2550 : -2500;
    public static double BELTBAR_SWITCH_POS = Constants.currentRobot == Robot.PRACTICE ? -2000 : -1900;
    public static double BELTBAR_CLIMB = Constants.currentRobot == Robot.PRACTICE ? -2800 : -2700;

    public static double ELEVATOR_BOTTOM_POS = 0;
    public static double ELEVATOR_INTAKE_POS = 1100;
    public static double ELEVATOR_EXCHANGE_POS = 700;
    public static double ELEVATOR_SWITCH_POS = 15000;
    public static double ELEVATOR_SCALE_DOWN_POS = 31000;
    public static double ELEVATOR_SCALE_MIDDLE_POS = 36000;
    public static double ELEVATOR_SCALE_TOP_POS = 40000;

    // drive
    public static final int DRIVE_RIGHT_0_ID = 11;
    public static final int DRIVE_RIGHT_1_ID = 13;
    public static final int DRIVE_RIGHT_2_ID = 15;

    public static final int DRIVE_LEFT_0_ID = 10;
    public static final int DRIVE_LEFT_1_ID = 12;
    public static final int DRIVE_LEFT_2_ID = 14;

    public static final int DRIVE_SHIFTER = 7;

    // roller
    public static final int ROLLER_LEFT = 40;
    public static final int ROLLER_RIGHT = 41;

    // arms
    public static final int ARMS_ACTUATOR_A = 2;
    public static final int ARMS_ACTUATOR_B = 1;

    public static final int ARMS_OTHER_ACTUATOR = 5;

    // lift
    public static final int LIFT_0 = 20;
    public static final int LIFT_1 = 21;
    public static final int LIFT_2 = 22;
    public static final int LIFT_3 = 23;
    public static final int LIFT_4 = 24;

    public static final int LIFT_SHIFTER = 6;

    public static final int LIFT_BANNER_SENSOR = 0;

    public static final int LIFT_HOLDER_A = 3;
    public static final int LIFT_HOLDER_B = 0;

    public static final int LIFT_FORWARD_LIM = 47000;
    public static final double LIFT_NUDGE_SPEED = 6955; // viva chile!

    // beltbar
    public static final int BELTBAR_TALON_ID = 31;
    public static final int BELTBAR_MAX_CURRENT = 18;
    public static final int BELTBAR_MAX_CURRENT_DURATION = 125;

    public static int BELTBAR_FORWARD_SOFT_LIM = 0;
    public static int BELTBAR_REVERSE_SOFT_LIM = 0;

    // falcon doors
    public static final int FALCONDOORS_SOLENOID = 4;

    // led
    public static final int LED_CHANNEL = 0;

    // robot constants
    public static final double AUTO_ROLLER_INTAKE_POWER = -1;


    public static final double DRIVE_ENCODER_COUNTS_PER_REV = 4096*9.6;
    public static final double WHEEL_DIAMETER_INCHES = 6.0;
    public static final double WHEELBASE_INCHES = 26;
    public static final double DRIVEBASE_P = 0.019;
    public static final double DRIVEBASE_I = 0.0006;
    public static final double DRIVEBASE_D = 0.002;


    public static void configureRobotSpecificConstants() {
        if (Constants.currentRobot == Constants.Robot.PRACTICE) {
            BELTBAR_REVERSE_SOFT_LIM = -2840;
            BELTBAR_FORWARD_SOFT_LIM = -1200;
            BELTBAR_BOTTOM_POS = -2680;
            BELTBAR_INTAKE_POS = -1550;
            BELTBAR_EXCHANGE_POS = -1800;
            BELTBAR_EJECT_POS = -2400;
            BELTBAR_SCALE_UP_POS = -2550;
            BELTBAR_SWITCH_POS = -2000;
            BELTBAR_CLIMB = -2800;
        }

        if (Constants.currentRobot == Constants.Robot.COMPETITION) {
            BELTBAR_REVERSE_SOFT_LIM = -3200;
            BELTBAR_FORWARD_SOFT_LIM = -200;
            BELTBAR_BOTTOM_POS = -2700;
            BELTBAR_INTAKE_POS = -1500;
            BELTBAR_EXCHANGE_POS = -1700;
            BELTBAR_EJECT_POS = -2300;
            BELTBAR_SCALE_UP_POS = -2500;
            BELTBAR_SWITCH_POS = -1900;
            BELTBAR_CLIMB = -2700;
        }

    }

}
