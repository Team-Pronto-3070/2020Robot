package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Hopper;

public class UnloadHopper extends CommandBase{

    Hopper hop;

    public UnloadHopper(Hopper hopper){
        hop = hopper;
        addRequirements(hopper);
    }


    public void execute(){
        hop.out();
    }

    public void initialize(){

    }
    
    public void interrupted(){
    
    } 
    
    public boolean isFinished(){
    
        return false;
    }
    
    public void end(){
    
    } 

}