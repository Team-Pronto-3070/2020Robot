package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ControlPanelStageOne extends CommandBase {

    

    public ControlPanelStageOne(){
       
        addRequirements(Robot.wof);

    }

    public void execute(){
       //needs to spin the thing 3-4 times
       RobotMap.ColorType currentColor = Robot.wof.getClosestColor();


        Robot.wof.go();
        int numRot = 3;
        if(numRot > 0){
            if(currentColor == Robot.wof.getClosestColor()){
                numRot--;
            }
        }
        Robot.wof.stop();
    
    }

    public boolean isFinished() {
     return false;
    }

    protected void end(){

    }

    protected void initalize(){

        

    }

    protected void interrupted(){

    }
}