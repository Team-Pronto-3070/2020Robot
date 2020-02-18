package frc.robot.commands.WOFWheelCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.WOF;


public class StageTwoSpin extends CommandBase {

    private WOF wof;
    Timer timer = new Timer();
    private boolean done = false;
    String gameData;
    RobotMap.ColorType gameColor = RobotMap.ColorType.UNKNOWN;


    public StageTwoSpin(WOF wof){
        this.wof = wof;
        addRequirements(wof);
    }

    protected void initalize(){
        gameData = DriverStation.getInstance().getGameSpecificMessage();    
        if(gameData.length() > 0){
            if(gameData.charAt(0) == 'R'){
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
        //spin for 1 second
        if(!done){
            wof.go();
            timer.start();
            if(timer.hasPeriodPassed(.5)){
                //if the current color does not equal to wanted color keep spinning
                timer.reset();
                if(wof.getClosestColor() == gameColor){
                    done = true;     
                }
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
