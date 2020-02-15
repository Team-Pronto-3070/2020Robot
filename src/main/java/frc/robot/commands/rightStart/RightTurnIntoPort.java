package frc.robot.commands.RightStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class RightTurnIntoPort extends CommandBase {

    private Drivetrain drive;
    private boolean done = false;
    
    public RightTurnIntoPort(Drivetrain dt){
        drive = dt;
        addRequirements(drive);
    }

    public void execute(){
        done = drive.turnToAngle(90 - RobotMap.RIGHT_START_TURN_ANGLE);
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