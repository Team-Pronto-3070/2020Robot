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
  
  public SendableChooser<String> initPos = new SendableChooser<String>();
  public SendableChooser<CommandBase> startingPosSelect = new SendableChooser<CommandBase>();
  public static Drivetrain s_drive;
  public static Hopper s_hopper;
  public static WOF s_wof;
  public static OI s_oi;
  public static GroundIntake s_intake; 
  public static Climber s_climb;
  public static Gearbox s_gearbox;

  public static WOF_Stage wofStage = WOF_Stage.STAGE_ONE;

  public RobotContainer() {
    s_wof = new WOF();
    s_oi = new OI();
    s_intake = new GroundIntake();
    s_climb = new Climber();
    s_hopper = new Hopper();
    s_gearbox = new Gearbox();
    s_drive = new Drivetrain(s_gearbox);

    initPos.addOption("Left", "L");
    initPos.addOption("Middle", "M");  
    initPos.addOption("Right", "R");
    initPos.setDefaultOption("Preferred", "P");
    
    SmartDashboard.putData(initPos);
    SmartDashboard.putBoolean("Top Limit Switch", s_climb.upperLimit.get());

    SmartDashboard.putNumber("FL Encoder Value", s_drive.getLeftEncoderPosition());
    
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
    s_oi.hopButt.whenPressed(new UnloadHopper(s_hopper));
    s_oi.hopButt.whenReleased(new StopHopper(s_hopper));
    configWOFButton(wofStage);
    s_oi.wofButt.whenReleased(new StopWOF(s_wof));
    s_oi.climbUpButt.whenHeld( new ClimberUp(s_climb));
    s_oi.climbDownButt.whenHeld(new ClimberDown(s_climb));
    s_oi.climbDownButt.whenReleased(new ClimberStop(s_climb));//when the buttons arent held the climber will stop
    s_oi.shiftDownButt.whenPressed(new ShiftDown(s_gearbox));
    s_oi.shiftUpButt.whenPressed(new ShiftUp(s_gearbox));
    s_oi.autoShiftButt.whenPressed(new AutoShift(s_gearbox));
  }

  public void configWOFButton(WOF_Stage stage){
    wofStage = stage;
    if(wofStage == WOF_Stage.STAGE_ONE)
      s_oi.wofButt.whenPressed(new ControlPanelStageOne(s_wof, this));
    else 
      s_oi.wofButt.whenPressed(new ControlPanelStageTwo(s_wof));
  }

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

  public boolean getBooleanBlue(){
    return s_wof.getBooleanBlue();
  }

  public boolean getBooleanGreen(){
    return s_wof.getBooleanGreen();
  }

  public boolean getBooleanRed(){
    return s_wof.getBooleanRed();
  }

  public boolean getBooleanYellow(){
    return s_wof.getBooleanYellow();
  }
  
  public void setDashColor(){
    s_wof.setDashColor();
  }

  public void scheduleAutoGroup(){
    new AutoGroup(getStartingPosition(), s_drive, s_hopper).schedule();
  }

  public void scheduleDriveCommand(){
    new DriveCommand(s_drive, s_oi).schedule();
  }
}