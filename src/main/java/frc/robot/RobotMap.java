package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorMatch;

public class RobotMap{
    public static final int FL_PORT = 1; //Falcon 500/TalonFX ports
    public static final int FR_PORT = 3;
    public static final int BL_PORT = 2;
    public static final int BR_PORT = 4;

    public static final int T_REY_PORT = 5; //TalonSRX ports
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

    public static final I2C.Port i2cPort = I2C.Port.kOnboard; //I2C ports for gyro

    public static final int SOLENOID_PORT = 1;

    public static final int JOYL_PORT = 0; //Joystick USB ports
    public static final int JOYR_PORT = 1;
    
    public static final int HOPPER_BUTTON = 2; //Joystick button #s for each function
    public static final int WOF_BUTTON = 3;
    public static final int INTAKE_BUTTON = 1;
    public static final int OUTPUT_BUTTON = 1;
    public static final int CLIMBER_UP_BUTTON = 3;
    public static final int CLIMBER_DOWN_BUTTON = 2;

    public enum JOYSIDE { //Enum for OI class methods
        Left, Right
    };

    public static final double TELE_LIFT_SPEED = -.5;
    public static final double WINCH_LIFT_SPEED = .5;
    public static final double HOPPER_LIFT_SPEED = 1;

    public static final double AUTO_SPEED = .5; //Speed value for auto

    public static final double ROTATION_TOLERANCE = 3; //Auto angle tolerance in degrees

    public static final double DEADZONE = .2; //Joystick deadzone
    
    public static final int WHEEL_DIAMETER_INCHES = 8; //Wheel diameter in inches
    public static final double WHEEL_CIRCUMFRENCE_INCHES = 2 * WHEEL_DIAMETER_INCHES * Math.PI; //Wheel circumfrence in inches

    public static final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429); //Color constants
    public static final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    public static final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    public static final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    public enum ColorType { //WOF color enum 
        Blue, Red, Yellow, Green, UNKNOWN
    };
   
    public static final double LEFT_START_TURN_ANGLE = 57; //Angles for first step of auto TurnToPort
    public static final double RIGHT_START_TURN_ANGLE = 59.7;
    public static final double MIDDLE_START_TURN_ANGLE = 27.4;

    //Distances for auto second step in inches
    public static final double RIGHT_DISTANCE = 231.6;
    public static final double LEFT_DISTANCE = 129.1;
    public static final double MIDDLE_DISTANCE =127;
    public static final double PREFFERED_DISTANCE = 108;

    public enum PathDirection { //For auto drive/turn methods. Direction for pathfinding
        Direct, Reverse
    };

    public enum StartingPosition { //Enum for auto starting position
        Left, Right, Middle, Preffered
    };

    private static GearboxPosition GB_STATUS = GearboxPosition.Lo; //Var for storing gearbox position
    public static final double LO_GEARBOX_RATIO = 1; //Ratios for different gearbox settings
    public static final double HI_GEARBOX_RATIO = 1;

    public enum GearboxPosition { //Enum for the pneumatic shifting gearbox position
        Hi, Lo
    };

    public static final boolean GB_SOL_HI = true;
    public static final boolean GB_SOL_LO = false;

    public static StartingPosition convertStartingPosition(String str){ //Translator for SendableChooser<String> 
        if(str.equals("L")){                                            //input to StartingPosition output
            return StartingPosition.Left;
        }else if(str.equals("R")){
            return StartingPosition.Right;
        }else if(str.equals("M")){
            return StartingPosition.Middle;
        }else{
            return StartingPosition.Preffered;
        }
    }

    public static double getGearboxRatio(){ //Accessor for returning gearbox ratio based off position
        if(GB_STATUS == GearboxPosition.Hi)
            return HI_GEARBOX_RATIO;
        else
            return LO_GEARBOX_RATIO;
    }

    public static GearboxPosition toggleGearboxPosition(){ //Changes setting of GB_STATUS for shifting
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

    public static int getDirCoef(double distance){
        if(distance < 0)
            return -1;
        else if(distance > 0)
            return 1;
        else 
            return 0;
    }

    public enum WOF_Stage { //Wheel Of Fortune stage enum for determining current stage
        STAGE_ONE, STAGE_TWO
    };
}