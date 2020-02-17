package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class GroundIntake extends SubsystemBase {

    TalonSRX t_intake1;
    TalonSRX t_intake2;
    public GroundIntake(){
        t_intake1 = new TalonSRX(RobotMap.T_BELT1_PORT); 
        t_intake2 = new TalonSRX(RobotMap.T_BELT2_PORT);
    
    
    }

    public void intake(){
        t_intake1.set(ControlMode.PercentOutput, 1);
        t_intake2.set(ControlMode.PercentOutput, 1);
    }

}