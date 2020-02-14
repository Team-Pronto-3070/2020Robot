package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.RobotMap.*;

//TODO: Comment up

public class WOF extends SubsystemBase {
    public TalonSRX t_WOF;
    Color clr;
    int passes = 0; //# of completed passes of single color. * 2 = # of full rotations

    boolean booleanBlue = false;
    boolean booleanGreen = false;
    boolean booleanRed = false;
    boolean booleanYellow = false;
    
    ColorSensorV3 s_colorSensor;

    private final ColorMatch m_colorMatcher = new ColorMatch();
    
    

    //Constructor
    public WOF(){
       

        t_WOF = new TalonSRX(RobotMap.T_WOF_PORT);
        
        s_colorSensor = new ColorSensorV3(RobotMap.i2cPort);

        
    }

    @Override
    public void periodic()
    {
        // write RGB, and HSV value from color sensor to dashboard
        // Write result enum value to dashboard
        SmartDashboard.putBoolean("isBlue", booleanBlue);
        SmartDashboard.putBoolean("isGreen", booleanGreen);
        SmartDashboard.putBoolean("isRed", booleanRed);
        SmartDashboard.putBoolean("isYellow", booleanYellow);

        booleanBlue = false;
        booleanRed = false;
        booleanYellow = false;
        booleanGreen = false;
    }

    public void setDashColor(){
        if(getClosestColor() == ColorType.Blue){
            booleanBlue = true;
        }else if(getClosestColor() == ColorType.Green){
            booleanGreen = true;
        }else if(getClosestColor() == ColorType.Red){
            booleanRed = true;
        }else if(getClosestColor() == ColorType.Yellow){
            booleanYellow = true;
        }  
    }

    public void stop(){
        t_WOF.set(ControlMode.PercentOutput, 0);
    }

    public void go(){
        t_WOF.set(ControlMode.PercentOutput, .6);
    }

    public Color getSensorColor(){
        return ColorMatch.makeColor(s_colorSensor.getRed(), s_colorSensor.getGreen(), s_colorSensor.getBlue());
    }

    public int getIR(){
        return s_colorSensor.getIR();
    }

    public int getProximity(){
        return s_colorSensor.getProximity();
    }

    public void addColorsToMatcher(){
        m_colorMatcher.addColorMatch(RobotMap.kBlueTarget);
        m_colorMatcher.addColorMatch(RobotMap.kGreenTarget);
        m_colorMatcher.addColorMatch(RobotMap.kRedTarget);
        m_colorMatcher.addColorMatch(RobotMap.kYellowTarget);    
    }

    public ColorType getClosestColor(){
        setColor();

        ColorMatchResult match = m_colorMatcher.matchClosestColor(clr);

        if (match.color == RobotMap.kBlueTarget) {
            return ColorType.Blue;
        } else if (match.color == RobotMap.kRedTarget) {
            return ColorType.Red;
        } else if (match.color == RobotMap.kGreenTarget) {
            return ColorType.Green;
        } else if (match.color == RobotMap.kYellowTarget) {
            return ColorType.Yellow;
        } else {
            return ColorType.UNKNOWN;
        }
    }

    public void setColor(){
        clr = getSensorColor();
    }
}