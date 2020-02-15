/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap.*;
import frc.robot.commandGroups.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 

  //public final DrivetrainKB drivetrainKB = new DrivetrainKB();

//IMPLEMENT COMMAND GROUPS

  public CommandBase s_autoCommand;
  public CommandBase s_driveCommand;
  
  AutoGroup autoGroup;
  CommandBase unloadHop;
  CommandBase climberUp;
  CommandBase climberDown;

  public SendableChooser<String> initPos = new SendableChooser<String>();
  public SendableChooser<CommandBase> startingPosSelect = new SendableChooser<CommandBase>();
  public static Drivetrain s_drive;
  public static Hopper s_hopper;
  public static WOF s_wof;
  public static OI s_oi;
  public static Intake s_intake; 
  public static Climber s_climb;
  public static Gearbox s_gearbox;

  public static WOF_Stage wofStage = WOF_Stage.STAGE_ONE;

  public static ControlPanelStageOne CtrlOne;
  public static ControlPanelStageTwo CtrlTwo;
  public static ShiftDown shiftDown;
  public static ShiftUp shiftUp;
  public static AutoShift autoShift;

  // wofRaisebutt,togglebutt,lower 
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    s_wof = new WOF();
    s_oi = new OI();
    s_intake = new Intake();
    s_climb = new Climber();
    s_drive = new Drivetrain();
    s_hopper = new Hopper();
    s_gearbox = new Gearbox();
      
    s_driveCommand = new DriveCommand(s_drive, s_oi);
    s_autoCommand = new DriveCommand(s_drive, s_oi);
   // final TeleGroup teleGroup = new TeleGroup(Robot.s_drive, Robot.s_hopper, Robot.s_climb, Robot.s_intake, Robot.s_hopper);//s_climb, in, s_hopper
   
    unloadHop = new UnloadHopper(s_hopper);

    CtrlOne = new ControlPanelStageOne(s_wof, this);
    CtrlTwo = new ControlPanelStageTwo(s_wof);
    
    shiftDown = new ShiftDown(s_gearbox);
    shiftUp = new ShiftUp(s_gearbox);
    autoShift = new AutoShift(s_gearbox);
    // Configure the button bindings
   
    //Robot.s_drive.setDefaultCommand(teleGroup);
    //Robot.s_wof.setDefaultCommand(s_autoCommand);

    initPos.addOption("Left", "L");
    initPos.addOption("Middle", "M");  
    initPos.addOption("Right", "R");
    initPos.setDefaultOption("Preferred", "P");
    
    SmartDashboard.putData(initPos);
    SmartDashboard.putBoolean("Top Limit Switch", s_climb.upperLimit.get());

    SmartDashboard.putNumber("FL Encoder Value", s_drive.getLeftEncoderPosition());

    SmartDashboard.putBoolean("isBlue", s_wof.booleanBlue);
    SmartDashboard.putBoolean("isGreen", s_wof.booleanGreen);
    SmartDashboard.putBoolean("isRed", s_wof.booleanRed);
    SmartDashboard.putBoolean("isYellow", s_wof.booleanYellow);
    
    configureButtonBindings();
  }

  // public Drivetrain getDT(){
  //   return s_drive;
  // }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {

    s_oi.hopButt.whenPressed(new UnloadHopper(s_hopper));

    if(wofStage == WOF_Stage.STAGE_ONE)
      s_oi.wofButt.whenPressed(CtrlOne);
    else 
      s_oi.wofButt.whenPressed(CtrlTwo);

    s_oi.climbUpButt.whenHeld( new ClimberUp(s_climb));//code for telling the climber when to go up and when to go down
    s_oi.climbUpButt.whenReleased(new ClimberStop(s_climb));

    s_oi.climbDownButt.whenHeld(new ClimberDown(s_climb));
    s_oi.climbDownButt.whenReleased(new ClimberStop(s_climb));//when the buttons arent held the climber will stop
    
    s_oi.shiftDownButt.whenPressed(new ShiftDown(s_gearbox));
    s_oi.shiftUpButt.whenPressed(new ShiftUp(s_gearbox));
    s_oi.autoShiftButt.whenPressed(new AutoShift(s_gearbox));
  }

  public void configWOFButton(WOF_Stage stage){
    wofStage = stage;
    if(wofStage == WOF_Stage.STAGE_ONE)
      s_oi.wofButt.whenPressed(CtrlOne);
    else 
      s_oi.wofButt.whenPressed(CtrlTwo);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public CommandBase getAutonomousCommand() {

   // s_autoCommand = AutoGroup;
    return s_autoCommand;
  }

  // public CommandGroup getTeleopCommand(){
  //   return teleGroup;
  // }

  public StartingPosition getStartingPosition(){
    switch (initPos.getSelected()) {
      case "R":
        return StartingPosition.Right;
      case "M":
        return StartingPosition.Middle;
      case "L":
        return StartingPosition.Left;
      case "P":
        return StartingPosition.Preffered;
      default:
        return null;
    }
  }

  public void configAutoGroup(){
    autoGroup = new AutoGroup(getStartingPosition(), s_drive, s_hopper);
  }
  
}