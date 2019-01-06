package org.usfirst.frc.team3309;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.TimedRobot;
import org.usfirst.frc.team3309.commands.Auto_DriveRamsete;
import org.usfirst.frc.team3309.subsystems.*;
import org.usfirst.frc.team4322.commandv2.Scheduler;
import org.usfirst.frc.team4322.motion.RobotPositionIntegrator;
import org.usfirst.frc.team4322.motion.Trajectory;

/*
 * This is the Robot class.
 * It handles the setup for the rest of the robot code.
 */

public class Robot extends TimedRobot {

    public static Arms arms;
    public static BeltBar beltBar;
    public static DriveBase driveBase;
    public static FalconDoor falconDoor;
    public static Intake intake;
    public static LED led;
    public static Lift lift;

    public static OI oi;

    /*
     * This function is called when the Robot program starts. use it to initialize your subsystems,
     * and to set up anything that needs to be initialized with the robot.
     */
    @Override
    public void robotInit() {
        Constants.configureRobotSpecificConstants();
        arms = new Arms();
        beltBar = new BeltBar();
        driveBase = new DriveBase();
        falconDoor = new FalconDoor();
        intake = new Intake();
        led = new LED();
        lift = new Lift();
        oi = new OI();

        driveBase.initDefaultCommand();
        arms.initDefaultCommand();
        lift.initDefaultCommand();
        //Invert the drive stick axes.
        oi.getLeftJoystick().getYAxis().setRampFunction((x) -> -x);
        oi.getRightJoystick().getXAxis().setRampFunction((x) -> -x);
        oi.getOperatorController().getLeftStick().getY().setRampFunction((x) -> -x);
    }

    /*
     * This function is called when the Robot enters disabled.
     * It should be used to shut down processes that should only run when the bot is enabled.
     */
    @Override
    public void disabledInit() {
        Scheduler.killAllCommands();
    }

    /*
     * This function is called every 2 milliseconds while the robot is in disabled.
     * It should be used to perform peroidic tasks that need to be done while the robot is disabled.
     */
    @Override
    public void disabledPeriodic() {
    }

    /*
     * This function is called when the Robot enters autonomous.
     * It should be used to get the current auto mode, and launch the appropriate autonomous mode.
     */
    @Override
    public void autonomousInit() {
        new Auto_DriveRamsete(Trajectory.load("/home/lvuser/deploy/output/Drive10Feet.pf1.csv")).start();
    }

    /*
     * This function is called every 2 milliseconds while the robot is in autonomous.
     * It should be used to perform periodic tasks that need to be done while the robot is in autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    }

    /*
     * This function is called when the Robot enters teleop.
     * It should be used to shut down any autonomous code, and prepare the bot for human control.
     */
    @Override
    public void teleopInit() {

    }

    /*
     * This function is called every 2 milliseconds while the robot is in autonomous.
     * It should be used to perform periodic tasks that need to be done while the robot is in teleop.
     */
    @Override
    public void teleopPeriodic() {
    }

    /*
     * This function is called when the Robot enters test mode.
     */
    @Override
    public void testInit() {
    }


    /*
     * This function is called every 2 milliseconds while the Robot is in test mode.
     */
    @Override
    public void testPeriodic() {
    }

    /*
     * This function always runs, regardless of mode.
     */
    @Override
    public void robotPeriodic() {
        Scheduler.update();
    }

    /*
     * This is the main function, which is where every java program starts.
     * All we do here is insert the code that is used to start up the rest of the robot code.
     */
    public static void main(String[] args) {
        RobotBase.startRobot(Robot::new);
    }
}
