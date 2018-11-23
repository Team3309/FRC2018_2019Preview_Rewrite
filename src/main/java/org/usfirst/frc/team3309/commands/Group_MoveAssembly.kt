package org.usfirst.frc.team3309.commands

import edu.wpi.first.wpilibj.DriverStation
import org.usfirst.frc.team4322.commandv2.*

/*
 * This file doesnt look like java!
 * And that's because it isn't.
 * To make laying out auto modes easier,
 * We use a tool called a DSL
 * that's written in a slightly different language
 * called Kotlin.
 *
 * This DSL will be much more prolific in autonomous code.
 */

// object declares a class that can only have one instance.
 object Group_MoveAssembly {
    //@JvmStatic means this is a class level function, like static in java.
     @JvmStatic
     //This declares a function, to, that takes 2 doubles, liftPosition and beltBarPosition, and returns a command.
      fun to(liftPosition: Double, beltBarPosition: Double) : Command {
          // group declares the start of set of commands.
          return group {
              // parallel means that the commands will run in a sequence.
              parallel {
                  //The plus we see here before router adds it to the group.
                  //A router is a function that is run when the group starts to determine what command it should run.
                  +Router {
                      //If we are in auto
                      if (DriverStation.getInstance().isAutonomous) {
                          //Use the command that moves the lift fully autonomously.
                          Lift_Elevate(liftPosition)
                      } else {
                          //Otherwise, use the version that lets the operator fine  tune the position
                          Lift_HybridMove(liftPosition)
                      }
                  }
                  //here we just add the command to move the belt bar to the parallel group.
                  +BeltBar_MoveToPos(beltBarPosition)
              }
          }
      }
}