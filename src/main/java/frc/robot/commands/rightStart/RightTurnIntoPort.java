package frc.robot.commands.RightStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class RightTurnIntoPort extends CommandBase {

    private Drivetrain drive;
    
    public RightTurnIntoPort(Drivetrain dt){
        drive = dt;
        addRequirements(drive);
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