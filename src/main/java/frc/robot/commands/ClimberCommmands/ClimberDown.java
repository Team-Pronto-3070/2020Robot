package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberArm;

public class ClimberDown extends CommandBase {

    private ClimberArm climb;

    public ClimberDown(ClimberArm climber){
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