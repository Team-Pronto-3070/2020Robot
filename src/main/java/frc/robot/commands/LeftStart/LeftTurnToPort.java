package frc.robot.commands.LeftStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class LeftTurnToPort extends CommandBase {
    boolean done;
    private Drivetrain drive;
    
    public LeftTurnToPort(Drivetrain dt){
        done = false;
        drive = dt;
        addRequirements(dt);
    }

    public void execute(){
        if(drive.turnToAngle(RobotMap.LEFT_START_TURN_ANGLE))
            drive.stop();
        else   
            drive.turnToAngle(RobotMap.LEFT_START_TURN_ANGLE);
    
        done = drive.turnToAngle(RobotMap.LEFT_START_TURN_ANGLE);
        }
  
      public boolean isFinished() {
        return done;
    }
  
      protected void end(){
  
      }
  
      protected void initalize(){
  
      }
  
      protected void interrupted(){
  
      }
}