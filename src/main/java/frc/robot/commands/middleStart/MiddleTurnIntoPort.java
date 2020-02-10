package frc.robot.commands.MiddleStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class MiddleTurnIntoPort extends CommandBase {

    private Drivetrain drive;
    
    public MiddleTurnIntoPort(Drivetrain dt){
        drive = dt;
        addRequirements(dt);
    }
}