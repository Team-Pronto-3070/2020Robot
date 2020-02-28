package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberArm;
import frc.robot.subsystems.Winch;

public class CWSync extends CommandBase{

    private ClimberArm climb;
    private Winch winch;

    public CWSync(ClimberArm climb, Winch winch){
        addRequirements(climb, winch);
        this.climb = climb;
        this.winch = winch; 
    }
    //150 milliseconds for teleArm
    //400 milli for winch

    public void execute(){
        //two seections that swap every 150 and 400 milliseconds
        boolean sync = true;
        int counter = 2;
        if(sync && counter > 0){
            //create a timer
            Timer timer = new Timer();
            timer.start();
            //have it go for 150 milli
            if(!(timer.hasPeriodPassed(.150))){
                climb.goUp();
            }
            winch.stop();
            sync = !sync;
            counter--;
            //swap sync and subtract from counter 
        }else if(!sync && counter > 0){
            Timer timer = new Timer();
            timer.start();
            //have it go for 150 milli
            if(!(timer.hasPeriodPassed(.400))){
                winch.out();
            }
            climb.stop();
            sync = !sync;
            counter--;
            //swap sync and subtract from counter 
        }
    }
}