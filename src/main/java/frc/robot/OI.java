package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

import frc.robot.RobotMap;;

class OI {
    TalonFX tf_FL, tf_FR, tf_BL, tf_BR;
    TalonSRX ts_WOF, ts_WINCH, ts_CLIMB_TELESCOPER, ts_HOPPER, ts_BELT1, ts_BELT2;
    Joystick j_LEFT, j_RIGHT;


    public OI(){
        tf_FL = new TalonFX(deviceNumber)
    }
}