package frc.robot.subsystems;

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

    public void goUp(){
        
    }

    public void goDown(){

    }

}