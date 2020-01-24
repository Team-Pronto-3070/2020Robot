package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;

class WOF extends SubsystemBase {
    TalonSRX t_WOF;
    Color initColor;
    int rotations = 0;

    public WOF(){
        setDefaultCommand(new ControlPanelStageOne());

        t_WOF = new TalonSRX(RobotMap.T_WOF_PORT);
    }

    public boolean rotateNoOfRotations(int rotations) {
        initColor = Robot.m_oi.getColor();

        while(rotations < RobotMap.NO_OF_WOF_ROTS * 2){
            t_WOF.set(ControlMode.PercentOutput, 1);
            if(Robot.m_oi.getColor() == initColor)
                this.rotations++;
        } 

        t_WOF.set(ControlMode.PercentOutput, 0);
        return true;
    }

    public void putColorOnShuffleboard(){
    Color detectedColor = Robot.m_oi.getColor();

    SmartDashboard.putNumber("Red", detectedColor.red * 100);
    SmartDashboard.putNumber("Green", detectedColor.green * 100);
    SmartDashboard.putNumber("Blue", detectedColor.blue * 100);
    SmartDashboard.putNumber("IR", Robot.m_oi.getIR());
    SmartDashboard.putNumber("Total", (detectedColor.red + detectedColor.green + detectedColor.blue) * 100);
    SmartDashboard.putNumber("Proximity", Robot.m_oi.getProximity());
    }

    public void stop(){
        t_WOF.set(ControlMode.PercentOutput, 0);
    }
}