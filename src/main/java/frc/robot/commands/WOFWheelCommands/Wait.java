package frc.robot.commands.WOFWheelCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;

public class Wait extends CommandBase {

    private Timer timer = new Timer();

    public Wait(){
        timer.reset();
    }

    public void execute(){
        timer.start();
    }

    public boolean isFinished(){
        return timer.hasPeriodPassed(RobotMap.WOF_WAIT_PERIOD);
    }
}