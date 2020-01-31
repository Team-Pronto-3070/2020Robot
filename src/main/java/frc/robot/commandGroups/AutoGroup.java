package frc.robot.commandGroups;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.LeftStart.*;
import frc.robot.commands.middleStart.*;
import frc.robot.commands.rightStart.*;
import frc.robot.commands.preferredStart.*;
import frc.robot.subsystems.Drivetrain;

public class AutoGroup extends SequentialCommandGroup{
    
    public AutoGroup(RobotMap.StartingPosition pos, Drivetrain dt){
        switch(pos) {
            case Left:
                addCommands(new LeftTurnToPort(dt), new );
        }
    }
}