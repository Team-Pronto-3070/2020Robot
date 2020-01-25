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
      }
  
      public boolean isFinished() {
       if(drive.)
      }
  
      protected void end(){
  
      }
  
      protected void initalize(){
  
      }
  
      protected void interrupted(){
  
      }
}