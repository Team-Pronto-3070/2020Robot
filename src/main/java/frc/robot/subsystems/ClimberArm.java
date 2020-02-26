package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ClimberArm extends SubsystemBase{  //This whole system will be used as a single command.

    public TalonSRX t_teleArm;
    
    public ClimberArm(){
        t_teleArm = new TalonSRX(RobotMap.T_TELE_PORT); //sets the motor for the lift arm
        t_teleArm.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        t_teleArm.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        //DO NOT setInverted for TalonSRX's connected to limit switches
    }

    public void goUp(){
        t_teleArm.set(ControlMode.PercentOutput, -RobotMap.TELE_LIFT_SPEED); // creates a speed command for the lift arm located in RobotMap
    }

    public void goDown(){
        t_teleArm.set(ControlMode.PercentOutput, RobotMap.TELE_LIFT_SPEED); //tells the arm to fall.
    }


    public void stop(){
        t_teleArm.set(ControlMode.PercentOutput,0); // Stops all the movement.
    }

}