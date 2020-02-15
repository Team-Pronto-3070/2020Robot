package frc.robot.commands.MiddleStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class MiddleTurnToPort extends CommandBase {

    private Drivetrain drive;

    private boolean done = false;
    
    public MiddleTurnToPort(Drivetrain dt){
        drive = dt;
        addRequirements(dt);
    }

    public void execute(){
        done = drive.turnToAngle(RobotMap.MIDDLE_START_TURN_ANGLE);
    }
  
      public boolean isFinished() {
        return done;
    }
}