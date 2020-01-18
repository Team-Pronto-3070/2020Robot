package frc.robot.commands; 

import edu.wpi.first.wpilibj.command.Command;



public class DriveCommand extends Command{



    public DriveCommand(){
        

        requires(Robot.Drivetrain());
    }
    //drive(Drivetrain :: tankDrive(joyL.getRaw) )
    public void drive(){

    }

}