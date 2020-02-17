package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.RobotMap;

public class OI {
    
    
    public Joystick j_LEFT, j_RIGHT;
    JoystickButton hopButt, wofButt, climbUpButt, climbDownButt, shiftUpButt,
                    shiftDownButt, autoShiftButt,intakeButt,outputButt, compStartButt,
                    compStopButt, compToggleButt, wofArmUpButt, wofArmDownButt, wofArmToggleButt;

    public OI(){
        j_LEFT = new Joystick(RobotMap.JOYL_PORT);
        j_RIGHT = new Joystick(RobotMap.JOYR_PORT);

        //exampleButt = new JoystickButton(j_LEFT or j_RIGHT, 1/2/3/4/etc.);
        hopButt = new JoystickButton(getButtonJoyside(RobotMap.HOPPER_ID), RobotMap.HOPPER_BUTTON); 
        wofButt = new JoystickButton(getButtonJoyside(RobotMap.WOF_ID), RobotMap.WOF_BUTTON);
        climbUpButt = new JoystickButton(getButtonJoyside(RobotMap.CL_UP_ID), RobotMap.CLIMBER_UP_BUTTON);
        climbDownButt = new JoystickButton(getButtonJoyside(RobotMap.CL_DOWN_ID), RobotMap.CLIMBER_DOWN_BUTTON);
        shiftUpButt = new JoystickButton(getButtonJoyside(RobotMap.SH_UP_ID), RobotMap.SHIFT_UP_BUTTON);
        shiftDownButt = new JoystickButton(getButtonJoyside(RobotMap.SH_DWN_ID), RobotMap.SHIFT_DOWN_BUTTON);
        autoShiftButt = new JoystickButton(getButtonJoyside(RobotMap.SH_AU_ID), RobotMap.AUTOSHIFT_BUTTON);
<<<<<<< HEAD
        inButt = new JoystickButton(getButtonJoyside(RobotMap.INTAKE_ID), RobotMap.INTAKE_BUTTON);
        // outButt = new JoystickButton(getButtonJoyside(RobotMap.OUTPUT_ID),RobotMap.OUTPUT_BUTTON);
=======
        intakeButt = new JoystickButton(getButtonJoyside(RobotMap.INTAKE_ID), RobotMap.INTAKE_BUTTON);
        outputButt = new JoystickButton(getButtonJoyside(RobotMap.OUTPUT_ID),RobotMap.OUTPUT_BUTTON);
        compStartButt = new JoystickButton(getButtonJoyside(RobotMap.START_COMP_ID),RobotMap.START_COMP_BUTTON);
        compStopButt = new JoystickButton(getButtonJoyside(RobotMap.STOP_COMP_ID),RobotMap.STOP_COMP_BUTTON);
        compToggleButt = new JoystickButton(getButtonJoyside(RobotMap.TOGGLE_COMP_ID),RobotMap.TOGGLE_COMP_BUTTON);
        wofArmUpButt = new JoystickButton(getButtonJoyside(RobotMap.RA_AR_ID), RobotMap.RAISE_ARM_BUTTON);
        wofArmToggleButt = new JoystickButton(getButtonJoyside(RobotMap.TOG_AR_ID), RobotMap.TOGGLE_ARM_BUTTON);
        wofArmDownButt = new JoystickButton(getButtonJoyside(RobotMap.SH_DWN_ID), RobotMap.LOWER_ARM_BUTTON);
>>>>>>> 193b0ae539e3500529f9f3f10d314435c94e0afd
    }

    public double getJoyAxis(RobotMap.JOYSIDE side, int axis){
        if(side == RobotMap.JOYSIDE.Left)
            return j_LEFT.getRawAxis(axis);
        else
            return j_RIGHT.getRawAxis(axis);
    }

    public boolean getJoyButton(RobotMap.JOYSIDE side, int button){
        if(side == RobotMap.JOYSIDE.Left)
            return j_LEFT.getRawButton(button);
        else
            return j_RIGHT.getRawButton(button);
    }

    public Joystick getButtonJoyside(int id){
        switch(RobotMap.getButtonJoyside(id)){
            case Left:
                return j_LEFT;
            case Right:
                return j_RIGHT;
            default:
                return null;
        }
    }
}