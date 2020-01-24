package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

class Hopper extends SubsystemBase {
    
    TalonSRX t_Hopper;
    
    public Hopper(){
        t_Hopper = new TalonSRX(RobotMap.T_HOPPER_PORT);
        
    
    
    }

    public void goUp(){
        t_Hopper.set(ControlMode.PercentOutput, RobotMap.HOPPER_LIFT_SPEED);
       
    }

    //Retracts arm and winch. They do not need to be synced.
    public void goDown(){
        t_Hopper.set(ControlMode.PercentOutput, -1);
       
    }

    //Stops both motors.
    public void stop(){
        t_Hopper.set(ControlMode.PercentOutput,0);
        
    }

}