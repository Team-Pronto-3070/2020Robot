package frc.robot.commands.LeftStart;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class LeftTurnIntoPort extends CommandBase {

    private Drivetrain drive;

    public LeftTurnIntoPort(Drivetrain dt) {
        drive = dt;
        addRequirements(dt);
    }

    public boolean isFinished() {
        return drive.turnToAngle(RobotMap.LEFT_START_TURN_ANGLE);
    }

    protected void end() {

    }

    protected void initalize() {

    }

    protected void interrupted() {

    }

    public void execute() {
        // add a check for the gyro to make sure it is turning the right angle(use
        // constant from the map)

        drive.t_frontLeft.set(ControlMode.PercentOutput, .69);
        drive.t_backLeft.set(ControlMode.PercentOutput, .69);
        drive.t_frontRight.set(ControlMode.PercentOutput, .69);
        drive.t_backRight.set(ControlMode.PercentOutput, .69);
    }
}
