package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;


class c_Drive {
    Joystick j_right, j_left;
    TalonFX t_frontLeft, t_backLeft, t_frontRight, t_backRight;
    Encoder e_left, e_right;

    
    /**
     * Class constructor
     */

    public c_Drive(){
        //Assign global vars to imported instances
        j_right = new Joystick(JOYR_PORT);
        j_left = new Joystick(JOYL_PORT);

        t_frontLeft = new TalonFX(FL_PORT);
        t_frontRight = new TalonFX(FR_PORT);
        t_backLeft = new TalonFX(BL_PORT);
        t_backRight = new TalonFX(BR_PORT);

        e_left = new Encoder(ENC_L_A, ENC_L_B);
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