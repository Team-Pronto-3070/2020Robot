package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ClimberDown extends CommandBase {

    private Climber climb;

    public ClimberDown(Climber climber){
        climb = climber;
        addRequirements(climber);
    }

    public void execute(){
        climb.goDown();
    }

    public boolean isFinished(){
        return false;
    }    
}