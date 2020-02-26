package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Winch;

public class StopWinch extends CommandBase {

    private Winch winch;

    public StopWinch(Winch winch){
        addRequirements(winch);
        this.winch = winch;
    }

    public void execute(){
        winch.stop();
    }

    public boolean isFinished(){
        return false;
    }
}