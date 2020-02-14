package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;

public class Hopper extends SubsystemBase {
    
    TalonSRX t_Hopper;
    
    public Hopper(){
        t_Hopper = new TalonSRX(RobotMap.T_HOPPER_PORT); //defines a motor for the hopper, and routes it to RobotMap
    }

    public void in(){
        t_Hopper.set(ControlMode.PercentOutput, RobotMap.HOPPER_LIFT_SPEED); //gives it a percent speed, taking the value from RobotMap
    }

    public void out(){
        t_Hopper.set(ControlMode.PercentOutput, -1); //sets the speed as -1
       
    }

    public void stop(){
        t_Hopper.set(ControlMode.PercentOutput,0); //sets the speed as 0, stopping it.
        
    }

}
