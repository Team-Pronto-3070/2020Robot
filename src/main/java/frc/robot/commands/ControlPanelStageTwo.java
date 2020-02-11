package frc.robot.commands;



import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WOF;


public class ControlPanelStageTwo extends CommandBase {

    private WOF wof;
    Timer timer;

    String gameData;


    public ControlPanelStageTwo(WOF wof){
        this.wof = wof;
        addRequirements(wof);

        timer = new Timer(); 
        
        gameData = DriverStation.getInstance().getGameSpecificMessage();    

        if(gameData.equa)


    }

    public void execute(){    


        //spin for 1 second
        wof.go();
        if(timer.hasPeriodPassed(.5)){
            if(wof.getClosestColor().equals(gameData)){
                wof.stop();      
            }else{
                wof.go();
            }
        }
        //if the current color does not equal to wanted color keep spinning

        //stop

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
