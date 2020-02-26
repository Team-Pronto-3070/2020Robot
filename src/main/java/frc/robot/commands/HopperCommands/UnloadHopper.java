package frc.robot.commands.HopperCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;


public class UnloadHopper extends CommandBase{

    private Hopper hop;
    private boolean done = false;

    public UnloadHopper(Hopper hopper){
        hop = hopper;
        addRequirements(hopper);
    }


    public void execute(){
        hop.out();
        done = true;
    }

    public boolean isFinished(){
        return done;
    }
    
    public void end(){
    
    } 

}