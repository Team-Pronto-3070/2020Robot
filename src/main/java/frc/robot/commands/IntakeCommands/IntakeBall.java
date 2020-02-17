package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GroundIntake;

public class IntakeBall extends CommandBase
{
private GroundIntake intake;
public IntakeBall (GroundIntake in) {
    intake =in;
    addRequirements(intake);
}
public void execute(){
    intake.intake();   
}

public void initialize(){

}

public void interrupted(){

} 

public boolean isFinished(){

    return false;
}

public void end(){

} 
}