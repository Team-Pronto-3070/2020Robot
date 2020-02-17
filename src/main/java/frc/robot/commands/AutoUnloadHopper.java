package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;
import edu.wpi.first.wpilibj.Timer;


public class AutoUnloadHopper extends CommandBase {

    private Hopper hopper;
    Timer timer = new Timer();
    private boolean done = false;

    public AutoUnloadHopper(Hopper hop) {
        hopper = hop;
        addRequirements(hop);
        timer.reset();
    }

    public void execute(){
        timer.start();
        
        hopper.out();
        if(timer.hasPeriodPassed(3)){
            hopper.stop();
            done = true;
        }
       
        timer.stop();
    }

    public boolean isFinished(){
        return done;
    }

    public void end(){

    } 
}