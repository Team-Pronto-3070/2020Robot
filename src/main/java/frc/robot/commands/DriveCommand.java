package frc.robot.commands; 

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class DriveCommand extends CommandBase{

    
//do we need to pass subsystems in the constructor or can we call the static one 
   // private Drivetrain drive;

    public DriveCommand(){
    //  drive = dt;
      addRequirements(Robot.drive);
    }
    //drive(Drivetrain :: tankDrive(joyL.getRaw) )
    public void execute(){
      double left = Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1) > RobotMap.DEADZONE ? Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1) : 0;
      double right = Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1) > RobotMap.DEADZONE ? Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1) : 0;
      Robot.drive.tankDrive(left, right);
    }

    public boolean isFinished() {
     return false;
    }

    protected void end(){

    }

    protected void initalize(){

    }

    protected void interrupted(){

    }

}