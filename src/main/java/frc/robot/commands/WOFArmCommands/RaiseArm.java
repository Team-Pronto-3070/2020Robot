package frc.robot.commands.WOFArmCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.WOF;

public class RaiseArm extends CommandBase {

    private WOF wof;
    private boolean done = false;

    public RaiseArm(WOF wof){
        addRequirements(wof);
        this.wof = wof;
    }

    public void execute(){
        wof.moveArm(RobotMap.ARM_SOL_ON);
        done = true;
    }

    public boolean isFinished(){
        return done;
    }
}