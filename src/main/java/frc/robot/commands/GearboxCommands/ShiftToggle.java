package frc.robot.commands.GearboxCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gearbox;

public class ShiftToggle extends CommandBase {

    private static Gearbox gb;
    
    public ShiftToggle(Gearbox gearbox){
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