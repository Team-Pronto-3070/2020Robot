package frc.robot.commands.ClimberCommmands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Winch;

public class WinchOut extends CommandBase {

    private Winch winch;

    public WinchOut(Winch winch){
        addRequirements(winch);
        this.winch = winch;
    }

    public void execute(){
        winch.out();
    }

    public boolean aisFinished(){
        return false;
    }
}