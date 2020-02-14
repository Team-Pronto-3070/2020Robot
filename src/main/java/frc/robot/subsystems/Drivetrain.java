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
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase {
    public TalonFX t_frontLeft, t_backLeft, t_frontRight, t_backRight;
    ADIS16448_IMU gyro;
    double initAngle, initDistance;
    boolean doneAngle = false; //Stores whether or not we're there yet
    boolean doneDistance = false;
    boolean _firstCall = false;
	boolean _state = false;
	double localInputScaler = 1;

    public Drivetrain(){
       // setDefaultCommand(DriveCommand(this));

        t_frontLeft = new TalonFX(RobotMap.FL_PORT);
        t_frontRight = new TalonFX(RobotMap.FR_PORT);
        t_backLeft = new TalonFX(RobotMap.BL_PORT);
        t_backRight = new TalonFX(RobotMap.BR_PORT);
        
       // gyro = new ADIS16448_IMU();
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

    public double getAngle(){
        return 0; //gyro.getAngle();
    }

    public void stop(){
        t_frontRight.set(ControlMode.PercentOutput, 0);
        t_backRight.set(ControlMode.Follower, RobotMap.FR_PORT);
        
        t_frontLeft.set(ControlMode.PercentOutput, 0);
        t_backLeft.set(ControlMode.Follower, RobotMap.FL_PORT);
    }

    public boolean turnToAngle(double angle){
        if(Math.abs(angle - getAngle()) <= RobotMap.ROTATION_TOLERANCE) { //If angle is within tolerance, we're good
            return true; 
        } else {
            double optimalPath = Math.min(Math.abs(angle - getAngle()), Math.abs(360-(angle - getAngle()))); 
            /**Returns shortest path, with first arg being the direct path, and the second being the opposite path. 
            *  This is to account for situations like 30*->270*, where simply increasing or decreasing your angle
            *  until it hits the desired angle is not the shortest possible path. 
            */
            RobotMap.PathDirection pathDir; //Var for storing the path direction that will be chosen. 

            if(optimalPath ==  Math.abs(angle - getAngle())) //If the optimal path is the logical way(CCW to gain, CW to lose angle)
                pathDir = RobotMap.PathDirection.Direct;    //Then set it to direct
            else //If it isn't (CW to gain, CCW to lost) then set it to opposite
                pathDir = RobotMap.PathDirection.Reverse;

            if(doneAngle) {
                initAngle = getAngle(); //Sets initial angle, since it can't check getAngle() while moving
				doneAngle = false;
            }

            if(!areWeThereYetAngle(pathDir, angle)){ //If we are not there yet
                switch (pathDir) { //Case machine for direction. Opposite outputs from each input
                    case Direct:
                        if(angle < initAngle) //If we need to lose angle
                            tankDrive(RobotMap.AUTO_SPEED, -RobotMap.AUTO_SPEED); //Rotate CW
                        else //If we need to gain it
                            tankDrive(-RobotMap.AUTO_SPEED, RobotMap.AUTO_SPEED); //Rotate CCW
                    break;
                    case Reverse: //Opposite outputs from direct
                        if(angle < initAngle) //If we need to lost angle
                            tankDrive(-RobotMap.AUTO_SPEED, RobotMap.AUTO_SPEED); //Rotate CCW
                        else //If we need to gain it, 
                            tankDrive(RobotMap.AUTO_SPEED, -RobotMap.AUTO_SPEED); //Rotate CW
                    break;
                }
            } else { //Once complete, stop turning. 
                stop();
            }
            return areWeThereYetAngle(pathDir, angle);
        }
    }
    public boolean areWeThereYetAngle(RobotMap.PathDirection dir, double angleWanted){
        switch (dir) {
            case Direct: //If we are going the direct way
                if(angleWanted < initAngle) //If we are turning CW, we need to cross over to the lesser side of theta to complete
                    doneAngle = getAngle() <= angleWanted; //Return whether or not we have crossed over the barrier. 
                else //If we are turning CW, we need to cross over to the greater side of theta to complete
                    doneAngle = getAngle() >= angleWanted; //Return whether or not we have crossed over the barrier. 
            break;

            case Reverse: //Same as direct, just in the opposite direction
                if(angleWanted < initAngle)
                    doneAngle = true;
                else
                    doneAngle = false;
            break;
        }
        return doneAngle; //Return whether or not the robot has crossed the threshold.
    }    

    public boolean driveDistance(double distance) {
        if(doneDistance) {
			resetEncoderValues();
			doneDistance = false;
        } else {
            
        }
    }
    public double getFLEncoderPosition(){
		return t_frontLeft.getSelectedSensorPosition();
	}

	public double getFREncoderPosition(){
		return t_frontRight.getSelectedSensorPosition();
	}

	public double getBLEncoderPosition(){
		return t_backLeft.getSelectedSensorPosition();
	}

	public double getBREncoderPosition(){
		return t_backRight.getSelectedSensorPosition();
	}

	public double getLeftSpeed(){
		return (t_frontLeft.getSelectedSensorPosition() + t_backLeft.getSelectedSensorPosition()) / 2;
	}

	public double getRightSpeed(){
		return (t_frontRight.getSelectedSensorPosition() + t_backRight.getSelectedSensorPosition()) / 2;
	}

	public void resetEncoderValues(){
		t_frontLeft.setSelectedSensorPosition(0);
		t_frontRight.setSelectedSensorPosition(0);
		t_backLeft.setSelectedSensorPosition(0);
		t_backLeft.setSelectedSensorPosition(0);
	}
}







