package frc.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.util.Color;

public class OI {
    
    ColorSensorV3 s_colorSensor;
    ADIS16448_IMU gyro;
    public Joystick j_LEFT, j_RIGHT;
    JoystickButton butt1;
    

    public OI(){

        j_LEFT = new Joystick(RobotMap.JOYL_PORT);
        j_RIGHT = new Joystick(RobotMap.JOYR_PORT);
        butt1 = new JoystickButton(j_LEFT, 2); //TODO: Adjust these values to actual values

        s_colorSensor = new ColorSensorV3(RobotMap.i2cPort);

        gyro = new ADIS16448_IMU();
    }

    public double getJoyAxis(RobotMap.JOYSIDE side, int axis){
        if(side == RobotMap.JOYSIDE.LEFT)
            return j_LEFT.getRawAxis(axis);
        else
            return j_RIGHT.getRawAxis(axis);
    }

    public boolean getJoyButton(RobotMap.JOYSIDE side, int button){
        if(side == RobotMap.JOYSIDE.LEFT)
            return j_LEFT.getRawButton(button);
        else
            return j_RIGHT.getRawButton(button);
    }

    public Color getColor(){
        return s_colorSensor.getColor();
    }

    public int getIR(){
        return s_colorSensor.getIR();
    }

    public int getProximity(){
        return s_colorSensor.getProximity();
    }

}