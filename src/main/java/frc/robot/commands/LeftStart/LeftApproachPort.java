package frc.robot.commands.LeftStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class LeftApproachPort extends CommandBase {
    
    private Drivetrain drive;
    
    public LeftApproachPort(Drivetrain dt){
        drive = dt;
        addRequirements(dt);
    }
}