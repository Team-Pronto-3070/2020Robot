package frc.robot.commands.WOFWheelCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WOF;

public class StopWOF extends CommandBase {
    private WOF wof;

    public StopWOF(WOF wof){
        addRequirements(wof);
        this.wof = wof;
    }

    public void execute(){
        wof.stop();
    }

    public boolean isFinished(){
        return false;
    }
}