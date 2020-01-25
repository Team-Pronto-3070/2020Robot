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
        drive.tankDrive(Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1), Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1));
        if(drive.turnToAngle(RobotMap.LEFT_START_TURN_ANGLE))
            drive.stop();
        else   
            drive.turnToAngle(RobotMap.LEFT_START_TURN_ANGLE);
      }
  
      public boolean isFinished() {
<<<<<<< HEAD
      // if(drive.)
      return false;
=======
>>>>>>> 76502c1f1d62d8d54068ab2e24e79e7857574d9a
      }
  
      protected void end(){
  
      }
  
      protected void initalize(){
  
      }
  
      protected void interrupted(){
  
      }
}