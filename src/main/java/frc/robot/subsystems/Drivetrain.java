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
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

//TODO: Comment up

public class Drivetrain extends SubsystemBase {
    TalonFX t_frontLeft, t_backLeft, t_frontRight, t_backRight;
    ADIS16448_IMU gyro;

    public Drivetrain(){
        t_frontLeft = new TalonFX(RobotMap.FL_PORT);
        t_frontRight = new TalonFX(RobotMap.FR_PORT);
        t_backLeft = new TalonFX(RobotMap.BL_PORT);
        t_backRight = new TalonFX(RobotMap.BR_PORT);
        
        gyro = new ADIS16448_IMU();
    }

    public void periodic(){

    }

    public void tankDrive(double leftSpeed, double rightSpeed){
        System.out.println("HEY you're in tank");
        //do tank drive thing 

        t_frontRight.set(ControlMode.PercentOutput, rightSpeed/2);
        t_backRight.set(ControlMode.Follower, RobotMap.FR_PORT);
        
        t_frontLeft.set(ControlMode.PercentOutput, Robot.m_oi.j_LEFT.getRawAxis(1)/2);
        t_backLeft.set(ControlMode.Follower, RobotMap.FL_PORT);
    }

    public double getAngle(){
        return gyro.getAngle();
    }

    public void stop(){
        t_frontRight.set(ControlMode.PercentOutput, 0);
        t_backRight.set(ControlMode.Follower, RobotMap.FR_PORT);
        
        t_frontLeft.set(ControlMode.PercentOutput, 0);
        t_backLeft.set(ControlMode.Follower, RobotMap.FL_PORT);
    }

    public boolean turnToAngle(double angle){
        double optimalPath = Math.min(Math.abs(angle - getAngle()), Math.abs(360-(angle - getAngle())));
        RobotMap.PathDirection pathDir;

        if(optimalPath ==  Math.abs(angle - getAngle()))
            pathDir = RobotMap.PathDirection.Direct;
        else
            pathDir = RobotMap.PathDirection.Opposite;
        
    }

    
    public int fitsInto(double value, double divisor){
        int numberOfTimes = 0;

        for(int i = 0; i * divisor < value; i++){
            numberOfTimes = i;
        }

        return numberOfTimes;
    }

}