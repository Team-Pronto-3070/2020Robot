package frc.robot.commands.AutoCommands.PreferredStart;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Gearbox;
import frc.robot.subsystems.Hopper;

public class PrefApproachPort extends CommandBase {
    
    private Drivetrain drive;
    private Hopper hop;
    private Gearbox gearbox;

    private boolean done = false;
    private boolean doneTwo = false;

    double counter = 0;
    
    public PrefApproachPort(Drivetrain dt, Hopper hopper, Gearbox gb){
        drive = dt;
        hop = hopper;
        gearbox = gb;
        addRequirements(drive);
        addRequirements(hopper);
        drive.resetEncoderValues();
        counter = 0;
    }

    public void execute(){
        done = drive.driveDistance(RobotMap.PREFFERED_DISTANCE - 1);
        // if(Math.abs(drive.getLeftEncoderPosition()) > Math.abs((RobotMap.PREFFERED_DISTANCE - 15) * RobotMap.ticksPerInch(gearbox.getGearboxPosition())))
        
          
        if(counter >= 110){
            drive.stop();
            hop.out();
            doneTwo = true;
        }
        else{
            counter++;
        System.out.println("Goal: " + (RobotMap.ticksPerInch(gearbox.getGearboxPosition()) * (RobotMap.PREFFERED_DISTANCE - 16)) + "Actual: " + drive.getLeftEncoderPosition());
        }
    }

    public boolean isFinished(){
        return done && doneTwo;
    }

    public void end(){
    }
}