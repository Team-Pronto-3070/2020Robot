package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

//TODO: Comment up

class WOF extends SubsystemBase {
    TalonSRX t_WOF;
    Color clr;
    int passes = 0; //# of completed passes of single color. * 2 = # of full rotations

    ColorSensorV3 s_colorSensor;

    private final ColorMatch m_colorMatcher = new ColorMatch();

    

    //Constructor
    public WOF(){
        setDefaultCommand(new ControlPanelStageOne());

        t_WOF = new TalonSRX(RobotMap.T_WOF_PORT);
        
        s_colorSensor = new ColorSensorV3(RobotMap.i2cPort);
    }

    @Override
    public void periodic()
    {
        // write RGB, and HSV value from color sensor to dashboard
        // Write result enum value to dashboard
    }

    public void putColorOnShuffleboard(){
    SmartDashboard.putNumber("Red", s_colorSensor.getRed());
    SmartDashboard.putNumber("Green", s_colorSensor.getGreen());
    SmartDashboard.putNumber("Blue", s_colorSensor.getBlue());
    SmartDashboard.putNumber("IR", s_colorSensor.getIR());
    SmartDashboard.putNumber("Proximity", s_colorSensor.getProximity());
    }

    public void stop(){
        t_WOF.set(ControlMode.PercentOutput, 0);
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

    public RobotMap.ColorType getClosestColor(){
        setColor();

        ColorMatchResult match = m_colorMatcher.matchClosestColor(clr);

        if (match.color == RobotMap.kBlueTarget) {
            return RobotMap.ColorType.Blue;
        } else if (match.color == RobotMap.kRedTarget) {
            return RobotMap.ColorType.Red;
        } else if (match.color == RobotMap.kGreenTarget) {
            return RobotMap.ColorType.Green;
        } else if (match.color == RobotMap.kYellowTarget) {
            return RobotMap.ColorType.Yellow;
        } else {
            return RobotMap.ColorType.UNKNOWN;
        }
    }

    public void setColor(){
        clr = getSensorColor();
    }
}