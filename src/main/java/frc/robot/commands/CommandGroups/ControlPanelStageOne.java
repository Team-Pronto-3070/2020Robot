package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.WOFWheelCommands.*;
import frc.robot.subsystems.WOF;
import frc.robot.RobotContainer;
import frc.robot.commands.WOFArmCommands.*;

public class ControlPanelStageOne extends SequentialCommandGroup {

    public ControlPanelStageOne(WOF wof, RobotContainer rc){
        addCommands(new RaiseArm(wof), new Wait(), new LowerArm(wof), new StageOneSpin(wof, rc),  new RaiseArm(wof));
    }
}