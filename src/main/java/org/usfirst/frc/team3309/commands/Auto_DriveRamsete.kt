package org.usfirst.frc.team3309.commands

import com.ctre.phoenix.motorcontrol.ControlMode
import org.usfirst.frc.team3309.Constants
import org.usfirst.frc.team3309.Robot
import org.usfirst.frc.team4322.commandv2.Command
import org.usfirst.frc.team4322.motion.RamseteController
import org.usfirst.frc.team4322.motion.Trajectory

class Auto_DriveRamsete(path : Trajectory) : Command() {

    private val ramsete : RamseteController = RamseteController(path, Constants.WHEELBASE_INCHES/12.0,2.0,.7)


    init {
        require(Robot.driveBase)
    }
    override fun execute() {
        val out = ramsete.run()
        System.out.println("Running Ramsete!")
        System.out.printf("Left: %f\nRight: %f\n",out.first,out.second)
        Robot.driveBase.setLeftRight(ControlMode.Velocity,out.first,out.second)
    }

    override fun isFinished(): Boolean {
        return ramsete.isFinished()
    }
}