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
      Robot.drive.tankDrive(Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1), Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1));
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