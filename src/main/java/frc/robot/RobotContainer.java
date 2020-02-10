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
import frc.robot.commandGroups.*;
import frc.robot.commands.*;
import frc.robot.commands.LeftStart.*;
import frc.robot.commands.MiddleStart.*;
import frc.robot.commands.PreferredStart.*;
import frc.robot.commands.RightStart.*;
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

  public CommandBase m_autoCommand;
  public CommandBase m_driveCommand;
  
  AutoGroup autoGroup;
  CommandBase unloadHop;

  public SendableChooser<String> initPos = new SendableChooser<String>();
  public static Drivetrain drive;
  public static Hopper hop;
  public static WOF wof;
  public static OI m_oi;
  public static Intake intake; 
  public static Climber climb;
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer(boolean kitbot) {
    
    
    wof = new WOF();
    m_oi = new OI();
    intake = new Intake();
    climb = new Climber();

    if(kitbot)
      drive = new DrivetrainKB(); 
    else
      drive = new Drivetrain();
      
    m_driveCommand = new DriveCommand(drive, m_oi);
    m_autoCommand = new DriveCommand(drive, m_oi);
   // final TeleGroup teleGroup = new TeleGroup(Robot.drive, Robot.hop, Robot.climb, Robot.intake, Robot.hop);//climb, in, hop

   
   unloadHop = new UnloadHopper(hop);


    //driveAuto = new AutoGroup(initPos, Robot.drive, Robot.hop);
    // Configure the button bindings
    configureButtonBindings();
    //Robot.drive.setDefaultCommand(teleGroup);
    //Robot.wof.setDefaultCommand(m_autoCommand);

    initPos.addOption("Left", "L");
    initPos.addOption("Middle", "M");
    initPos.addOption("Preferred", "P");  
    initPos.addOption("Right", "R");

    SmartDashboard.putData(initPos);

    autoGroup = new AutoGroup(RobotMap.convertStartingPosition(initPos.getSelected()), drive, hop);
  }

  // public Drivetrain getDT(){
  //   return drive;
  // }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  m_oi.hopButt.whenPressed(unloadHop);

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public CommandBase getAutonomousCommand() {

   // m_autoCommand = AutoGroup;
    return m_autoCommand;
  }

  // public CommandGroup getTeleopCommand(){
  //   return teleGroup;
  // }

  public RobotMap.StartingPosition getStartingPosition(){
    RobotMap.StartingPosition startPos = RobotMap.StartingPosition.Preffered;
    switch (initPos.getSelected()) {
      case "R":
        return RobotMap.StartingPosition.Right;
      case "M":
        return RobotMap.StartingPosition.Middle;
      case "L":
        return RobotMap.StartingPosition.Left;
      case "P":
        return RobotMap.StartingPosition.Preffered;
    }
    return startPos;
  }
  
}
















































































































































































































































































































//haha butt