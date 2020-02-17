package frc.robot.commands.CompressorCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GBCompressor;

public class StopCompressor extends CommandBase {

    GBCompressor comp;

    public StopCompressor(GBCompressor comp){
        this.comp = comp;
    }

    public void execute(){
        comp.stop();
    }

    public boolean isFinished(){
        return false;
    }
}