package org.usfirst.frc.team3309

import org.usfirst.frc.team3309.commands.*
import org.usfirst.frc.team4322.input.InputThrustmaster
import org.usfirst.frc.team4322.input.InputXbox

/*
 * OI is short for Operator Interface, and its in charge of managing the input devices the drivers use.
 * Its main purpose is to connect commands to buttons on controllers.
 */

class OI {
    var leftJoystick: InputThrustmaster = InputThrustmaster(0, InputThrustmaster.Hand.Left)
    var rightJoystick: InputThrustmaster = InputThrustmaster(1, InputThrustmaster.Hand.Right)
    var operatorController: InputXbox = InputXbox(2)

    init {
        /* =====DRIVER===== */
        leftJoystick.trigger.whenPressed(Drive_SetLowGear())
        leftJoystick.trigger.whenReleased(Drive_SetHighGear())

        leftJoystick.knobCluster.bottom.whileHeld(LED_On())
        rightJoystick.knobCluster.bottom.whileHeld(LED_On())

        /* =====OPERATOR===== */
        operatorController.a.whenPressed(Arms_Clamp())
        operatorController.b.whenPressed(Arms_Open())

        operatorController.start.whenPressed(Lift_LockSecondStage())
        operatorController.back.whenPressed(FalconDoors_Deploy())

        operatorController.leftStick.whenPressed(Lift_ShiftToClimb())

        operatorController.lb.whileHeld(LED_On())

        operatorController.x.whenPressed(Group_MoveAssembly.to(Constants.LIFT_INTAKE_POSITION, Constants.BELTBAR_INTAKE_POSITION))
        operatorController.y.whenPressed(Group_MoveAssembly.to(Constants.LIFT_BOTTOM_POSITION, Constants.BELTBAR_BOTTOM_POSITION))
        operatorController.dPad.down.whenPressed(Group_MoveAssembly.to(Constants.LIFT_SWITCH_POSITION, Constants.BELTBAR_SWITCH_POSITION))
        operatorController.dPad.right.whenPressed(Group_MoveAssembly.to(Constants.LIFT_SCALE_LOW_POSITION, Constants.BELTBAR_EJECT_POSITION))
        operatorController.dPad.up.whenPressed(Group_MoveAssembly.to(Constants.LIFT_SCALE_MIDDLE_POSITION, Constants.BELTBAR_EJECT_POSITION))
        operatorController.dPad.left.whenPressed(Group_MoveAssembly.to(Constants.LIFT_SCALE_HIGH_POSITION, Constants.BELTBAR_SCALE_HIGH_POSITION))
        operatorController.rb.whenPressed(Group_MoveAssembly.to(Constants.LIFT_EXCHANGE_POSITION, Constants.BELTBAR_EXCHANGE_POSITION))
    }

}
