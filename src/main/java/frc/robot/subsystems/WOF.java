package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.RobotMap.*;

public class WOF extends SubsystemBase {
    public TalonSRX t_WOF; //Motor object
    Color clr; //Var for storing color sensed by color sensor
    int passes = 0; //# of completed passes of single color. * 2 = # of full rotations

    public boolean[] colorBooleans = new boolean[4]; //Boolean for each color - to be put up on SmartDashboard

    public DoubleSolenoid armSol; //Solenoid object
    
    ColorSensorV3 s_colorSensor; //Color sensor object

    private final ColorMatch m_colorMatcher = new ColorMatch(); //Color Matcher object for sensing status of WOF

    final int BLUE = 0;
    final int GREEN = 1;
    final int RED = 2;
    final int YELLOW = 3;

    //Constructor
    public WOF(){
        t_WOF = new TalonSRX(RobotMap.T_WOF_PORT);
        
        s_colorSensor = new ColorSensorV3(RobotMap.i2cPort);

        armSol = new DoubleSolenoid(RobotMap.ARM_SOL_PORT_ONE, RobotMap.ARM_SOL_PORT_TWO);
        
        addColorsToMatcher();
    }

    @Override
    public void periodic()
    {
        // write RGB, and HSV value from color sensor to dashboard
        // Write result enum value to dashboard
       setDashColor();
    }

    public void setDashColor(){
        
        // if(getClosestColor() == ColorType.Blue){
        //just checks if the color sensor's blue value is the highest    
        if(Math.max(s_colorSensor.getBlue(), Math.max(s_colorSensor.getGreen(), s_colorSensor.getRed())) == s_colorSensor.getBlue()){
            resetColorBool();
            colorBooleans[BLUE] = true;
        // }else if(getClosestColor() == ColorType.Green){
        }else if(Math.max(s_colorSensor.getGreen(), Math.max(s_colorSensor.getBlue(), s_colorSensor.getRed())) == s_colorSensor.getGreen()){
            resetColorBool();
            colorBooleans[GREEN] = true;
        // }else if(getClosestColor() == ColorType.Red){
        }else if(Math.max(s_colorSensor.getRed(), Math.max(s_colorSensor.getGreen(), s_colorSensor.getBlue())) == s_colorSensor.getRed()){
            resetColorBool();
            colorBooleans[RED] = true;
        // }else if(getClosestColor() == ColorType.Yellow){
        }else if(Math.abs(s_colorSensor.getBlue() - s_colorSensor.getGreen()) < 20){
            resetColorBool();
            colorBooleans[YELLOW] = true;
        } 

        SmartDashboard.putBoolean("isBlue", colorBooleans[BLUE]);
        SmartDashboard.putBoolean("isGreen", colorBooleans[GREEN]);
        SmartDashboard.putBoolean("isRed", colorBooleans[RED]);
        SmartDashboard.putBoolean("isYellow", colorBooleans[YELLOW]);
    }

    public void stop(){ //If you need this comment, you shouldn't be reading this code
        t_WOF.set(ControlMode.PercentOutput, 0);
    }

    public void go(){
        t_WOF.set(ControlMode.PercentOutput, RobotMap.WOF_TURN_SPEED); //Begins the wheel spinning
    }

    public Color getSensorColor(){
        // System.out.println( s_colorSensor.getRed()); 
        // System.out.println(s_colorSensor.getBlue());
        // System.out.println(s_colorSensor.getGreen());
        SmartDashboard.putNumber("Red", s_colorSensor.getRed());
        SmartDashboard.putNumber("Green", s_colorSensor.getGreen());
        SmartDashboard.putNumber("Blue", s_colorSensor.getBlue());
        return ColorMatch.makeColor(s_colorSensor.getRed(), s_colorSensor.getGreen(), s_colorSensor.getBlue());
    }

    public int getIR(){
        return s_colorSensor.getIR();
    }

    public int getProximity(){
        return s_colorSensor.getProximity();
    }

    public void addColorsToMatcher(){ //Adds each of the colors to the list of possibles in colorMatcher
        m_colorMatcher.addColorMatch(RobotMap.kBlueTarget);
        m_colorMatcher.addColorMatch(RobotMap.kGreenTarget);
        m_colorMatcher.addColorMatch(RobotMap.kRedTarget);
        m_colorMatcher.addColorMatch(RobotMap.kYellowTarget);    
    }

    public ColorType getClosestColor(){
        //System.out.println("In the start of getClosestColor");
        setColor();
       // System.out.println("sets color");

        ColorMatchResult match = m_colorMatcher.matchClosestColor(clr);
        //System.out.println("start of matching");
          if (match.color == RobotMap.kBlueTarget) {
            return ColorType.Blue;
        } else if (match.color == RobotMap.kRedTarget) {
            return ColorType.Red;
        } else if (match.color == RobotMap.kGreenTarget) {
            return ColorType.Green;
        } else if (match.color == RobotMap.kYellowTarget) {
            return ColorType.Yellow;
        } else {
            System.out.println("end of matching");
            return ColorType.UNKNOWN;
        }
        
    }

    public void setColor(){ //Sets clr to the value seen by the color sensor
        clr = getSensorColor();
    }

    public void moveArm(Value val){ //Actuates arm
        armSol.set(val);
    }

    public boolean getBooleanBlue(){ //Accessors for color booleans
        return colorBooleans[BLUE];
    }

    public boolean getBooleanGreen(){
        return colorBooleans[GREEN];
    }

    public boolean getBooleanRed(){
        return colorBooleans[RED];
    }

    public boolean getBooleanYellow(){
        return colorBooleans[RED];
    }

    public void resetColorBool(){ //Sets all of colorBool to false
        for(int i = 0; i < 4; i++){
            colorBooleans[i] = false;
        }
    }
}