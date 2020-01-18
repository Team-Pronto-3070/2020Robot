/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.i_Pronstants;

public class Drivetrain extends SubsystemBase implements i_Pronstants{
    //init talons
    Joystick j_right, j_left;
    TalonFX t_frontLeft, t_backLeft, t_frontRight, t_backRight;
    Encoder e_left, e_right;

    public Drivetrain(){
        j_right = new Joystick(JOYR_PORT);
        j_left = new Joystick(JOYL_PORT);

        t_frontLeft = new TalonFX(FL_PORT);
        t_frontRight = new TalonFX(FR_PORT);
        t_backLeft = new TalonFX(BL_PORT);
        t_backRight = new TalonFX(BR_PORT);

        e_left = new Encoder(ENC_L_A, ENC_L_B);
    }

    public void periodic(){

    }

    public void tankDrive(double bothSpeed){
        //do tank dtrive thing 
        t_frontRight.set(ControlMode.PercentOutput, bothSpeed);
        t_backRight.set(ControlMode.Follower, i_Pronstants.FR_PORT);
        
        t_frontLeft.set(ControlMode.PercentOutput, bothSpeed);
        t_backLeft.set(ControlMode.Follower, i_Pronstants.FL_PORT);
    }

    public void initDefaultCommand(){
        setDefaultCommand(driveCommand);
    }

}