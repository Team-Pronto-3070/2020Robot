package frc.robot.commands;



import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.WOF;


public class ControlPanelStageTwo extends CommandBase {

    private WOF wof;
    Timer timer;

    String gameData;
    RobotMap.ColorType gameColor = RobotMap.ColorType.UNKNOWN;


    public ControlPanelStageTwo(WOF wof){
        this.wof = wof;
        addRequirements(wof);

        timer = new Timer(); 
        
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
        wof.go();
        if(timer.hasPeriodPassed(.5)){
             //if the current color does not equal to wanted color keep spinning
            if(wof.getClosestColor() == gameColor){
                wof.stop();      
            }
        }
       

        

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
