package frc.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;;

class OI {
    TalonFX tf_FL, tf_FR, tf_BL, tf_BR;
    TalonSRX ts_WOF, ts_WINCH, ts_CLIMB_TELESCOPER, ts_HOPPER, ts_BELT1, ts_BELT2;
    Joystick j_LEFT, j_RIGHT;
    ColorSensorV3 s_colorSensor;
    ADIS16448_IMU gyro;


    public OI(){
        tf_FL = new TalonFX(RobotMap.FL_PORT);
        tf_FR = new TalonFX(RobotMap.FR_PORT);
        tf_BL = new TalonFX(RobotMap.BL_PORT);
        tf_BR = new TalonFX(RobotMap.BR_PORT);

        ts_WOF = new TalonSRX(RobotMap.T_WOF_PORT);
        ts_WINCH = new TalonSRX(RobotMap.T_WINCH_PORT);
        ts_HOPPER = new TalonSRX(RobotMap.T_HOPPER_PORT);
        ts_CLIMB_TELESCOPER = new TalonSRX(RobotMap.T_TELE_PORT);
        ts_BELT1 = new TalonSRX(RobotMap.T_BELT1_PORT);
        ts_BELT2 = new TalonSRX(RobotMap.T_BELT2_PORT);

        j_LEFT = new Joystick(RobotMap.JOYL_PORT);
        j_RIGHT = new Joystick(RobotMap.JOYR_PORT);

        s_colorSensor = new ColorSensorV3(RobotMap.i2cPort);

        gyro = new ADIS16448_IMU();
    }

    public double getJoyAxis(RobotMap.JOYSIDE side, int axis){
        if(side == RobotMap.JOYSIDE.LEFT)
            return j_LEFT.getRawAxis(axis);
        else   
            return j_RIGHT.getRawAxis(axis);
    }
}