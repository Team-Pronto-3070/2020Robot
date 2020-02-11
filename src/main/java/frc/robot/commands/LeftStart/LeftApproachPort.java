package frc.robot.commands.LeftStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class LeftApproachPort extends CommandBase {
    
    private Drivetrain drive;
    
    public LeftApproachPort(Drivetrain dt){
        drive = dt;
        addRequirements(dt);
    }

    public void execute(){
        
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