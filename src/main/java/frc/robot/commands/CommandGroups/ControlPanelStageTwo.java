package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.WOFWheelCommands.*;
import frc.robot.subsystems.WOF;
import frc.robot.commands.WOFArmCommands.*;

public class ControlPanelStageTwo extends SequentialCommandGroup {

    public ControlPanelStageTwo(WOF wof){
        addCommands(new RaiseArm(wof), new Wait(), new LowerArm(wof), new StageTwoSpin(wof), new RaiseArm(wof));
    }
}