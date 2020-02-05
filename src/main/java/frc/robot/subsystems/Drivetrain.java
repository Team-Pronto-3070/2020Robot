/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

//TODO: Comment up

public class Drivetrain extends SubsystemBase {
    TalonFX t_frontLeft, t_backLeft, t_frontRight, t_backRight;
    ADIS16448_IMU gyro;
    double initAngle, initDistance;
    boolean doneAngle = false; //Stores whether or not we're there yet
    boolean doneDistance = false;
    boolean _firstCall = false;
	boolean _state = false;

    public Drivetrain(){

       // setDefaultCommand(DriveCommand(this));

        t_frontLeft = new TalonFX(RobotMap.FL_PORT);
        t_frontRight = new TalonFX(RobotMap.FR_PORT);
        t_backLeft = new TalonFX(RobotMap.BL_PORT);
        t_backRight = new TalonFX(RobotMap.BR_PORT);
        
        gyro = new ADIS16448_IMU();

        configLeftMotors(RobotMap.P, RobotMap.I, RobotMap.D);
        configLeftMotors(RobotMap.P, RobotMap.I, RobotMap.D);
    }

    public void periodic(){

    }

    public void tankDrive(double leftSpeed, double rightSpeed){
        rightDrive(rightSpeed);
        leftDrive(leftSpeed);
    }

    public void leftDrive(double leftSpeed){
        t_frontLeft.set(ControlMode.PercentOutput, leftSpeed * RobotMap.INPUT_SCALER);
        t_backLeft.set(ControlMode.Follower, RobotMap.FL_PORT);

    }

    public void rightDrive(double rightSpeed){
        t_frontRight.set(ControlMode.PercentOutput, rightSpeed * RobotMap.INPUT_SCALER);
        t_backRight.set(ControlMode.Follower, RobotMap.FR_PORT);
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
        int direction = 0;
        if(doneDistance) {
            initDistance = getFLEncoder();
            doneDistance = false;
        } else {
            
		}
		
		
    }

    public double getFLEncoder(){
        return t_frontLeft.getSelectedSensorPosition();
    }

    public void configLeftMotors(double P, double I, double D){
        /* Disable all motor controllers */
		tankDrive(0,0);

		/* Factory Default all hardware to prevent unexpected behavior */
		t_frontLeft.configFactoryDefault();
		t_backLeft.configFactoryDefault();
		
		/* Set Neutral Mode */
		t_backLeft.setNeutralMode(NeutralMode.Brake);
		t_frontLeft.setNeutralMode(NeutralMode.Brake);
		
		/** Feedback Sensor Configuration */
		
		/* Configure the left Talon's selected sensor as local QuadEncoder */
		t_backLeft.configSelectedFeedbackSensor(	FeedbackDevice.IntegratedSensor,				// Local Feedback Source
													RobotMap.PID_PRIMARY,					// PID Slot for Source [0, 1]
													RobotMap.TIMEOUT_MS);					// Configuration Timeout

		/* Configure the Remote Talon's selected sensor as a remote sensor for the right Talon */
		t_frontLeft.configRemoteFeedbackFilter(t_backLeft.getDeviceID(),					// Device ID of Source
												RemoteSensorSource.TalonSRX_SelectedSensor,	// Remote Feedback Source
												0,				                 			// Source number [0, 1]
												RobotMap.TIMEOUT_MS);						// Configuration Timeout
		
		
		/* Setup Sum signal to be used for Distance */
		t_frontLeft.configSensorTerm(SensorTerm.Diff0, FeedbackDevice.RemoteSensor0, RobotMap.TIMEOUT_MS);				// Feedback Device of Remote Talon
		t_frontLeft.configSensorTerm(SensorTerm.Diff1, FeedbackDevice.IntegratedSensor, RobotMap.TIMEOUT_MS);	// Quadrature Encoder of current Talon
		
		/* Configure Sum [Sum of both QuadEncoders] to be used for Primary PID Index */
		t_frontLeft.configSelectedFeedbackSensor(	FeedbackDevice.SensorDifference, 
													RobotMap.PID_PRIMARY,
													RobotMap.TIMEOUT_MS);
		
		/* Scale Feedback by 0.5 to half the sum of Distance */ //not working--do this within the setpoint
		t_frontLeft.configSelectedFeedbackCoefficient(	1, 						// Coefficient
														RobotMap.PID_PRIMARY,		// PID Slot of Source 
														RobotMap.TIMEOUT_MS);		// Configuration Timeout
		
		/* Configure Remote 1 [Pigeon IMU's Yaw] to be used for Auxiliary PID Index */
		t_frontLeft.configSelectedFeedbackSensor(	FeedbackDevice.RemoteSensor1,
													RobotMap.PID_TURN,
													RobotMap.TIMEOUT_MS);
		
		/* Scale the Feedback Sensor using a coefficient */
		t_frontLeft.configSelectedFeedbackCoefficient(	1,
														RobotMap.PID_TURN,
														RobotMap.TIMEOUT_MS);
		
		/* Configure output and sensor direction */
        t_backLeft.setInverted(false);
        t_backLeft.setSensorPhase(false);
        t_frontLeft.setInverted(false);
        t_frontLeft.setSensorPhase(false);
		
		/* Set status frame periods to ensure we don't have stale data */
		t_frontLeft.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 20, RobotMap.TIMEOUT_MS);
		t_frontLeft.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 20, RobotMap.TIMEOUT_MS);
		t_frontLeft.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 20, RobotMap.TIMEOUT_MS);
		t_frontLeft.setStatusFramePeriod(StatusFrame.Status_10_Targets, 20, RobotMap.TIMEOUT_MS);
		t_backLeft.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, RobotMap.TIMEOUT_MS);

		/* Configure neutral deadband */
		t_frontLeft.configNeutralDeadband(RobotMap.NEUTRAL_DEADBAND, RobotMap.TIMEOUT_MS);
		t_backLeft.configNeutralDeadband(RobotMap.NEUTRAL_DEADBAND, RobotMap.TIMEOUT_MS);
		
		/* Motion Magic Configurations */
		t_frontLeft.configMotionAcceleration(2000, RobotMap.TIMEOUT_MS);
		t_frontLeft.configMotionCruiseVelocity(2000, RobotMap.TIMEOUT_MS);

		/**
		 * Max out the peak output (for all modes).  
		 * However you can limit the output of a given PID object with configClosedLoopPeakOutput().
		 */
		t_backLeft.configPeakOutputForward(+1.0, RobotMap.TIMEOUT_MS);
		t_backLeft.configPeakOutputReverse(-1.0, RobotMap.TIMEOUT_MS);
		t_frontLeft.configPeakOutputForward(+1.0, RobotMap.TIMEOUT_MS);
		t_frontLeft.configPeakOutputReverse(-1.0, RobotMap.TIMEOUT_MS);

		/* FPID Gains for distance servo */
		t_frontLeft.config_kP(RobotMap.PID_DISTANCE, RobotMap.P, RobotMap.TIMEOUT_MS);
		t_frontLeft.config_kI(RobotMap.PID_DISTANCE, RobotMap.I, RobotMap.TIMEOUT_MS);
		t_frontLeft.config_kD(RobotMap.PID_DISTANCE, RobotMap.D, RobotMap.TIMEOUT_MS);
		t_frontLeft.config_kF(RobotMap.PID_DISTANCE, RobotMap.F, RobotMap.TIMEOUT_MS);
		t_frontLeft.config_IntegralZone(RobotMap.PID_DISTANCE, RobotMap.PID_DISTANCE_IZONE, RobotMap.TIMEOUT_MS);
		t_frontLeft.configClosedLoopPeakOutput(RobotMap.PID_DISTANCE, RobotMap.PID_DISTANCE_PEAK_OUTPUT , RobotMap.TIMEOUT_MS);

		/* FPID Gains for turn servo */
		t_frontLeft.config_kP(RobotMap.PID_TURNING, RobotMap.P, RobotMap.TIMEOUT_MS);
		t_frontLeft.config_kI(RobotMap.PID_TURNING, RobotMap.I, RobotMap.TIMEOUT_MS);
		t_frontLeft.config_kD(RobotMap.PID_TURNING, RobotMap.D, RobotMap.TIMEOUT_MS);
		t_frontLeft.config_kF(RobotMap.PID_TURNING, RobotMap.F, RobotMap.TIMEOUT_MS);
		t_frontLeft.config_IntegralZone(RobotMap.PID_TURNING, RobotMap.PID_TURNING_IZONE, RobotMap.TIMEOUT_MS);
		t_frontLeft.configClosedLoopPeakOutput(RobotMap.PID_TURNING, RobotMap.PID_TURNING_PEAK_OUTPUT, RobotMap.TIMEOUT_MS);
		
		/**
		 * 1ms per loop.  PID loop can be slowed down if need be.
		 * For example,
		 * - if sensor updates are too slow
		 * - sensor deltas are very small per update, so derivative error never gets large enough to be useful.
		 * - sensor movement is very slow causing the derivative error to be near zero.
		 */
		int closedLoopTimeMs = 1;
		t_frontLeft.configClosedLoopPeriod(0, closedLoopTimeMs, RobotMap.TIMEOUT_MS);
		t_frontLeft.configClosedLoopPeriod(1, closedLoopTimeMs, RobotMap.TIMEOUT_MS);

		/**
		 * configAuxPIDPolarity(boolean invert, int timeoutMs)
		 * false means talon's local output is PID0 + PID1, and other side Talon is PID0 - PID1
		 * true means talon's local output is PID0 - PID1, and other side Talon is PID0 + PID1
		 */
		t_frontLeft.configAuxPIDPolarity(false, RobotMap.TIMEOUT_MS);

		/* Initialize */
		_firstCall = true;
		_state = false;
		t_frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_10_Targets, 10);
		zeroSensors();
    }

    public void configRightMotors(double P, double I, double D){
        /* Disable all motor controllers */
		tankDrive(0,0);

		/* Factory Default all hardware to prevent unexpected behavior */
		t_frontRight.configFactoryDefault();
		t_backRight.configFactoryDefault();
		
		/* Set Neutral Mode */
		t_backRight.setNeutralMode(NeutralMode.Brake);
		t_frontRight.setNeutralMode(NeutralMode.Brake);
		
		/** Feedback Sensor Configuration */
		
		/* Configure the left Talon's selected sensor as local QuadEncoder */
		t_backRight.configSelectedFeedbackSensor(	FeedbackDevice.IntegratedSensor,				// Local Feedback Source
													RobotMap.PID_PRIMARY,					// PID Slot for Source [0, 1]
													RobotMap.TIMEOUT_MS);					// Configuration Timeout

		/* Configure the Remote Talon's selected sensor as a remote sensor for the right Talon */
		t_frontRight.configRemoteFeedbackFilter(t_backRight.getDeviceID(),					// Device ID of Source
												RemoteSensorSource.TalonSRX_SelectedSensor,	// Remote Feedback Source
												0,				                 			// Source number [0, 1]
												RobotMap.TIMEOUT_MS);						// Configuration Timeout
		
		
		/* Setup Sum signal to be used for Distance */
		t_frontRight.configSensorTerm(SensorTerm.Diff0, FeedbackDevice.RemoteSensor0, RobotMap.TIMEOUT_MS);				// Feedback Device of Remote Talon
		t_frontRight.configSensorTerm(SensorTerm.Diff1, FeedbackDevice.IntegratedSensor, RobotMap.TIMEOUT_MS);	// Quadrature Encoder of current Talon
		
		/* Configure Sum [Sum of both QuadEncoders] to be used for Primary PID Index */
		t_frontRight.configSelectedFeedbackSensor(	FeedbackDevice.SensorDifference, 
													RobotMap.PID_PRIMARY,
													RobotMap.TIMEOUT_MS);
		
		/* Scale Feedback by 0.5 to half the sum of Distance */ //not working--do this within the setpoint
		t_frontRight.configSelectedFeedbackCoefficient(	1, 						// Coefficient
														RobotMap.PID_PRIMARY,		// PID Slot of Source 
														RobotMap.TIMEOUT_MS);		// Configuration Timeout
		
		/* Configure Remote 1 [Pigeon IMU's Yaw] to be used for Auxiliary PID Index */
		t_frontRight.configSelectedFeedbackSensor(	FeedbackDevice.RemoteSensor1,
													RobotMap.PID_TURN,
													RobotMap.TIMEOUT_MS);
		
		/* Scale the Feedback Sensor using a coefficient */
		t_frontRight.configSelectedFeedbackCoefficient(	1,
														RobotMap.PID_TURN,
														RobotMap.TIMEOUT_MS);
		
		/* Configure output and sensor direction */
        t_backRight.setInverted(false);
        t_backRight.setSensorPhase(false);
        t_frontRight.setInverted(false);
        t_frontRight.setSensorPhase(false);
		
		/* Set status frame periods to ensure we don't have stale data */
		t_frontRight.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 20, RobotMap.TIMEOUT_MS);
		t_frontRight.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 20, RobotMap.TIMEOUT_MS);
		t_frontRight.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 20, RobotMap.TIMEOUT_MS);
		t_frontRight.setStatusFramePeriod(StatusFrame.Status_10_Targets, 20, RobotMap.TIMEOUT_MS);
		t_backRight.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, RobotMap.TIMEOUT_MS);

		/* Configure neutral deadband */
		t_frontRight.configNeutralDeadband(RobotMap.NEUTRAL_DEADBAND, RobotMap.TIMEOUT_MS);
		t_backRight.configNeutralDeadband(RobotMap.NEUTRAL_DEADBAND, RobotMap.TIMEOUT_MS);
		
		/* Motion Magic Configurations */
		t_frontRight.configMotionAcceleration(2000, RobotMap.TIMEOUT_MS);
		t_frontRight.configMotionCruiseVelocity(2000, RobotMap.TIMEOUT_MS);

		/**
		 * Max out the peak output (for all modes).  
		 * However you can limit the output of a given PID object with configClosedLoopPeakOutput().
		 */
		t_backRight.configPeakOutputForward(+1.0, RobotMap.TIMEOUT_MS);
		t_backRight.configPeakOutputReverse(-1.0, RobotMap.TIMEOUT_MS);
		t_frontRight.configPeakOutputForward(+1.0, RobotMap.TIMEOUT_MS);
		t_frontRight.configPeakOutputReverse(-1.0, RobotMap.TIMEOUT_MS);

		/* FPID Gains for distance servo */
		t_frontRight.config_kP(RobotMap.PID_DISTANCE, RobotMap.P, RobotMap.TIMEOUT_MS);
		t_frontRight.config_kI(RobotMap.PID_DISTANCE, RobotMap.I, RobotMap.TIMEOUT_MS);
		t_frontRight.config_kD(RobotMap.PID_DISTANCE, RobotMap.D, RobotMap.TIMEOUT_MS);
		t_frontRight.config_kF(RobotMap.PID_DISTANCE, RobotMap.F, RobotMap.TIMEOUT_MS);
		t_frontRight.config_IntegralZone(RobotMap.PID_DISTANCE, RobotMap.PID_DISTANCE_IZONE, RobotMap.TIMEOUT_MS);
		t_frontRight.configClosedLoopPeakOutput(RobotMap.PID_DISTANCE, RobotMap.PID_DISTANCE_PEAK_OUTPUT , RobotMap.TIMEOUT_MS);

		/* FPID Gains for turn servo */
		t_frontRight.config_kP(RobotMap.PID_TURNING, RobotMap.P, RobotMap.TIMEOUT_MS);
		t_frontRight.config_kI(RobotMap.PID_TURNING, RobotMap.I, RobotMap.TIMEOUT_MS);
		t_frontRight.config_kD(RobotMap.PID_TURNING, RobotMap.D, RobotMap.TIMEOUT_MS);
		t_frontRight.config_kF(RobotMap.PID_TURNING, RobotMap.F, RobotMap.TIMEOUT_MS);
		t_frontRight.config_IntegralZone(RobotMap.PID_TURNING, RobotMap.PID_TURNING_IZONE, RobotMap.TIMEOUT_MS);
		t_frontRight.configClosedLoopPeakOutput(RobotMap.PID_TURNING, RobotMap.PID_TURNING_PEAK_OUTPUT, RobotMap.TIMEOUT_MS);
		
		/**
		 * 1ms per loop.  PID loop can be slowed down if need be.
		 * For example,
		 * - if sensor updates are too slow
		 * - sensor deltas are very small per update, so derivative error never gets large enough to be useful.
		 * - sensor movement is very slow causing the derivative error to be near zero.
		 */
		int closedLoopTimeMs = 1;
		t_frontRight.configClosedLoopPeriod(0, closedLoopTimeMs, RobotMap.TIMEOUT_MS);
		t_frontRight.configClosedLoopPeriod(1, closedLoopTimeMs, RobotMap.TIMEOUT_MS);

		/**
		 * configAuxPIDPolarity(boolean invert, int timeoutMs)
		 * false means talon's local output is PID0 + PID1, and other side Talon is PID0 - PID1
		 * true means talon's local output is PID0 - PID1, and other side Talon is PID0 + PID1
		 */
		t_frontRight.configAuxPIDPolarity(false, RobotMap.TIMEOUT_MS);

		/* Initialize */
		_firstCall = true;
		_state = false;
		t_frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_10_Targets, 10);
		zeroSensors();
    }

    /** Zero all sensors, both Talons and Pigeon */
	void zeroSensors() {
        t_frontLeft.getSensorCollection().setIntegratedSensorPosition(0, RobotMap.TIMEOUT_MS);
        t_backLeft.getSensorCollection().setIntegratedSensorPosition(0, RobotMap.TIMEOUT_MS);
        t_frontRight.getSensorCollection().setIntegratedSensorPosition(0, RobotMap.TIMEOUT_MS);
        t_backRight.getSensorCollection().setIntegratedSensorPosition(0, RobotMap.TIMEOUT_MS);
		gyro.reset();
		System.out.println("[Integrated Encoders + Pigeon] All sensors are zeroed.\n");
	}
	
	/** Zero QuadEncoders, used to reset position when initializing Motion Magic */
	void zeroDistance(){
        t_frontLeft.getSensorCollection().setIntegratedSensorPosition(0, RobotMap.TIMEOUT_MS);
        t_backLeft.getSensorCollection().setIntegratedSensorPosition(0, RobotMap.TIMEOUT_MS);
        t_frontRight.getSensorCollection().setIntegratedSensorPosition(0, RobotMap.TIMEOUT_MS);
        t_backRight.getSensorCollection().setIntegratedSensorPosition(0, RobotMap.TIMEOUT_MS);
		System.out.println("[Integrated Encoders] All encoders are zeroed.\n");
	}
}