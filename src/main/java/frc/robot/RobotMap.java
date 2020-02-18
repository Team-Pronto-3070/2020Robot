package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
    public static final int T_WINCH_PORT = T_ASHOKA_PORT;
    public static final int T_HOPPER_PORT = T_ANAKIN_PORT;
    public static final int T_TELE_PORT = T_OBIWAN_PORT;
    public static final int T_BELT1_PORT = T_REVAN_PORT;
    public static final int T_BELT2_PORT = T_BASTILA_PORT;

    public static final I2C.Port i2cPort = I2C.Port.kOnboard; //I2C ports for gyro

    public static final int ARM_SOL_PORT_ONE = 0;
    public static final int ARM_SOL_PORT_TWO = 1;

    public static final int GB_SOL_PORT_ONE = 2;
    public static final int GB_SOL_PORT_TWO = 3;

    public static final Value ARM_SOL_ON = Value.kForward;
    public static final Value ARM_SOL_OFF = Value.kReverse;

    public static final Value GB_SOL_ON = Value.kForward;
    public static final Value GB_SOL_OFF = Value.kReverse;

    public static final int JOYL_PORT = 0; //Joystick USB ports
    public static final int JOYR_PORT = 1;

    //Joystick button #s for each function
    public static final int HOPPER_BUTTON = 2;
    public static final int WOF_BUTTON = 3;
    public static final int INTAKE_BUTTON = 1;
    public static final int OUTPUT_BUTTON = 1;
    public static final int CLIMBER_UP_BUTTON = 2; 
    public static final int CLIMBER_DOWN_BUTTON = 3; 
    public static final int SHIFT_UP_BUTTON = 4;
    public static final int SHIFT_DOWN_BUTTON = 5;
    public static final int AUTOSHIFT_BUTTON = 2;
    public static final int RAISE_ARM_BUTTON = 9; 
    public static final int TOGGLE_ARM_BUTTON = 9;
    public static final int LOWER_ARM_BUTTON = 10;
    public static final int START_COMP_BUTTON = 11;
    public static final int STOP_COMP_BUTTON = 12;
    public static final int TOGGLE_COMP_BUTTON = 6;

    public static final int COMPRESSOR_PORT = 0;
    
//raise/toggle/lower armbutt
    public enum JOYSIDE { //Enum for OI class methods
        Left, Right
    };

    public static final int HOPPER_ID = 0; //IDs for each button in BUTTON_SIDES array for configureButtonBindings in OI
    public static final int WOF_ID = 1;
    public static final int INTAKE_ID = 2;
    public static final int OUTPUT_ID = 3;
    public static final int CL_UP_ID = 4;
    public static final int CL_DOWN_ID = 5;
    public static final int SH_UP_ID = 6;
    public static final int SH_DWN_ID = 7;
    public static final int SH_AU_ID = 8;
    public static final int RA_AR_ID = 9;
    public static final int TOG_AR_ID = 10;
    public static final int LOW_AR_ID = 11;
    public static final int START_COMP_ID = 12;
    public static final int STOP_COMP_ID = 13;
    public static final int TOGGLE_COMP_ID = 14;

    public static final JOYSIDE[] BUTTON_SIDES = new JOYSIDE[]{JOYSIDE.Left, JOYSIDE.Left, JOYSIDE.Right, 
                                                            // Hopper,       WOF,          Intake
                                                               JOYSIDE.Right, JOYSIDE.Right, JOYSIDE.Right,
                                                            // Output,        Climber down, Climber Up
                                                               JOYSIDE.Left, JOYSIDE.Right, JOYSIDE.Right,
                                                            // Shift Up,     Shift down,    Autoshift
                                                               JOYSIDE.Left, JOYSIDE.Right, JOYSIDE.Right,
                                                            // Raise arm     Toggle arm     Lower arm
                                                               JOYSIDE.Left, JOYSIDE.Left, JOYSIDE.Right
                                                            // Start comp,   Stop comp,    Toggle comp
                                                            };
    public static final double TELE_LIFT_SPEED = 1;
    public static final double WINCH_LIFT_SPEED = .5;
    public static final double HOPPER_LIFT_SPEED = 1;
    public static final double WOF_TURN_SPEED = .6;
    public static final int WOF_WAIT_PERIOD = 1;
    public static final int WOF_ROTATIONS = 3;
    public static final int WOF_PASSES = WOF_ROTATIONS * 2;

    public static final double AUTO_SPEED = .5; //Speed value for auto

    public static final double ROTATION_TOLERANCE = 1; //Auto angle tolerance in degrees

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
    public static final double MIDDLE_DISTANCE = 127;
    public static final double PREFFERED_DISTANCE = 108;

    public enum PathDirection { //For auto drive/turn methods. Direction for pathfinding
        Direct, Reverse
    };

    public enum StartingPosition { //Enum for auto starting position
        Left, Right, Middle, Preffered
    };

    public static final double FIRST_STAGE_GB_RATIO = 40 / 12; //Input 12, output 40
    public static final double LO_GEARBOX_RATIO = 60 / 24; //Ratios for different gearbox settings
    public static final double HI_GEARBOX_RATIO = 44 / 40;
    public static final double THIRD_STAGE_GB_RATIO = 54 / 30; //Input 30, output 54


    public enum GearboxPosition { //Enum for the pneumatic shifting gearbox position
        Hi, Lo
    };

    public static final int CAMERA_PORT = 0;
    public static final int CAMERA_EXPOSURE = 80;
    public static final int CAMERA_X = 320;
    public static final int CAMERA_Y = 240;

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

    public static double getGearboxRatio(GearboxPosition pos){ //Accessor for returning gearbox ratio based off position
        if(pos == GearboxPosition.Hi)
            return HI_GEARBOX_RATIO * FIRST_STAGE_GB_RATIO * THIRD_STAGE_GB_RATIO;
        else
            return LO_GEARBOX_RATIO * FIRST_STAGE_GB_RATIO * THIRD_STAGE_GB_RATIO;
    }

    public static GearboxPosition toggleGearboxPosition(GearboxPosition pos){ //Changes setting of pos for shifting
        switch(pos) { 
            case Hi:
                pos = GearboxPosition.Lo;
                break;
            case Lo:
                pos = GearboxPosition.Hi;
                break;
        }
        return pos;
    }

    public static int getDirCoef(double distance){
        if(distance < 0)
            return -1;
        else if(distance > 0)
            return 1;
        else 
            return 0;
    }
    
    public static JOYSIDE getButtonJoyside(int id){
        return BUTTON_SIDES[id];
    }

    public enum WOF_Stage { //Wheel Of Fortune stage enum for determining current stage
        STAGE_ONE, STAGE_TWO
    };

    public static double revsPerInch(GearboxPosition pos){
        return getGearboxRatio(pos) / WHEEL_CIRCUMFRENCE_INCHES;        
    }
}