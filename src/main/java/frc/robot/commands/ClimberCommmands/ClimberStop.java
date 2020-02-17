package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ClimberStop extends CommandBase {

    private Climber climb;

    public ClimberStop(Climber climber){
        climb = climber;
        addRequirements(climber);
    }

    public void execute(){
        climb.stop();
    }   
}