package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;

public class OI {
    
    
    public Joystick j_LEFT, j_RIGHT;
    JoystickButton hopButt, wofButt;

    public OI(){
        j_LEFT = new Joystick(RobotMap.JOYL_PORT);
        j_RIGHT = new Joystick(RobotMap.JOYR_PORT);
        hopButt = new JoystickButton(j_LEFT, RobotMap.HOPPER_BUTTON); 
        wofButt = new JoystickButton(j_LEFT, RobotMap.WOF_BUTTON);
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
}