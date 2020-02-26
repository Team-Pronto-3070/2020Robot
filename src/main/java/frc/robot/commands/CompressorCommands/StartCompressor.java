package frc.robot.commands.CompressorCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GBCompressor;

public class StartCompressor extends CommandBase {

    GBCompressor comp;

    public StartCompressor(GBCompressor comp){
        this.comp = comp;
    }

    public void execute(){
        comp.start();
    }

    public boolean isFinished(){
        return false;
    }
}