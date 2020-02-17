package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

//this is the program on how the robot picks up balls on the ground.
//the motors, when running, will run a belt which will pull balls along it, depositing them into the hopper.

public class GroundIntake extends SubsystemBase {
//GroundIntake is part of the subsystems folder.

    TalonSRX t_intake1; //selects the talonports t_intake1 and t_intake2.
    TalonSRX t_intake2;
    public GroundIntake(){ //constructor
        t_intake1 = new TalonSRX(RobotMap.T_BELT1_PORT); //defines the ports as a talon, connecting them to the variable in RobotMap
        t_intake2 = new TalonSRX(RobotMap.T_BELT2_PORT); 
    }

    public void intake(){
        t_intake1.set(ControlMode.PercentOutput, 1); //gives the intake motors the value of 100%, turning them on.
        t_intake2.set(ControlMode.PercentOutput, 1); //it makes them run the belt, moving the balls.
    }

    public void stop(){
        t_intake1.set(ControlMode.PercentOutput, 0);//this stops the motors, stoppin the belt.
        t_intake2.set(ControlMode.PercentOutput, 0);
    }

}