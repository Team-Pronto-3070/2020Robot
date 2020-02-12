/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.RobotMap;

public class DrivetrainKB extends Drivetrain{
    TalonSRX t_frontLeft, t_backLeft, t_frontRight, t_backRight;

    public DrivetrainKB(){
        t_frontLeft = new TalonSRX(RobotMap.T_REY_PORT);
        t_frontRight = new TalonSRX(RobotMap.T_OBIWAN_PORT);
        t_backLeft = new TalonSRX(RobotMap.T_ASHOKA_PORT);
        t_backRight = new TalonSRX(RobotMap.T_ANAKIN_PORT);
    }

    public void periodic(){

    }

    public void tankDrive(double leftSpeed, double rightSpeed){
        rightDrive(rightSpeed);
        leftDrive(leftSpeed);
    }

    public void leftDrive(double leftSpeed){
        t_frontLeft.set(ControlMode.PercentOutput, leftSpeed * localInputScaler);
        t_backLeft.set(ControlMode.Follower, RobotMap.FL_PORT);

    }

    public void rightDrive(double rightSpeed){
        t_frontRight.set(ControlMode.PercentOutput, rightSpeed * localInputScaler);
        t_backRight.set(ControlMode.Follower, RobotMap.FR_PORT);
    }
}