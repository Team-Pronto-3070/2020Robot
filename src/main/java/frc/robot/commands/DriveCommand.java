package frc.robot.commands; 

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;


public class DriveCommand extends CommandBase{

    
//do we need to pass subsystems in the constructor or can we call the static one 
   // private Drivetrain drive;

    public DriveCommand(Drivetrain dt){
    //  drive = dt;
      addRequirements(Robot.drive);
    
    }

    public void execute(){
      double left = 0;
      double right = 0;
      //double modifier = Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 2);

      left = (left + Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1) * .75 ) ;// averages the previous value and the current joystick value
      right = (right + Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1) * .75); //full speed ahead
  
          if(Math.abs(Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1)) > RobotMap.DEADZONE){
            Robot.drive.leftDrive(Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1));
          }else{
            Robot.drive.leftDrive(0);
          }
     
          if(Math.abs(Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1)) > RobotMap.DEADZONE){
            Robot.drive.rightDrive(-Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1));
          }else{
            Robot.drive.rightDrive(0);
          }
         

    

      // left = Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1) > RobotMap.DEADZONE ? Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1) : -Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1);
      // right = Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1) > RobotMap.DEADZONE ? Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1) : -Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1);
     // Robot.drive.tankDrive(-left, right);
    }

    public boolean isFinished() {
     return false;
    }

    protected void end(){

    }

    protected void initalize(){

    }

    protected void interrupted(){
      Robot.drive.stop();
    }

}