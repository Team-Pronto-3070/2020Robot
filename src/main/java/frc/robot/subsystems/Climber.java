package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

class Climber extends SubsystemBase{

    TalonSRX t_winch;
    TalonSRX t_teleArm;
    
    public Climber(){
        t_winch = new TalonSRX(RobotMap.T_WINCH_PORT);
        t_teleArm = new TalonSRX(RobotMap.T_TELE_PORT);    
    }

    public void goUp(){
        t_winch.set(ControlMode.PercentOutput, RobotMap.WINCH_LIFT_SPEED);
        t_teleArm.set(ControlMode.PercentOutput, RobotMap.TELE_LIFT_SPEED);
    }

    //Retracts arm and winch. They do not need to be synced.
    public void goDown(){
        t_teleArm.set(ControlMode.PercentOutput, -1);
        t_winch.set(ControlMode.PercentOutput,-1);
    }

    //Stops both motors.
    public void stop(){
        t_teleArm.set(ControlMode.PercentOutput,0);
        t_winch.set(ControlMode.PercentOutput,0);
    }

}