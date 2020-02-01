package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj.Timer;
public class ClimberUp extends CommandBase {
    Timer timer = new Timer();
    private Climber climber;

    public ClimberUp (Climber climb) {
        climber = climb;
        addRequirements(climb);
    }
    public void execute(){ 
        timer.start();
          //winch and climber up, climber down and then winch down
        climber.goUp();
        if(timer.hasPeriodPassed(1))
        {
        climber.stop();
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