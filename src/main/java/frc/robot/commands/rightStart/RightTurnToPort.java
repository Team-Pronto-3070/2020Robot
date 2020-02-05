package frc.robot.commands.RightStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class RightTurnToPort extends CommandBase {

    private Drivetrain drive;
    
    public RightTurnToPort(){
        drive = Robot.drive;
        addRequirements(drive);
    }

    public void execute(){
        if(drive.turnToAngle(RobotMap.LEFT_START_TURN_ANGLE))
            drive.stop();
        else   
            drive.turnToAngle(RobotMap.LEFT_START_TURN_ANGLE);
    }
  
      public boolean isFinished() {
        return drive.turnToAngle(RobotMap.LEFT_START_TURN_ANGLE);
    }
  
      protected void end(){
  
      }
  
      protected void initalize(){
  
      }
  
      protected void interrupted(){
  
      }
}