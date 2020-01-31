package frc.robot.commands.leftStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class LeftApproachPort extends CommandBase {
    
    private Drivetrain drive;
    
    public LeftApproachPort(Drivetrain dt){
        drive = dt;
        addRequirements(dt);
    }
}