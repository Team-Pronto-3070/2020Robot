package frc.robot.commands; 

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;


public class DriveCommand extends CommandBase{

    private final Drivetrain drive;

    public DriveCommand(Drivetrain dt){
      drive = dt;
      addRequirements(dt);
    }
    //drive(Drivetrain :: tankDrive(joyL.getRaw) )
    public void execute(){
      drive.tankDrive(Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Left, 1), Robot.m_oi.getJoyAxis(RobotMap.JOYSIDE.Right, 1));
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