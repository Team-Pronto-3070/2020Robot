package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import java.awt.Color;

class WOF extends SubsystemBase {
    TalonSRX t_WOF;
    Color initColor;
    int passes = 0; //# of completed passes of single color. * 2 = # of full rotations

    //Constructor
    public WOF(){
        setDefaultCommand(new ControlPanelStageOne());

        t_WOF = new TalonSRX(RobotMap.T_WOF_PORT);
    }

    public RobotMap.ColorType getColor() {
        // Determine what color sensor value is closest to
        // return closest color
        // Green, blue, red, yellow, UNNOWN

        Color clr = Robot.m_oi.getColor();

        float[] HSB = clr.RGBtoHSB(clr.getRed(), clr.getGreen(), clr.getBlue(), null);

        
    }

   

    public boolean rotateNoOfRotations(int rotations) {
        initColor = Robot.m_oi.getColor();

        while(passes < rotations * 2){
            t_WOF.set(ControlMode.PercentOutput, 1);
            if(Robot.m_oi.getColor() == initColor)
                passes++;
        } 

        t_WOF.set(ControlMode.PercentOutput, 0);
        return true;
    }

    public void periodic()
    {
        // write RGB, and HSV value from color sensor to dashboard
        // Write result enum value to dashboard
    }

    public void putColorOnShuffleboard(){
    Color detectedColor = Robot.m_oi.getColor();

    SmartDashboard.putNumber("Red", detectedColor.getRed());
    SmartDashboard.putNumber("Green", detectedColor.getGreen());
    SmartDashboard.putNumber("Blue", detectedColor.getBlue());
    SmartDashboard.putNumber("IR", Robot.m_oi.getIR());
    SmartDashboard.putNumber("Total", detectedColor.getRed() + detectedColor.getGreen() + detectedColor.getBlue());
    SmartDashboard.putNumber("Proximity", Robot.m_oi.getProximity());
    }

    public void stop(){
        t_WOF.set(ControlMode.PercentOutput, 0);
    }
}