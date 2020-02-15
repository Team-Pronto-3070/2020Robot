package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.WOF;

public class ToggleArm extends CommandBase {

    private WOF wof;
    private boolean done = false;

    public ToggleArm(WOF wof){
        addRequirements(wof);
        this.wof = wof;
    }

    public void execute(){
        if(wof.armSol.get() == RobotMap.ARM_SOL_OFF)
            wof.moveArm(RobotMap.ARM_SOL_ON);
        else 
            wof.moveArm(RobotMap.ARM_SOL_OFF);
            
        done = true;
    }

    public boolean isFinished(){
        return done;
    }
}