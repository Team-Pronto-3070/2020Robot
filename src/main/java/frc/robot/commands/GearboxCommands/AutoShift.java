package frc.robot.commands.GearboxCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gearbox;

public class AutoShift extends CommandBase {

    private static Gearbox gb;
    
    public AutoShift(Gearbox gearbox){
        addRequirements(gearbox);
        gb = gearbox;
    }

    public void execute() {
        gb.autoShift();
    }

    public boolean isFinished() {
        return true;
    }
}