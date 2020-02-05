package frc.robot.commands.PreferredStart;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
public class PrefApproachPort extends CommandBase {
    


    
    private Drivetrain drive;
    
    public PrefApproachPort(Drivetrain dt){
        drive = dt;
        addRequirements(drive);
    }
    public void execute()
{

}
public boolean isFinished() {
 return false;
}

protected void end(){

}

protected void initalize(){

}

protected void interrupted(){
 // Robot.drive.stop();
}

}

//we has gots to drive forward "x" feet, and then we need to shoot the balls out