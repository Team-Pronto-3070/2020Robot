package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Hopper;

public class UnloadHopper extends CommandBase{

    Hopper hop;

    public UnloadHopper(Hopper hopper){

        hop = hopper;
        addRequirements(Robot.hop);

    }

}