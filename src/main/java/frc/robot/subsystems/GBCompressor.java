package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GBCompressor extends SubsystemBase {

    Compressor comp;
    private boolean on = false;

    public GBCompressor(){ //constructor
        comp = new Compressor();
    }

    public void stop(){
        comp.stop();
        on = false;
    }

    public void start(){
        comp.start();
        on = true;
    }

    public void toggle(){
        if(on)
            stop();
        else
            start();
    }
}