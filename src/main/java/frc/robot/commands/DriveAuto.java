package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;


public class DriveAuto extends CommandBase {
    Drivetrain drive;

    public DriveAuto(Drivetrain dt){
        drive = dt;
        addRequirements(drive);

    }



    public void execute(){
       

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
/** 
if start at preffered, then go forward till robot hits wall
    activate Hopper.out 
    wait 2 seconds then activate hopper.stop
if start at left, then rotate 51.7 to the left, 
    then go forward till right corner hits wall, 
    then turn left till left side hits wall,
    activate Hopper.out 
    wait 2 seconds then activate hopper.stop
if start at middle, then rotate 34.743 to the right, 
    then go forward till left corner hits wall, 
    then turn right till left side hits wall
    activate Hopper.out 
    wait 2 seconds then activate hopper.stop
if start at right, then turn 60.57 to the right
    then go forward till left corner hits wall, 
    then turn right till left side hits wall
    activate Hopper.out 
    wait 2 seconds then activate hopper.stop
*/