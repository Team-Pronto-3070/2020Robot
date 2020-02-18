package frc.robot.commands.WOFWheelCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.WOF;


public class StageTwoSpin extends CommandBase {

    private WOF wof;
    private boolean done = false;
    String gameData;
    RobotMap.ColorType gameColor = RobotMap.ColorType.UNKNOWN;


    public StageTwoSpin(WOF wof){
        this.wof = wof;
        addRequirements(wof);
    }

    protected void initalize(){
        gameData = DriverStation.getInstance().getGameSpecificMessage(); //Takes goal from frc
        if(gameData.length() > 0){ //If there is a message
            if(gameData.charAt(0) == 'R'){ //Assigns colors via message given
                gameColor = RobotMap.ColorType.Red;
            }else if(gameData.charAt(0) == 'Y'){
                gameColor = RobotMap.ColorType.Yellow;
            }else if(gameData.charAt(0) == 'B'){
                gameColor = RobotMap.ColorType.Blue;
            }else if(gameData.charAt(0) == 'G'){
                gameColor = RobotMap.ColorType.Green;
            }else{
                gameColor = RobotMap.ColorType.UNKNOWN;
            }
        }
    }

    public void execute(){    
        if(!done){
            //If the color does not match the desired color
            if(wof.getClosestColor() != RobotMap.shiftColors(gameColor)) //shiftColor returns 90 degrees off to accomodate field sensor position
                wof.go();
            else {
                done = true;
                wof.stop();
            }
        }
    }

    public boolean isFinished() {
     return done;
    }

    protected void end(){
        wof.stop();
    }
}
