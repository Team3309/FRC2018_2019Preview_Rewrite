package org.usfirst.frc.team3309.commands

import edu.wpi.first.wpilibj.DriverStation
import org.usfirst.frc.team4322.commandv2.*

 object MoveAssembly {
     @JvmStatic
      fun to(liftPosition: Double, beltBarPosition: Double) : Command {
          return group {
              parallel {
                  +Router {
                      if (DriverStation.getInstance().isAutonomous) {
                          Lift_Elevate(liftPosition)
                      } else {
                          Lift_HybridMove(liftPosition)
                      }
                  }
                  +BeltBarMoveToPos(beltBarPosition)
              }
          }
      }
}