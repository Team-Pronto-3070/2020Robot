package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;

//The hopper is a container that holds multiple balls, and pukes them out using traction wheels. 
//It's angled so all the balls congregate near the wheels, allowing great simplicity in the activation of the program. on = puke

public class Hopper extends SubsystemBase { 
    //Hopper is part of the subsystems folder
    
    
    TalonSRX t_Hopper; 
    //Selects the talonport t_Hopper
    
    public Hopper(){ //constructor
        t_Hopper = new TalonSRX(RobotMap.T_HOPPER_PORT); 
        //defines the port as a motor, and connects it to a similarly named value in RobotMap. 
    }

    public void in(){
        t_Hopper.set(ControlMode.PercentOutput, RobotMap.HOPPER_LIFT_SPEED); 
        //gives it a percent speed, taking the value from RobotMap
    }

    public void out(){
        t_Hopper.set(ControlMode.PercentOutput, -1); 
        //sets the speed as -1, which will spit out any balls in it using the traction wheels.
    }

    public void stop(){
        t_Hopper.set(ControlMode.PercentOutput,0); 
        //sets the speed as 0, stopping the wheels.
    }

}
