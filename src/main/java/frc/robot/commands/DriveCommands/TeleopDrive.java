package frc.robot.commands.DriveCommands; 

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.RobotMap.JOYSIDE;
import frc.robot.subsystems.Drivetrain;


public class TeleopDrive extends CommandBase{

    
//do we need to pass subsystems in the constructor or can we call the static one 
   // private Drivetrain drive;
    private static Drivetrain drive;
    private static OI oi;

    public TeleopDrive(Drivetrain dt, OI oi){
      TeleopDrive.oi = oi;
      drive = dt;
      addRequirements(drive);
    }

    public void execute(){
      // double left = 0;
      // double right = 0;
      // //double modifier = oi.getJoyAxis(RobotMap.JOYSIDE.Left, 2);

      // left = (left + oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1) * .75 ) ;// averages the previous value and the current joystick value
      // right = (right + oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1) * .75); //full speed ahead
  
      //     if(Math.abs(oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1)) > RobotMap.DEADZONE){
      //       drive.leftDrive(oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1) * getInputScaler(RobotMap.JOYSIDE.Left));
      //     }else{
      //       drive.leftDrive(0);
      //     }
     
      //     if(Math.abs(oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1)) > RobotMap.DEADZONE){
      //       drive.rightDrive(-oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1) * getInputScaler(RobotMap.JOYSIDE.Right));
      //     }else{
      //       drive.rightDrive(0);
      //     }    

      // left = oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1) > RobotMap.DEADZONE ? oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1) : -oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1);
      // right = oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1) > RobotMap.DEADZONE ? oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1) : -oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1);
      drive.tankDrive(oi.getJoyAxis(JOYSIDE.Left, 1), oi.getJoyAxis(JOYSIDE.Right, 1));
    }

    public boolean isFinished() {
     return false;
    }

    protected void end(){

    }

    protected void initalize(){

    }

    protected void interrupted(){
      drive.stop();
    }

    public double getInputScaler(RobotMap.JOYSIDE side){
      if(side == RobotMap.JOYSIDE.Right)
        return -oi.j_RIGHT.getRawAxis(2);
      else
        return -oi.j_LEFT.getRawAxis(2);
    }
  

}