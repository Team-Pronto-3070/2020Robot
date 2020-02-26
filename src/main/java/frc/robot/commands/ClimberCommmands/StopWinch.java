package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class StopWinch extends CommandBase {

    private Climber climb;

    public StopWinch(Climber climb){
        addRequirements(climb);
        this.climb = climb;
    }

    public void execute(){
        climb.stopWinch();
    }

    public boolean aisFinished(){
        return false;
    }
}