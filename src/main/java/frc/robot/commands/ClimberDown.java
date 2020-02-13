package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ClimberDown extends CommandBase {

    private Climber climb;
    DigitalInput lowerLimit;

    public ClimberDown(Climber climber){
            climb = climber;
            addRequirements(climber);

            lowerLimit = new DigitalInput(1);
    }

    public void execute(){
        if(!lowerLimit.get()){
            climb.teleArmDown();
        }
    }


    
}