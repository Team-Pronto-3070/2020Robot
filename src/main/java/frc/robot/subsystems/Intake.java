package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase {

    TalonSRX t_intake1;
    TalonSRX t_intake2;
    public Intake(){
        t_intake1 = new TalonSRX(RobotMap.T_BELT1_PORT); 
        t_intake2 = new TalonSRX(RobotMap.T_BELT2_PORT);
    
    
    }

    public void intake(){
        t_intake1.set(ControlMode.PercentOutput, 1);
    }

}