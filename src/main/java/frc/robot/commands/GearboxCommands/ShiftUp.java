package frc.robot.commands.GearboxCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Gearbox;

public class ShiftUp extends CommandBase {

    private static Gearbox gb;
    
    public ShiftUp(Gearbox gearbox){
        addRequirements(gearbox);
        gb = gearbox;
    }

    public void execute() {
        gb.shift(RobotMap.GearboxPosition.Hi);
    }

    public boolean isFinished() {
        return true;
    }
}