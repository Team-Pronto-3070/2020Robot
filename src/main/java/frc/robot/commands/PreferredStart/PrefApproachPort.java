package frc.robot.commands.PreferredStart;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
public class PrefApproachPort extends CommandBase {
    
    private Drivetrain drive;

    private boolean done = false;
    
    public PrefApproachPort(Drivetrain dt){
        drive = dt;
        addRequirements(drive);
    }

    public void execute(){
        done = drive.driveDistance(RobotMap.PREFFERED_DISTANCE);
    }

    public boolean isFinished(){
        return done;
    }
}