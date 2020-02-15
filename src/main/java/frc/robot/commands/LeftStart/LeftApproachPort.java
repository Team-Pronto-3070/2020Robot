package frc.robot.commands.LeftStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class LeftApproachPort extends CommandBase {
    
    private Drivetrain drive;

    private boolean done = false;
    
    public LeftApproachPort(Drivetrain dt){
        drive = dt;
        addRequirements(dt);
    }

    public void execute(){
        done = drive.driveDistance(RobotMap.LEFT_DISTANCE);
    }

    public boolean isFinished() {
        return done;
    }
}