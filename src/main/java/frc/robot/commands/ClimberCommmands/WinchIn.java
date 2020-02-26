package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class WinchIn extends CommandBase {

    private Climber climb;

    public WinchIn(Climber climb){
        addRequirements(climb);
        this.climb = climb;
    }

    public void execute(){
        climb.winchIn();
    }

    public boolean aisFinished(){
        return false;
    }
}