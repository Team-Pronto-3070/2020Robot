package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

class Climber extends SubsystemBase{

    TalonSRX t_Winch;
    TalonSRX t_TeleArm;
    
    public Climber(){
        t_Winch = new TalonSRX(RobotMap.T_WINCH_PORT);
        t_TeleArm = new TalonSRX(RobotMap.T_TELE_PORT);
    
    
    }

    //Extends arm and spools out winch.  
    //Note: arm and winch extend at different rates, which must be kept in sync.
    public void goUp(){
        t_Winch.set(ControlMode.PercentOutput, RobotMap.WINCH_LIFT_SPEED);
        t_TeleArm.set(ControlMode.PercentOutput, RobotMap.TELE_LIFT_SPEED);
    }

    //Retracts arm and winch. They do not need to be synced.
    public void goDown(){
        t_TeleArm.set(ControlMode.PercentOutput, RobotMap.-1);

    }

    //Stops both motors.
    public void stop(){
        t_TeleArm.set(ControlMode.PercentOutput,0)
    }

}