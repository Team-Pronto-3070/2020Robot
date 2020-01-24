package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;

class Hopper extends SubsystemBase {
    
    TalonSRX t_Hopper;
    
    public Hopper(){
        t_Hopper = new TalonSRX(RobotMap.T_HOPPER_PORT);
        
    }

    public void in(){
        t_Hopper.set(ControlMode.PercentOutput, RobotMap.HOPPER_LIFT_SPEED);
       
    }

    public void out(){
        t_Hopper.set(ControlMode.PercentOutput, -1);
       
    }

    public void stop(){
        t_Hopper.set(ControlMode.PercentOutput,0);
        
    }

}