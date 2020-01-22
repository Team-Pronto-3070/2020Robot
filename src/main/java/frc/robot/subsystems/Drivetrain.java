/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase {
    TalonFX t_frontLeft, t_backLeft, t_frontRight, t_backRight;
    

    public Drivetrain(){
        t_frontLeft = new TalonFX(RobotMap.FL_PORT);
        t_frontRight = new TalonFX(RobotMap.FR_PORT);
        t_backLeft = new TalonFX(RobotMap.BL_PORT);
        t_backRight = new TalonFX(RobotMap.BR_PORT);
    }

    public void periodic(){

    }

    public void tankDrive(double leftSpeed, double rightSpeed){
        System.out.println("HEY you're in tank");
        //do tank drive thing 

        t_frontRight.set(ControlMode.PercentOutput, rightSpeed/2);
        t_backRight.set(ControlMode.Follower, RobotMap.T_OBIWAN_PORT);
        
        t_frontLeft.set(ControlMode.PercentOutput, Robot.m_oi.j_LEFT.getRawAxis(1)/2);
        t_backLeft.set(ControlMode.Follower, RobotMap.T_REY_PORT);
    }

}