package frc.robot.commands.RightStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

public class RightTurnIntoPort extends CommandBase {

    private Drivetrain drive;
    
    public RightTurnIntoPort(Drivetrain dt){
        drive = dt;
        addRequirements(drive);
    }
}