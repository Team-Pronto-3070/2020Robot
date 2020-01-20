/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

public class Drivetrain extends Subsystem {
    //init talons
    //Joystick j_right, j_left;
    TalonFX t_frontLeft, t_backLeft, t_frontRight, t_backRight;
    Encoder e_left, e_right;
    DriveCommand driveCommand;
    //ADIS16448_IMU imu;
    

    public Drivetrain(){
        //imu = new ADIS16448_IMU();
        

        t_frontLeft = new TalonFX(RobotMap.FL_PORT);
        t_frontRight = new TalonFX(RobotMap.FR_PORT);
        t_backLeft = new TalonFX(RobotMap.BL_PORT);
        t_backRight = new TalonFX(RobotMap.BR_PORT);

        // e_left = new Encoder(RobotMap.ENC_L_A, RobotMap.ENC_L_B);
    }

    public void periodic(){

    }

    public void tankDrive(){
        //do tank drive thing 
        t_frontRight.set(ControlMode.PercentOutput, j_right.getRawAxis(1)/2);
        t_backRight.set(ControlMode.Follower, RobotMap.FR_PORT);
        
        t_frontLeft.set(ControlMode.PercentOutput, j_left.getRawAxis(1)/2);
        t_backLeft.set(ControlMode.Follower, RobotMap.FL_PORT);
    }

    public void autoTurn(double angle){
        double currentAngle = 0; // gyro.get 
        //move one side one way and the other side the other way
        if(angle > currentAngle){
            t_frontRight.set(ControlMode.PercentOutput, -.5);
            t_backRight.set(ControlMode.Follower, RobotMap.FR_PORT);
        
            t_frontLeft.set(ControlMode.PercentOutput, .5);
            t_backLeft.set(ControlMode.Follower, RobotMap.FL_PORT);
        }else if(angle < currentAngle){
            t_frontRight.set(ControlMode.PercentOutput, .5);
            t_backRight.set(ControlMode.Follower, RobotMap.FR_PORT);
            
            t_frontLeft.set(ControlMode.PercentOutput, -.5);
            t_backLeft.set(ControlMode.Follower, RobotMap.FL_PORT);
        }
    }
    public void initDefaultCommand(){
     setDefaultCommand(new DriveCommand());
    }

}