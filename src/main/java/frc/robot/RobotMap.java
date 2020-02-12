package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorMatch;

//TODO: Comment up

public class RobotMap {
    public static final int FL_PORT = 1;
    public static final int FR_PORT = 3;
    public static final int BL_PORT = 2;
    public static final int BR_PORT = 4;

    public static final int JOYL_PORT = 0;
    public static final int JOYR_PORT = 1;

    public static final I2C.Port i2cPort = I2C.Port.kOnboard;

    public static final int T_REY_PORT = 5;
    public static final int T_OBIWAN_PORT = 6;
    public static final int T_ASHOKA_PORT = 7;
    public static final int T_ANAKIN_PORT = 8;
    public static final int T_REVAN_PORT = 9;
    public static final int T_BASTILA_PORT = 10;

    //Set each function-named talon port to each named definition
    public static final int T_WOF_PORT = T_REY_PORT;
    public static final int T_WINCH_PORT = T_ANAKIN_PORT;
    public static final int T_HOPPER_PORT = T_ASHOKA_PORT;
    public static final int T_TELE_PORT = T_OBIWAN_PORT;
    public static final int T_BELT1_PORT = T_REVAN_PORT;
    public static final int T_BELT2_PORT = T_BASTILA_PORT;

	public static final boolean KITBOT = false;

    public enum JOYSIDE {
        Left, Right
    };

    public static final double TELE_LIFT_SPEED = .5;
    public static final double WINCH_LIFT_SPEED = .5;
    public static final double HOPPER_LIFT_SPEED = 1;

    public static final double INPUT_SCALER = .5;

    public enum ColorType {
        Blue, Red, Yellow, Green, UNKNOWN
    };

    public static final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    public static final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    public static final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    public static final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
   
    public static final double LEFT_START_TURN_ANGLE = 57;
    public static final double RIGHT_START_TURN_ANGLE = 59.7;
    public static final double MIDDLE_START_TURN_ANGLE = 27.4;

    //unit is inches
    public static final double RIGHT_DISTANCE = 231.6;
    public static final double LEFT_DISTANCE = 129.1;
    public static final double MIDDLE_DISTANCE =127;
    public static final double PREFFERED_DISTANCE = 108;

    public static final double WHEEL_ROTATION_RIGHT = 9.23;
    public static final double WHEEL_ROTATION_LEFT = 5.14;
    public static final double WHEEL_ROTATION_MIDDLE = 5.06;
    public static final double WHEEL_ROTATION_PREFFERED = 4.3;

    public enum PathDirection {
        Direct, Reverse
    };

    public static final double AUTO_SPEED = .5;
    public static final double ROTATION_TOLERANCE = 3;

    public enum StartingPosition {
        Left, Right, Middle, Preffered
    };

    public enum GearboxPosition {
        Hi, Lo
    };

    public static final double DEADZONE = .2;

    private static GearboxPosition GB_STATUS = GearboxPosition.Lo;
    public static final double LO_GEARBOX_RATIO = 1;
    public static final double HI_GEARBOX_RATIO = 1;

    public static final int WHEEL_DIAMETER_INCHES = 8; //Wheel diameter in inches
    public static final double WHEEL_CIRCUMFRENCE_INCHES = 2 * WHEEL_DIAMETER_INCHES * Math.PI; //Wheel circumfrence in inches

    public static final int TIMEOUT_MS = 500;
    public static final int PID_PRIMARY = 1;
    public static final double NEUTRAL_DEADBAND = .1;
    public static final int PID_TURN = 0;

    public static final double P = 1;
    public static final double I = 1;
    public static final double D = 1;
    public static final double F = 1;
    public static final double MAX_SPEEED = 6380;

    public static final int PID_DISTANCE = 0;
    public static final int PID_TURNING = 1;

    public static final int PID_TURNING_IZONE = 1;
    public static final double PID_TURNING_PEAK_OUTPUT = 1;

    public static final int PID_DISTANCE_IZONE = 1;
    public static final double PID_DISTANCE_PEAK_OUTPUT = 1;

    public enum MotorPosition {
        FL, FR, BL, BR, AVG
    };

    public static double getGearboxRatio(){
        if(GB_STATUS == GearboxPosition.Hi)
            return HI_GEARBOX_RATIO;
        else
            return LO_GEARBOX_RATIO;
    }

    public static GearboxPosition toggleGearboxPosition(){
        switch(GB_STATUS) { 
            case Hi:
                GB_STATUS = GearboxPosition.Lo;
                break;
            case Lo:
                GB_STATUS = GearboxPosition.Hi;
                break;
        }
        return GB_STATUS;
    }

    public static double getRevs(double inches){
        return getGearboxRatio() * WHEEL_CIRCUMFRENCE_INCHES * inches;
    }
}