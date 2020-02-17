package frc.robot.commands.AutoCommands.MiddleStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class MiddleTurnIntoPort extends CommandBase {

    private Drivetrain drive;
    
    private boolean done = false;
    
    public MiddleTurnIntoPort(Drivetrain dt){
        drive = dt;
        addRequirements(dt);
    }

    public void execute(){
        done = drive.turnToAngle(90 - RobotMap.MIDDLE_START_TURN_ANGLE);
    }
    
    public boolean isFinished() {
        return done;
    }
}