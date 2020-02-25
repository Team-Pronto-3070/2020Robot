package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class WinchOut extends CommandBase {

    private Climber climb;

    public WinchOut(Climber climb){
        addRequirements(climb);
        this.climb = climb;
    }

    public void execute(){
        climb.winchOut();
    }

    public boolean isFinished(){
        return false;
    }
}