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
    RobotMap.ColorType initColor;
    private boolean passed = false;
    
    public StageOneSpin(WOF wof, RobotContainer rc){
        this.wof = wof;
        this.rc = rc;
        addRequirements(wof);
    }

    public void initalize(){
        initColor = wof.getClosestColor(); //Sets reference color to count rotations
    }

    public void execute(){
        //needs to spin the thing 3-4 times
        wof.go();
        // if(numRot > 0){   //If there is still rotations to go
        //     wof.go(); //Start spinning
        //     wof.setDashColor(); //Refresh booleans to SmartDashboard
        //     if(!passed && wof.getClosestColor() != initColor) //if the color changes
        //         passed = true; //Set passed to true so that next loop, it knows its a new segment
        //     else if(passed && initColor == wof.getClosestColor()){ //If color has passed again
        //         numRot--; //Increment down
        //         passed = false; //Reset
        //     }
        // }
    }

    public boolean isFinished() {
     return numRot == 0; //If the rotations are complete, then return true
    }

    protected void end(){
        wof.stop();
        rc.configWOFButton(WOF_Stage.STAGE_TWO); //Iterates command stage
    }

    
}