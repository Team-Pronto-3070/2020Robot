package frc.robot.commands.HopperCommands;

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
        timer.start();

    }

    public void execute(){
    
    System.out.println(timer.get());
    if(timer.hasPeriodPassed(3.9));
            hopper.out();
    }

    public boolean isFinished(){
        timer.start();
        if(timer.hasPeriodPassed(1.5)){
            hopper.stop();
            return true;
        } else {
            return false;
        }
    }

    public void end(){
    } 
}