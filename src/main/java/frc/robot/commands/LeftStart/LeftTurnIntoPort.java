package frc.robot.commands.LeftStart;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class LeftTurnIntoPort extends CommandBase {

    private Drivetrain drive;

    private boolean done = false;

    public LeftTurnIntoPort(Drivetrain dt) {
        drive = dt;
        addRequirements(dt);
    }

    public void execute(){
        done = drive.turnToAngle(90 - RobotMap.LEFT_START_TURN_ANGLE);
    }

    public boolean isFinished() {
        return done;
    }
}
