package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.RobotMap;

public class OI {
    
    
    public Joystick j_LEFT, j_RIGHT;
    JoystickButton hopButt, wofButt, climbUpButt, climbDownButt, shiftUpButt, shiftDownButt, autoShiftButt;

    public OI(){
        j_LEFT = new Joystick(RobotMap.JOYL_PORT);
        j_RIGHT = new Joystick(RobotMap.JOYR_PORT);

        hopButt = new JoystickButton(getButtonJoyside(RobotMap.HOPPER_ID), RobotMap.HOPPER_BUTTON); 
        wofButt = new JoystickButton(getButtonJoyside(RobotMap.WOF_ID), RobotMap.WOF_BUTTON);
        climbUpButt = new JoystickButton(getButtonJoyside(RobotMap.CL_UP_ID), RobotMap.CLIMBER_UP_BUTTON);
        climbDownButt = new JoystickButton(getButtonJoyside(RobotMap.CL_DOWN_ID), RobotMap.CLIMBER_DOWN_BUTTON);
        shiftUpButt = new JoystickButton(getButtonJoyside(RobotMap.SH_UP_ID), RobotMap.SHIFT_UP_BUTTON);
        shiftDownButt = new JoystickButton(getButtonJoyside(RobotMap.SH_DWN_ID), RobotMap.SHIFT_DOWN_BUTTON);
        autoShiftButt = new JoystickButton(getButtonJoyside(RobotMap.SH_AU_ID), RobotMap.AUTOSHIFT_BUTTON);
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