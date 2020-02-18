package frc.robot.commands.WOFWheelCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.RobotMap.*;
import frc.robot.subsystems.WOF;

public class StageOneSpin extends CommandBase {
    private WOF wof;
    private RobotContainer rc;
    int numRot = RobotMap.WOF_PASSES;
    RobotMap.ColorType currentColor;
    
    public StageOneSpin(WOF wof, RobotContainer rc){
        this.wof = wof;
        this.rc = rc;
        addRequirements(wof);
    }

    public void initalize(){
        currentColor = wof.getClosestColor();
    }

    public void execute(){
        //needs to spin the thing 3-4 times

        if(numRot > 0){   
            wof.go();
            wof.setDashColor();
            if(currentColor == wof.getClosestColor()){
                numRot--;
            }
        } else {
            wof.stop();
        }
    }

    public boolean isFinished() {
     return numRot == 0;
    }

    protected void end(){
        rc.configWOFButton(WOF_Stage.STAGE_TWO);
    }

    protected void interrupted(){

    }
}