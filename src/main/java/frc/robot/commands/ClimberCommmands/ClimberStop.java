package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberArm;

public class ClimberStop extends CommandBase {

    private ClimberArm climb;

    public ClimberStop(ClimberArm climber){
        climb = climber;
        addRequirements(climber);
    }

    public void execute(){
        climb.stop();
    }   
}