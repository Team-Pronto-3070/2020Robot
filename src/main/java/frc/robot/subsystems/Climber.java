package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase{  //This whole system will be used as a single command.

    public TalonSRX t_winch, t_teleArm;
    private boolean up = false;
    
    public Climber(){
        t_winch = new TalonSRX(RobotMap.T_WINCH_PORT); //sets the motor for the winch
        t_teleArm = new TalonSRX(RobotMap.T_TELE_PORT); //sets the motor for the lift arm
        t_teleArm.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        t_teleArm.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        t_winch.configContinuousCurrentLimit(20);
        //DO NOT setInverted for TalonSRX's connected to limit switches
    }

    public void goUp(){
        t_teleArm.set(ControlMode.PercentOutput, -RobotMap.TELE_LIFT_SPEED); // creates a speed command for the lift arm located in RobotMap
        up = true;
    }

    public void goDown(){ //TODO: Put winch in here
        t_teleArm.set(ControlMode.PercentOutput, RobotMap.TELE_LIFT_SPEED); //tells the arm to fall.
        t_winch.set(ControlMode.PercentOutput, .1);
        up = false;
    }

    public void winchOut(){
        t_winch.set(ControlMode.PercentOutput, RobotMap.WINCH_LIFT_SPEED); //tells the winch to reverse.
    }

    public void winchIn(){
        t_winch.set(ControlMode.PercentOutput, -RobotMap.WINCH_LIFT_SPEED);
    }

    public void stopWinch(){
        t_winch.set(ControlMode.PercentOutput, 0);
    }

    public void stop(){
        t_teleArm.set(ControlMode.PercentOutput,0); // Stops all the movement.
        t_winch.set(ControlMode.PercentOutput,0); 
    }

    public void toggle(){
        if(up)
            goDown();
        else
            goUp();
    }

}






// OwO what's this