package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.WOF;
import frc.robot.commands.ClimberUp;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeBall;



public class TeleGroup extends ParallelCommandGroup {

    public TeleGroup(Drivetrain dt, Hopper hop, Climber climb, Intake in, WOF wof){
    
            addCommands( new DriveCommand(), new ClimberUp(climb), new IntakeBall(in),  );
        

    }

}




