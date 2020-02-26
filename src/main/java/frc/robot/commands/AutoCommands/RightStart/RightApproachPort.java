package frc.robot.commands.AutoCommands.RightStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class RightApproachPort extends CommandBase {
    
    private Drivetrain drive;

    private boolean done = false;
    
    public RightApproachPort(Drivetrain dt){
        drive = dt;
        addRequirements(drive);
    }

    public void execute(){
        done = drive.driveDistance(RobotMap.RIGHT_DISTANCE);
    }

    public boolean isFinished() {
        return done;
    }
}