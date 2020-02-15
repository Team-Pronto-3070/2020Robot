package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class StopHopper extends CommandBase {
    private Hopper hop;
    private boolean done = false;

    public StopHopper(Hopper hop){
        addRequirements(hop);
        this.hop = hop;
    }

    public void execute(){
        hop.stop();
        done = true;
    }

    public boolean isFinished(){
        return done;
    }
}