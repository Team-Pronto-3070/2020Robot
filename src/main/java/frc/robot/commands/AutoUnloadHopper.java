package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class AutoUnloadHopper extends CommandBase {

    private Hopper hopper;

    public AutoUnloadHopper(Hopper hop) {
        hopper = hop;
        addRequirements(hop);
    }
}