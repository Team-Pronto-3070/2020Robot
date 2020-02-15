package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.RobotMap.*;
import frc.robot.subsystems.WOF;

public class ControlPanelStageOne extends CommandBase {
    private WOF wof;
    private RobotContainer rc;

    public ControlPanelStageOne(WOF wof, RobotContainer rc){
        this.wof = wof;
        this.rc = rc;
        addRequirements(wof);
    }

    public void execute(){
        //needs to spin the thing 3-4 times
        RobotMap.ColorType currentColor = wof.getClosestColor();

        wof.go();
        int numRot = 3;
        if(numRot > 0){
            wof.setDashColor();
            if(currentColor == wof.getClosestColor()){
                numRot--;
            }
        }
        wof.stop();
    }

    public boolean isFinished() {
     return false;
    }

    protected void end(){
        rc.configWOFButton(WOF_Stage.STAGE_TWO);
    }

    protected void initalize(){

    }

    protected void interrupted(){

    }
}