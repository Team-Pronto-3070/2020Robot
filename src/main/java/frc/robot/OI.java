package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.RobotMap;
import frc.robot.RobotMap.JOYSIDE;

public class OI {
    
    
    public Joystick j_LEFT, j_RIGHT;
    JoystickButton hopButt, wofButt, toggleClimbButt, climbUpButt, climbDownButt, shiftUpButt,
                    shiftDownButt, autoShiftButt, compStartButt,
                    compStopButt, compToggleButt, wofArmUpButt, wofArmDownButt, wofArmToggleButt,
                    winchForwardButt, winchBackwardButt, groundOutputButt; //, dtFlipButt;

    public OI(){
        j_LEFT = new Joystick(RobotMap.JOYL_PORT);
        j_RIGHT = new Joystick(RobotMap.JOYR_PORT);

        //button for outputing from the hopper(button 2 on the left joystick) 
        hopButt = new JoystickButton(getButtonJoyside(RobotMap.HOPPER_ID), RobotMap.HOPPER_BUTTON); 
        //used for operating the wheel of fortune mech(button 3 on the left joystick)
        wofButt = new JoystickButton(getButtonJoyside(RobotMap.WOF_ID), RobotMap.WOF_BUTTON);

        //the two buttons that put the climber up and down(button three for up and button 2 for down on the right)
        climbUpButt = new JoystickButton(getButtonJoyside(RobotMap.CL_UP_ID), RobotMap.CLIMBER_UP_BUTTON);
        climbDownButt = new JoystickButton(getButtonJoyside(RobotMap.CL_DOWN_ID), RobotMap.CLIMBER_DOWN_BUTTON);
        //shift up is button 4 on the left, shift down is button 5 on the left
        shiftUpButt = new JoystickButton(getButtonJoyside(RobotMap.SH_UP_ID), RobotMap.SHIFT_UP_BUTTON);
        shiftDownButt = new JoystickButton(getButtonJoyside(RobotMap.SH_DWN_ID), RobotMap.SHIFT_DOWN_BUTTON);
        autoShiftButt = new JoystickButton(getButtonJoyside(RobotMap.SH_TGL_ID), RobotMap.TOGGLE_SHIFT_BUTTON);
        //buttons for compressing, 11 for starting and 12 for stopping on the left, 6 on the right for toggling

        compStartButt = new JoystickButton(getButtonJoyside(RobotMap.START_COMP_ID),RobotMap.START_COMP_BUTTON);
        compStopButt = new JoystickButton(getButtonJoyside(RobotMap.STOP_COMP_ID),RobotMap.STOP_COMP_BUTTON);
        compToggleButt = new JoystickButton(getButtonJoyside(RobotMap.COMP_TGL_ID),RobotMap.TOGGLE_COMP_BUTTON);
        wofArmUpButt = new JoystickButton(getButtonJoyside(RobotMap.ARM_UP_ID), RobotMap.RAISE_ARM_BUTTON);
        wofArmToggleButt = new JoystickButton(getButtonJoyside(RobotMap.ARM_TGL_ID), RobotMap.TOGGLE_ARM_BUTTON);
        wofArmDownButt = new JoystickButton(getButtonJoyside(RobotMap.SH_DWN_ID), RobotMap.LOWER_ARM_BUTTON);
        toggleClimbButt = new JoystickButton(getButtonJoyside(RobotMap.CL_TGL_ID), RobotMap.CLIMBER_TOGGLE_BUTTON);
        winchForwardButt = new JoystickButton(getButtonJoyside(RobotMap.WNCH_FRWD_ID), RobotMap.WINCH_FORWARD_BUTTON);
        winchBackwardButt = new JoystickButton(getButtonJoyside(RobotMap.WNCH_BCKWD_ID), RobotMap.WINCH_BACKWARD_BUTTON);
        groundOutputButt = new JoystickButton(getButtonJoyside(RobotMap.OUTPUT_ID), RobotMap.OUTPUT_BUTTON);
        // dtFlipButt = new JoystickButton(getButtonJoyside(RobotMap.DTFLIP_ID), RobotMap.DTFLIP_BUTTON);
    }

    public double getJoyAxis(RobotMap.JOYSIDE side, int axis){
        if(side == RobotMap.JOYSIDE.Left)
            return j_LEFT.getRawAxis(axis) * getScaler(JOYSIDE.Right);
        else
            return j_RIGHT.getRawAxis(axis) * getScaler(JOYSIDE.Right);
    }

    public boolean getJoyButton(RobotMap.JOYSIDE side, int button){
        if(side == RobotMap.JOYSIDE.Left)
            return j_LEFT.getRawButton(button);
        else
            return j_RIGHT.getRawButton(button);
    }

    public Joystick getButtonJoyside(int id){
        if(RobotMap.getButtonJoyside(id) == JOYSIDE.Left)
            return j_LEFT;
        else
            return j_RIGHT;
    }

    public double getScaler(JOYSIDE side){
        if(side == JOYSIDE.Left)
            return .5 * (-j_LEFT.getRawAxis(2) + 1); //Alters the range of sliders to 0 to 1 instead of 1 to -1
        else
            return .5 * (-j_RIGHT.getRawAxis(2) + 1);
    }
}