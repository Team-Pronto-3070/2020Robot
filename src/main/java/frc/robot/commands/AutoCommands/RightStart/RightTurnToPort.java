package frc.robot.commands.AutoCommands.RightStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class RightTurnToPort extends CommandBase {

    private Drivetrain drive;
    
    private boolean done = false;
    
    public RightTurnToPort(Drivetrain dt){
        drive = dt;
        addRequirements(drive);
    }

    public void execute(){
        done = drive.turnToAngle(RobotMap.RIGHT_START_TURN_ANGLE);
    }
  
    public boolean isFinished() {
        return done;
    }
}