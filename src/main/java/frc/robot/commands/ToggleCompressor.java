package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GBCompressor;

public class ToggleCompressor extends CommandBase {

    GBCompressor comp;

    public ToggleCompressor(GBCompressor comp){
        this.comp = comp;
    }

    public void execute(){
        comp.toggle();
    }

    public boolean isFinished(){
        return false;
    }
}