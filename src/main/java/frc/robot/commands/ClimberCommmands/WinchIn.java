package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Winch;

public class WinchIn extends CommandBase {

    private Winch climb;

    public WinchIn(Winch climb){
        addRequirements(climb);
        this.climb = climb;
    }

    public void execute(){
        climb.in();
    }

    public boolean aisFinished(){
        return false;
    }
}