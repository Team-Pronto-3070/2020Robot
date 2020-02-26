package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class FlipDriveControls extends CommandBase {

    private Drivetrain drive;

    public FlipDriveControls(Drivetrain dt){
        drive = dt;
        addRequirements(dt);
    }

    public void execute(){
        drive.flipDirection();
    }

    public boolean isFinished(){
        return true;
    }
}