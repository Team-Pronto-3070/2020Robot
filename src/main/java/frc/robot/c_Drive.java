package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.Joystick;


class c_Drive {
    Joystick j_joyR, j_joyL;
    TalonFX t_frontLeft, t_backLeft, t_frontRight, t_backRight;

    /**
     * Class constructor
     * @param j_joyR Right joystick object
     * @param j_joyL Left joystick object
     * @param t_frontLeft Front left motor object
     * @param t_backLeft Back left motor object
     * @param t_frontRight Front right motor object
     * @param t_backRight Back right motor object
     */

    public c_Drive(Joystick j_joyR, Joystick j_joyL, TalonFX t_frontLeft, TalonFX t_backLeft, TalonFX t_frontRight, TalonFX t_backRight){
        //Assign global vars to imported instances
        this.j_joyR = j_joyR;
        this.j_joyL = j_joyL;
        this.t_frontLeft = t_frontLeft;
        this.t_backLeft = t_backLeft;
        this.t_frontRight = t_frontRight;
        this.t_backRight = t_backRight;
    }

    /**
    * Sets left to raw percentage
    * @param speed: [-1,1] decimal speed value
    */
    public void setLeft(double speed){
        t_frontLeft.set(ControlMode.PercentOutput, speed);
        t_backLeft.set(ControlMode.Follower, i_Pronstants.FL_PORT);
    }

    /**
    * Sets right to raw percentage
    * @param speed: [-1,1] decimal speed value
    */
    public void setRight(double speed){
        t_frontRight.set(ControlMode.PercentOutput, speed);
        t_backRight.set(ControlMode.Follower, i_Pronstants.FR_PORT);
    }

    /**
     * Sets both sides to raw percentage
     * @param speed: [-1,1] decimal speed value
     */
    public void setBothSides(double bothSpeed){
        t_frontRight.set(ControlMode.PercentOutput, bothSpeed);
        t_backRight.set(ControlMode.Follower, i_Pronstants.FR_PORT);
        
        t_frontLeft.set(ControlMode.PercentOutput, bothSpeed);
        t_backLeft.set(ControlMode.Follower, i_Pronstants.FL_PORT);
    }

    /**
     * Sets both sides to independent speed values of domain [-1,1]
     * @param leftSpeed Left side percentage
     * @param rightSpeed Right side percentage
     */

    public void setBothSides(double leftSpeed, double rightSpeed){
        t_frontRight.set(ControlMode.PercentOutput, leftSpeed);
        t_backRight.set(ControlMode.Follower, i_Pronstants.FR_PORT);
        
        t_frontLeft.set(ControlMode.PercentOutput, rightSpeed);
        t_backLeft.set(ControlMode.Follower, i_Pronstants.FL_PORT);
    }

}