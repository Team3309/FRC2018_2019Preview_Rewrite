package org.usfirst.frc.team3309

import org.usfirst.frc.team3309.commands.*
import org.usfirst.frc.team4322.input.InputThrustmaster
import org.usfirst.frc.team4322.input.InputXbox

class OI {
    var leftJoystick: InputThrustmaster = InputThrustmaster(0, InputThrustmaster.Hand.Left)
    var rightJoystick: InputThrustmaster = InputThrustmaster(1, InputThrustmaster.Hand.Right)
    var operatorController: InputXbox = InputXbox(2)

    init {
        /* =====DRIVER===== */
        leftJoystick.trigger.whenPressed(Drive_SetLowGear())
        leftJoystick.trigger.whenReleased(Drive_SetHighGear())

        leftJoystick.topBottom.whileHeld(LED_On())
        rightJoystick.topBottom.whileHeld(LED_On())

        /* =====OPERATOR===== */
        operatorController.a.whenPressed(Arms_Clamp())
        operatorController.a.whenPressed(Arms_Open())

        operatorController.start.whenPressed(Lift_LockSecondStage())
        operatorController.back.whenPressed(FalconDoors_Deploy())

        operatorController.leftStick.whenPressed(Lift_ShiftToClimb())

        operatorController.lb.whileHeld(LED_On())

        operatorController.x.whenPressed(MoveAssembly.to(Constants.ELEVATOR_INTAKE_POS, Constants.BELTBAR_INTAKE_POS))
        operatorController.y.whenPressed(MoveAssembly.to(Constants.ELEVATOR_BOTTOM_POS, Constants.BELTBAR_BOTTOM_POS))
        operatorController.dPad.down.whenPressed(MoveAssembly.to(Constants.ELEVATOR_SWITCH_POS, Constants.BELTBAR_SWITCH_POS))
        operatorController.dPad.right.whenPressed(MoveAssembly.to(Constants.ELEVATOR_SCALE_DOWN_POS, Constants.BELTBAR_EJECT_POS))
        operatorController.dPad.up.whenPressed(MoveAssembly.to(Constants.ELEVATOR_SCALE_MIDDLE_POS, Constants.BELTBAR_EJECT_POS))
        operatorController.dPad.left.whenPressed(MoveAssembly.to(Constants.ELEVATOR_SCALE_TOP_POS, Constants.BELTBAR_SCALE_UP_POS))
        operatorController.rb.whenPressed(MoveAssembly.to(Constants.ELEVATOR_EXCHANGE_POS, Constants.BELTBAR_EXCHANGE_POS))
    }

}
