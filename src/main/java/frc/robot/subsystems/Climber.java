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

    //Extends arm and spools out winch. When height 68.5 inches is reached, stop. 
    //Note: arm and winch extend at different rates, which must be kept in sync. 
    //These are defined in RobotMap.WINCH_LIFT_SPEED and RobotMap.TELE_LIFT_SPEED
    public void goUp(){
        t_Winch.set(ControlMode.PercentOutput, RobotMap.WINCH_LIFT_SPEED);
        t_TeleArm.set(ControlMode.PercentOutput, RobotMap.TELE_LIFT_SPEED);
    }

    //Retracts arm and winch. They do not need to be synced. Once it has descended 68.5 inches, stop.  
    public void goDown(){

    }

}