package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeBall extends CommandBase
{
private Intake iNtake;
public IntakeBall (Intake s_intake) {
    iNtake = s_intake;
    addRequirements(iNtake);
}
public void execute(){
    iNtake.intake();   
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