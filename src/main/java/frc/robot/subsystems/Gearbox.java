package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.RobotMap.*;

public class Gearbox extends SubsystemBase {
    GearboxPosition gearboxPosition;
	DoubleSolenoid gbSol;

    public Gearbox(){
	   gbSol = new DoubleSolenoid(RobotMap.GB_SOL_PORT_ONE, RobotMap.GB_SOL_PORT_TWO);
    }

	public void shift(GearboxPosition pos){
        if(pos == GearboxPosition.Hi){
            gearboxPosition = GearboxPosition.Hi;
            gbSol.set(RobotMap.GB_SOL_ON);
            System.out.println("Hi");
        }
        else {
            gearboxPosition = GearboxPosition.Lo;
            gbSol.set(RobotMap.GB_SOL_OFF);
            System.out.println("Lo");
        }
    }
    
    public void autoShift(){
        if(gearboxPosition == GearboxPosition.Hi)
            shift(GearboxPosition.Lo);
        else 
            shift(GearboxPosition.Hi);
    }
    
    public RobotMap.GearboxPosition getGearboxPosition(){
        return gearboxPosition;        
    }
}