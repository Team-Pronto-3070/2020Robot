package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Winch extends SubsystemBase {

    public TalonSRX t_winch;

    public Winch(){
        t_winch = new TalonSRX(RobotMap.T_WINCH_PORT); //sets the motor for the winch

        t_winch.configContinuousCurrentLimit(20);
        t_winch.set(ControlMode.PercentOutput, .1);
    }

    public void out(){
        t_winch.set(ControlMode.PercentOutput, RobotMap.WINCH_LIFT_SPEED); //tells the winch to reverse.
    }

    public void in(){
        t_winch.set(ControlMode.PercentOutput, -RobotMap.WINCH_LIFT_SPEED);
    }

    public void stop(){
        t_winch.set(ControlMode.PercentOutput, 0);
    }

    
}