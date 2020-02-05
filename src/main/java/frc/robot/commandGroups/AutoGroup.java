package frc.robot.commandGroups;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.LeftStart.*;
import frc.robot.commands.MiddleStart.*;
import frc.robot.commands.RightStart.*;
import frc.robot.commands.PreferredStart.*;
import frc.robot.subsystems.*;

public class AutoGroup extends SequentialCommandGroup{
    
    public AutoGroup(RobotMap.StartingPosition pos, Drivetrain dt, Hopper hop){
        switch(pos) {
            case Left:
                addCommands(new LeftTurnToPort(dt), new LeftApproachPort(dt), new LeftTurnIntoPort(dt), new AutoUnloadHopper(hop));
            break;
            case Right:
                addCommands(new RightTurnToPort(), new RightApproachPort(), new RightTurnIntoPort(), new AutoUnloadHopper(hop));
                break;
            case Middle:
                addCommands(new MiddleTurnToPort(dt), new MiddleApproachPort(dt), new MiddleTurnIntoPort(dt), new AutoUnloadHopper(hop));
                break;
        }
    }
}