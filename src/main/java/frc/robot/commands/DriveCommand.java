package frc.robot.commands; 

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;


public class DriveCommand extends Command{

    

    public DriveCommand(){
        
      requires(Robot.drivetrain);
        
    }
    //drive(Drivetrain :: tankDrive(joyL.getRaw) )
    public void drive(){

    }

    public void execute(){
      Robot.drivetrain.tankDrive();
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){

    }

    protected void initalize(){

    }

    protected void interrupted(){

    }

}