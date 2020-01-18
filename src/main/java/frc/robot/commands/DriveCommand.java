package frc.robot.commands; 

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;


public class DriveCommand extends Command{

    

    public DriveCommand(){
        
        requires(new Drivetrain());
        
    }
    //drive(Drivetrain :: tankDrive(joyL.getRaw) )
    public void drive(){

    }

    protected boolean isFinished(){
        return false;
    }

}