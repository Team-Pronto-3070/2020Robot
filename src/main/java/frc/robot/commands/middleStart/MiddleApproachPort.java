package frc.robot.commands.MiddleStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class MiddleApproachPort extends CommandBase {
    
    private Drivetrain drive;

    private boolean done = false;
    
    public MiddleApproachPort(Drivetrain dt){
        drive = dt;
        addRequirements(dt);
    }

    public void execute(){
        done = drive.driveDistance(RobotMap.MIDDLE_DISTANCE);
    }
    
    public boolean isFinished() {
        return done;
    }
}