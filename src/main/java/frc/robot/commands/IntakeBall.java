package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeBall extends CommandBase
{
private Intake intake;
public IntakeBall (Intake in) {
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