package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

//TODO: Comment up

public class Climber extends SubsystemBase{  //This whole system will be used as a single command.

    TalonSRX t_winch;
    TalonSRX t_teleArm;
    
    
    public Climber(){
        t_winch = new TalonSRX(RobotMap.T_WINCH_PORT); //sets the motor for the winch
        t_teleArm = new TalonSRX(RobotMap.T_TELE_PORT); //sets the motor for the lift arm

       
    }

    public void goUp(){
        
            t_winch.set(ControlMode.PercentOutput, RobotMap.WINCH_LIFT_SPEED); // creates a speed command for the winch located in RobotMap
            t_teleArm.set(ControlMode.PercentOutput, RobotMap.TELE_LIFT_SPEED); // creates a speed command for the lift arm located in RobotMap

    }
    public void teleArmDown(){
        t_teleArm.set (ControlMode.PercentOutput, -1); //tells the arm to fall.
    }
    public void winchDown(){
        t_winch.set (ControlMode.PercentOutput, -1); //tells the winch to reverse.
    }
    public void stop(){
        t_teleArm.set(ControlMode.PercentOutput,0); // Stops all the movement.
        t_winch.set(ControlMode.PercentOutput,0); 
    }

}






// OwO what's this