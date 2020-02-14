package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Gearbox;

public class ShiftDown extends CommandBase {

    private static Gearbox gb;
    
    public ShiftDown(Gearbox gearbox){
        addRequirements(gearbox);
        gb = gearbox;
    }

    public void execute() {
        gb.shift(RobotMap.GearboxPosition.Lo);
    }

    public boolean isFinished() {
        return true;
    }
}