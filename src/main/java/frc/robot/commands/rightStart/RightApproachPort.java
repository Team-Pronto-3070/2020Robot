package frc.robot.commands.rightStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

public class RightApproachPort extends CommandBase {
    
    private Drivetrain drive;
    
    public RightApproachPort(){
        drive = Robot.drive;
        addRequirements(drive);
    }
}