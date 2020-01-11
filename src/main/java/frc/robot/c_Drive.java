package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.Joystick;


class c_Drive {

    Joystick j_joyR, j_joyL;
    TalonFX t_frontLeft, t_backLeft, t_frontRight, t_backRight;

    /**
     * Class constructor
     * @param j_joyR Right joystick
     * @param j_joyL Left joystick
     * @param t_frontLeft Front left motor
     * @param t_backLeft Back left motor
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
         * @param speed: [-1,1] decimal speed value
         */
    public void setLeft(double speed){
        
        t_frontLeft.set(ControlMode.PercentOutput, speed);
    }

}