package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.AutoCommands.LeftStart.*;
import frc.robot.commands.AutoCommands.MiddleStart.*;
import frc.robot.commands.AutoCommands.PreferredStart.*;
import frc.robot.commands.AutoCommands.RightStart.*;
import frc.robot.commands.HopperCommands.AutoUnloadHopper;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;

public class AutoGroup extends SequentialCommandGroup{
    
    public AutoGroup(RobotMap.StartingPosition pos, Drivetrain dt, Hopper hop){
        switch(pos) {
            case Left:
                addCommands(new LeftTurnToPort(dt), new LeftApproachPort(dt), new LeftTurnIntoPort(dt), new AutoUnloadHopper(hop));
            break;
            case Right:
                addCommands(new RightTurnToPort(dt), new RightApproachPort(dt), new RightTurnIntoPort(dt), new AutoUnloadHopper(hop));
                break;
            case Middle:
                addCommands(new MiddleTurnToPort(dt), new MiddleApproachPort(dt), new MiddleTurnIntoPort(dt), new AutoUnloadHopper(hop));
                break;
            case Preffered:
                addCommands(new PrefApproachPort(dt), new AutoUnloadHopper(hop));
                break;
        }


    }
}