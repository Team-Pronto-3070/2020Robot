package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ClimberUp extends CommandBase {
    Timer timer = new Timer();
    private Climber climber;

    DigitalOutput upperLimit, lowerLimit;

    
    public ClimberUp (Climber climb) {
        climber = climb;
        addRequirements(climb);

        upperLimit = new DigitalOutput(0);
        lowerLimit = new DigitalOutput(1);
    }
    public void execute(){ 
        timer.start();
          //winch and climber up, climber down and then winch down

          //TODO: need to make sure limit switches will stop the motors before testing
        if(!upperLimit.get()){ 
            climber.goUp();
        }
        if(timer.hasPeriodPassed(1))
        {
        climber.stop();
        if(!lowerLimit.get())    
            climber.teleArmDown();
        }
        if(timer.hasPeriodPassed(1))
        {
        climber.winchDown();
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
        // Robot.drive.stop();
}
}




























//Keep going






























































































































































































































































































































































//For the memes, https://www.youtube.com/watch?v=dQw4w9WgXcQ