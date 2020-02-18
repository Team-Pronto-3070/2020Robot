package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ToggleClimber extends CommandBase {

    private Climber climb;

    public ToggleClimber(Climber climber){
            climb = climber;
            addRequirements(climber);
    }

    public void execute(){
        climb.toggle();
    }

    public boolean isFinished(){
        return false;
    }    
}