package frc.robot.commands.leftStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class LeftTurnIntoPort extends CommandBase {

    private Drivetrain drive;
    
    public LeftTurnIntoPort(Drivetrain dt){
        drive = dt;
        addRequirements(dt);
    }
}