package frc.robot.commands.leftStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class TurnToPort extends CommandBase {

    private Drivetrain drive;
    
    public TurnToPort(Drivetrain dt){
        drive = dt;
        addRequirements(dt);
    }

    public void execute(){
        if(drive.turntoAngle(RobotMap.LEFT_START_TURN_ANGLE))
            drive.stop();
        else   
            drive.turnToAngle(RobotMap.LEFT_START_TURN_ANGLE);
      }
  
      public boolean isFinished() {
        if(drive.getAngle() >= RobotMap.LEFT_START_TURN_ANGLE)
            return true;
       else 
            return false;
      }
  
      protected void end(){
  
      }
  
      protected void initalize(){
  
      }
  
      protected void interrupted(){
  
      }
}