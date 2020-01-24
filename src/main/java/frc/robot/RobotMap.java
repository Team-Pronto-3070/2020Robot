package frc.robot;

import edu.wpi.first.wpilibj.I2C;

public class RobotMap {
    public static final int FL_PORT = 1;
    public static final int FR_PORT = 2;
    public static final int BL_PORT = 3;
    public static final int BR_PORT = 4;

    public static final int JOYL_PORT = 0;
    public static final int JOYR_PORT = 1;

    public static final I2C.Port i2cPort = I2C.Port.kOnboard;

    public static final int T_REY_PORT = 1;
    public static final int T_OBIWAN_PORT = 2;
    public static final int T_ASHOKA_PORT = 3;
    public static final int T_ANAKIN_PORT = 4;
    public static final int T_REVAN_PORT = 5;
    public static final int T_BASTILA_PORT = 6;

    //Set each function-named talon port to each named definition
    public static final int T_WOF_PORT = T_REY_PORT;
    public static final int T_WINCH_PORT = T_OBIWAN_PORT;
    public static final int T_HOPPER_PORT = T_ASHOKA_PORT;
    public static final int T_TELE_PORT = T_ANAKIN_PORT;
    public static final int T_BELT1_PORT = T_REVAN_PORT;
    public static final int T_BELT2_PORT = T_BASTILA_PORT;

	public static final boolean KITBOT = false;

    public enum JOYSIDE {
        Left, Right
    };

    public static final double TELE_LIFT_SPEED = 1;
    public static final double WINCH_LIFT_SPEED = 1;

    public enum ColorType {
        Blue, Red, Yellow, Green, UNKNOWN
    };

    public static final float[] RED_HSB = {255, 0, 0};
    public static final float[] GREEN_HSB = {0, 255, 0};
    public static final float[] BLUE_HSB = {0, 255, 255};
    public static final float[] YELLOW_HSB = {255, 255, 0};

}