package org.usfirst.frc.team3309.commands

import org.usfirst.frc.team3309.Constants
import org.usfirst.frc.team4322.commandv2.Command
import org.usfirst.frc.team4322.motion.RamseteController
import org.usfirst.frc.team4322.motion.Trajectory

class Auto_DriveRamsete(path : Trajectory) : Command() {

    var ramsete : RamseteController = RamseteController(path, Constants.WHEELBASE_INCHES,2.0,.7)

    override fun execute() {
        ramsete.run()
    }

    override fun isFinished(): Boolean {
        return ramsete.isFinished()
    }
}