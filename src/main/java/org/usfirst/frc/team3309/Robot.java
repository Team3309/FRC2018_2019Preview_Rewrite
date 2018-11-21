package org.usfirst.frc.team3309;

import edu.wpi.first.wpilibj.TimedRobot;
import kotlinx.coroutines.GlobalScope;
import org.usfirst.frc.team3309.commands.DriveBase_DriveManual;
import org.usfirst.frc.team3309.commands.Lift_FindZero;
import org.usfirst.frc.team3309.subsystems.*;

public class Robot extends TimedRobot {

    public static Arms arms;
    public static BeltBar beltBar;
    public static DriveBase driveBase;
    public static FalconDoors falconDoors;
    public static LED led;
    public static Lift lift;
    public static Rollers rollers;

    public static OI oi;
    @Override
    public void robotInit() {
        super.robotInit();
        arms = new Arms();
        beltBar = new BeltBar();
        driveBase = new DriveBase();
        falconDoors = new FalconDoors();
        led = new LED();
        lift = new Lift();
        rollers = new Rollers();

        oi = new OI();
    }

    @Override
    public void disabledInit() {
        super.disabledInit();
        arms.resetCommandQueue();
        beltBar.resetCommandQueue();
        driveBase.resetCommandQueue();
        falconDoors.resetCommandQueue();
        led.resetCommandQueue();
        lift.resetCommandQueue();
        rollers.resetCommandQueue();
        new Lift_FindZero().invoke(GlobalScope.INSTANCE);
    }

    @Override
    public void autonomousInit() {
        super.autonomousInit();
    }

    @Override
    public void teleopInit() {
        super.teleopInit();
        new DriveBase_DriveManual().invoke(GlobalScope.INSTANCE);
    }

    @Override
    public void testInit() {
        super.testInit();
    }

    @Override
    public void disabledPeriodic() {
        super.disabledPeriodic();
    }

    @Override
    public void autonomousPeriodic() {
        super.autonomousPeriodic();
    }

    @Override
    public void teleopPeriodic() {
        super.teleopPeriodic();
    }

    @Override
    public void testPeriodic() {
        super.testPeriodic();
    }
}
