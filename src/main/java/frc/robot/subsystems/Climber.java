package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

class Climber extends SubsystemBase{

    TalonSRX t_Winch = new TalonSRX(RobotMap.T_WINCH_PORT);
    TalonSRX t_TeleArm = new TalonSRX(RobotMap.T_TELE_PORT);
    
    public Climber(){
        
    }
}