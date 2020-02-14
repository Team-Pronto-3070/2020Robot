package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.RobotMap.*;

public class Gearbox extends SubsystemBase {
    GearboxPosition gearboxPosition;
	Solenoid gbSol;

    public Gearbox(){
	   gbSol = new Solenoid(RobotMap.SOLENOID_PORT);
    }

	public void shift(GearboxPosition pos){
        if(pos == GearboxPosition.Hi){
            gearboxPosition = GearboxPosition.Hi;
            gbSol.set(RobotMap.GB_SOL_HI);
        }
        else {
            gearboxPosition = GearboxPosition.Lo;
            gbSol.set(RobotMap.GB_SOL_LO);
        }
    }
    
    public void autoShift(){
        if(gearboxPosition == GearboxPosition.Hi)
            shift(GearboxPosition.Lo);
        else 
            shift(GearboxPosition.Hi);
    }
    
}