package frc.robot.commands.RightStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class RightApproachPort extends CommandBase {
    
    private Drivetrain drive;
    
    public RightApproachPort(Drivetrain dt){
        drive = dt;
        addRequirements(drive);
    }
}